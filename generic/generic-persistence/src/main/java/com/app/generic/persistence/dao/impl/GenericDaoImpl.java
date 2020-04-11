package com.app.generic.persistence.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import com.app.generic.core.constant.ErrorConstant;
import com.app.generic.core.exception.GeneralException;
import com.app.generic.persistence.dao.GenericDao;
import com.app.generic.persistence.dto.Range;
import com.app.generic.persistence.enums.Condition;
import com.app.generic.persistence.enums.Order;
import com.app.generic.persistence.model.GenericModel;

public abstract class GenericDaoImpl<M extends GenericModel, ID extends Serializable> implements GenericDao<M, ID> {

	protected EntityManager entityManager;
	private Class<M> entityClass;

	public static final Integer PAGING_MAX_RECORD = 20;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	public Class<M> getEntityClass() {
		if (entityClass == null) {
			entityClass = (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];
		}
		return entityClass;
	}

	public void setEntityClass(Class<M> entityClass) {
		this.entityClass = entityClass;
	}

	/* get by id method to be used in engines dao classes implementation */
	public M get(ID id) {
		M entity = this.entityManager.find(getEntityClass(), id);
		if (entity == null) {
			throw new GeneralException(ErrorConstant.DATA_NOT_FOUND);
		}
		return entity;
	}

	/* remove method to be used in engines dao classes implementation */
	@Transactional
	public void remove(ID id) {
		M entity = get(id);
		if (entity != null) {
			this.entityManager.remove(entity);
		}
	}

	/* update method to be used in engines dao classes implementation */
	@Transactional
	public M save(M entity) {
		return this.entityManager.merge(entity);
	}

	/* getAll method to be used in engines dao classes implementation */
	@SuppressWarnings("unchecked")
	public List<M> getAll() {
		return this.entityManager.createQuery("Select entity FROM " + getEntityClass().getSimpleName() + " entity")
				.getResultList();
	}

	public List<M> getAllDistinct() {
		Collection<M> result = new LinkedHashSet<>(getAll());
		return new ArrayList<>(result);
	}

