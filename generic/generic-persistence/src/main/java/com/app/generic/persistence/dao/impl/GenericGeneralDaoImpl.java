/*
* ATI - CORE -TPE
* Transaction Processing Engine(TPE)
* @Author- V.N.V.L.PRASANNA 
*/

package com.app.generic.persistence.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import com.app.generic.core.constant.ErrorConstant;
import com.app.generic.core.exception.GeneralException;
import com.app.generic.persistence.dao.GenericGeneralDao;

public abstract class GenericGeneralDaoImpl<M , ID extends Serializable> implements GenericGeneralDao<M, ID> {

	protected EntityManager entityManager;
	private Class<M> entityClass;
	
	public static final Integer PAGING_MAX_RECORD = 20;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public EntityManager getEntityManager(Class<?> clazz) {
		this.entityClass = (Class<M>) clazz;
		return entityManager;
	}
	
	@PersistenceContext	//TODO (name="")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	public Class<M> getEntityClass() {
		if (entityClass == null) {
			entityClass = (Class<M>) ((ParameterizedType) getClass().
					getGenericSuperclass()).getActualTypeArguments()[0];
		}
		return entityClass;
	}
	
	@SuppressWarnings("unchecked")
	public Class<M> getEntityClass(Class<?> clazz) {
		if (entityClass == null) {
			entityClass = (Class<M>) clazz;
		}
		return entityClass;
	}

	public void setEntityClass(Class<M> entityClass) {
		this.entityClass = entityClass;
	}

	/* get by id method to be used in engines dao classes implementation */
	public M get(ID id, Class<?> entityClass) {
		M entity =this.entityManager.find(getEntityClass(entityClass), id);
		if(entity==null) {
			throw new GeneralException(ErrorConstant.DATA_NOT_FOUND);
		}
		return entity;
	}

	/* remove method to be used in engines dao classes implementation */
	@Transactional
	public void remove(ID id, Class<?> entityClass) {
		M entity = get(id, getEntityClass(entityClass));
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
		return this.entityManager.createQuery("Select entity FROM " + getEntityClass()
		.getSimpleName() + " entity").getResultList();
	}
	
	public List<M> getAllDistinct() {
		Collection<M> result = new LinkedHashSet<>(getAll());
		return new ArrayList<>(result);
	}

	public List<M> getPagingResults(Integer firstResult, Integer maxResults) {

		CriteriaBuilder qb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<M> cq = qb.createQuery(this.entityClass);
		cq.select(cq.from(this.entityClass));

		return this.entityManager
				.createQuery(cq)
				.setFirstResult(firstResult)
				.setMaxResults((String.valueOf(maxResults)==null?PAGING_MAX_RECORD:maxResults)).getResultList();
	};
		
	
	@SuppressWarnings("rawtypes")
	public Long getRecordCount() {
		CriteriaBuilder qb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = qb.createQuery(Long.class);
		Root<M> cc = cq.from(this.entityClass);
		cq.select(qb.count(cc));
		List list = this.entityManager.createQuery(cq).getResultList();
		return list.isEmpty()? null : (Long) list.get(0);
	}

}