	public List<M> getPagingResults(Integer firstResult, Integer maxResults, String orderBy, Order order) {

		CriteriaBuilder qb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<M> cq = qb.createQuery(this.getEntityClass());
		Root<M> clazz = cq.from(this.getEntityClass());
		if (orderBy != null && !orderBy.equals("")) {
			if (order.equals(Order.DESC)) {
				cq.select(clazz).orderBy(qb.desc(clazz.get(orderBy)));
			} else {
				cq.select(clazz).orderBy(qb.asc(clazz.get(orderBy)));
			}
		} else {
			cq.select(clazz);
		}
		return this.entityManager.createQuery(cq).setFirstResult(firstResult)
				.setMaxResults((String.valueOf(maxResults) == null ? PAGING_MAX_RECORD : maxResults)).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public Long getRecordCount() {
		CriteriaBuilder qb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = qb.createQuery(Long.class);
		Root<M> cc = cq.from(this.getEntityClass());
		cq.select(qb.count(cc));
		List list = this.entityManager.createQuery(cq).getResultList();
		return list.isEmpty() ? null : (Long) list.get(0);
	}

	@Override
	public Long getRecordCount(Map<String, Object> parameters, Condition condition) {
		CriteriaBuilder qb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = qb.createQuery(Long.class);
		List<Predicate> predicates = new ArrayList<>();
		Root<M> cc = cq.from(this.getEntityClass());

		if (parameters != null && !parameters.isEmpty()) {
			if (condition.equals(Condition.EQUAL)) {
				for (Entry<String, Object> param : parameters.entrySet()) {
					predicates.add(qb.equal(cc.get(param.getKey()), param.getValue()));
				}
			} else if (condition.equals(Condition.LIKE)) {
				Predicate[] predicates2 = new Predicate[parameters.size()];
				int i = 0;
				for (Entry<String, Object> param : parameters.entrySet()) {
					predicates2[i++] = qb.like(qb.upper(cc.get(param.getKey())),
							"%" + param.getValue().toString().toUpperCase() + "%");
				}
				predicates.add(qb.or(predicates2));
			}
		}

		cq.select(qb.count(cc)).where(predicates.toArray(new Predicate[] {}));
		List<?> list = this.entityManager.createQuery(cq).getResultList();
		return list.isEmpty() ? null : (Long) list.get(0);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Long getRecordCount(Map<String, Object> parameters, Range<?> range) {
		CriteriaBuilder qb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = qb.createQuery(Long.class);
		List<Predicate> predicates = new ArrayList<>();
		Root<M> cc = cq.from(this.getEntityClass());

		if (parameters != null && !parameters.isEmpty()) {
			for (Entry<String, Object> param : parameters.entrySet()) {
				predicates.add(qb.equal(cc.get(param.getKey()), param.getValue()));
			}
		}
		predicates.add(qb.between(cc.get(range.getName()), (Comparable) range.getStart(), (Comparable) range.getEnd()));
		cq.select(qb.count(cc)).where(predicates.toArray(new Predicate[] {}));
		List<?> list = this.entityManager.createQuery(cq).getResultList();
		return list.isEmpty() ? null : (Long) list.get(0);
	}

	@Override
	public List<M> getAllBy(Integer firstResult, Integer maxResult, String orderBy, Order order,
			Map<String, Object> parameters, Condition condition) {
		switch (condition) {
		case EQUAL:
			return getAllByEqualParameter(firstResult, maxResult, orderBy, order, parameters);
		case LIKE:
			return getAllByLikeParameter(firstResult, maxResult, orderBy, order, parameters);
		default:
			throw new GeneralException(ErrorConstant.FATAL_ERROR);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<M> getAllByAndBetween(Integer firstResult, Integer maxResult, String orderBy, Order order,
			Map<String, Object> parameters, Range<?> range) {
		try {
			CriteriaBuilder qb = this.entityManager.getCriteriaBuilder();
			CriteriaQuery<M> cq = qb.createQuery(this.getEntityClass());
			List<Predicate> predicates = new ArrayList<>();
			Root<M> clazz = cq.from(this.getEntityClass());

			if (parameters != null && !parameters.isEmpty()) {
				for (Entry<String, Object> param : parameters.entrySet()) {
					predicates.add(qb.equal(clazz.get(param.getKey()), param.getValue()));
				}
			}
			predicates.add(
					qb.between(clazz.get(range.getName()), (Comparable) range.getStart(), (Comparable) range.getEnd()));
			if (orderBy != null && !orderBy.equals("")) {
				if (order.equals(Order.DESC)) {
					cq.select(clazz).where(predicates.toArray(new Predicate[] {})).orderBy(qb.desc(clazz.get(orderBy)));
				} else {
					cq.select(clazz).where(predicates.toArray(new Predicate[] {})).orderBy(qb.asc(clazz.get(orderBy)));
				}
			} else {
				cq.select(clazz).where(predicates.toArray(new Predicate[] {}));
			}

			Query query = this.entityManager.createQuery(cq);
			if (firstResult != null && maxResult != null) {
				query.setFirstResult(firstResult)
						.setMaxResults((String.valueOf(maxResult) == null ? PAGING_MAX_RECORD : maxResult));
			}
			return query.getResultList();
		} catch (Exception e) {
			throw new GeneralException(ErrorConstant.INVALID_PARAMETER);
		}
	}

	private List<M> getAllByEqualParameter(Integer firstResult, Integer maxResult, String orderBy, Order order,
			Map<String, Object> parameters) {
		try {
			CriteriaBuilder qb = this.entityManager.getCriteriaBuilder();
			CriteriaQuery<M> cq = qb.createQuery(this.getEntityClass());
			List<Predicate> predicates = new ArrayList<>();
			Root<M> clazz = cq.from(this.getEntityClass());

			if (parameters != null && !parameters.isEmpty()) {
				for (Entry<String, Object> param : parameters.entrySet()) {
					predicates.add(qb.and(qb.equal(clazz.get(param.getKey()), param.getValue())));
				}
			}
			if (orderBy != null && !orderBy.equals("")) {
				if (order.equals(Order.DESC)) {
					cq.select(clazz).where(predicates.toArray(new Predicate[] {})).orderBy(qb.desc(clazz.get(orderBy)));
				} else {
					cq.select(clazz).where(predicates.toArray(new Predicate[] {})).orderBy(qb.asc(clazz.get(orderBy)));
				}
			} else {
				cq.select(clazz).where(predicates.toArray(new Predicate[] {}));
			}
			
			return this.entityManager.createQuery(cq).setFirstResult(firstResult)
					.setMaxResults((String.valueOf(maxResult) == null ? PAGING_MAX_RECORD : maxResult)).getResultList();
		} catch (Exception e) {
			throw new GeneralException(ErrorConstant.INVALID_PARAMETER);
		}
	}

	@SuppressWarnings("unchecked")
	private List<M> getAllByLikeParameter(Integer firstResult, Integer maxResult, String orderBy, Order order, Map<String, Object> parameters) {
		try {
			CriteriaBuilder qb = this.entityManager.getCriteriaBuilder();
			CriteriaQuery<M> cq = qb.createQuery(this.getEntityClass());
			List<Predicate> predicates = new ArrayList<>();
			Root<M> clazz = cq.from(this.getEntityClass());

			if (parameters != null && !parameters.isEmpty()) {
				Predicate[] predicates2 = new Predicate[parameters.size()];
				int i = 0;
				for (Entry<String, Object> param : parameters.entrySet()) {
					predicates2[i++] = qb.like(qb.upper(clazz.get(param.getKey())),
							"%" + param.getValue().toString().toUpperCase() + "%");
				}
				predicates.add(qb.or(predicates2));
			}
			if (orderBy != null && !orderBy.equals("")) {
				if (order.equals(Order.DESC)) {
					cq.select(clazz).where(predicates.toArray(new Predicate[] {})).orderBy(qb.desc(clazz.get(orderBy)));
				} else {
					cq.select(clazz).where(predicates.toArray(new Predicate[] {})).orderBy(qb.asc(clazz.get(orderBy)));
				}
			} else {
				cq.select(clazz).where(predicates.toArray(new Predicate[] {}));
			}
			
			Query query = this.entityManager.createQuery(cq);
			if (firstResult != null && maxResult != null) {
				query.setFirstResult(firstResult)
						.setMaxResults((String.valueOf(maxResult) == null ? PAGING_MAX_RECORD : maxResult));
			}
			return query.getResultList();
		} catch (Exception e) {
			throw new GeneralException(ErrorConstant.INVALID_PARAMETER);
		}
	}
}
