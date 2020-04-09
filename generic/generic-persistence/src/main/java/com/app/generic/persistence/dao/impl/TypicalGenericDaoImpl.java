package com.app.generic.persistence.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.app.generic.core.constant.ErrorConstant;
import com.app.generic.core.exception.GeneralException;
import com.app.generic.persistence.dao.TypicalGenericDao;
import com.app.generic.persistence.model.TypicalGenericModel;

/**
 * DAO that have a Client Id inside the model
 * 
 * @author M Lukmanul Hakim (m.hakim &copy;Sep 24, 2018) <br>
 *         for further info contact: <i>vickyhakimm@gmail.com</i>
 * @param <ENTITY> Entity Class
 * @param <ID> Type Data for Primary Key
 */

public abstract class TypicalGenericDaoImpl<ENTITY extends TypicalGenericModel, ID extends Serializable>
		extends GenericDaoImpl<ENTITY, ID> implements TypicalGenericDao<ENTITY, ID> {

	/*
	 * getting list object from clientId
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Sep 24, 2018) <br>for further info
	 * contact: <i>vickyhakimm@gmail.com</i>
	 * 
	 * @see
	 * com.anabatic.tpe.generic.persistence.dao.TypicalGenericDao#getByClientId(java
	 * .lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ENTITY> getByClientId(String clientId) {
		Query query = super.entityManager.createQuery(
				"Select entity FROM " + getEntityClass().getSimpleName() + " entity where clientId =:clientId");
		query.setParameter("clientId", clientId);

		return query.getResultList();
	}

	/*
	 * getting list object from clientId & custom parameter
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Sep 24, 2018) <br>for further info
	 * contact: <i>vickyhakimm@gmail.com</i>
	 * 
	 * @see com.anabatic.tpe.generic.persistence.dao.TypicalGenericDao#
	 * getByClientIdAndObject(java.lang.String, java.util.Map)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<ENTITY> getByClientIdAndObject(String clientId, Map<String, Object> obj) {
		try {
			List<Predicate> predicates = new ArrayList<>();
			CriteriaBuilder qb = super.entityManager.getCriteriaBuilder();
			CriteriaQuery cq = qb.createQuery();
			Root<ENTITY> clazz = cq.from(super.getEntityClass());

			predicates.add(qb.equal(clazz.get("clientId"), clientId));
			if (obj != null && !obj.isEmpty()) {
				for (Entry<String, Object> param : obj.entrySet()) {
					predicates.add(qb.equal(clazz.get(param.getKey()), param.getValue()));
				}
			}
			cq.select(clazz).where(predicates.toArray(new Predicate[] {})).orderBy(qb.asc(clazz.get("id")));
			return super.entityManager.createQuery(cq).getResultList();
		} catch (Exception e) {
			throw new GeneralException(ErrorConstant.INVALID_PARAMETER);
		}
	}

	/*
	 * getting list object paging from clientId & custom parameter
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Jan 15, 2019) <br>for further info
	 * contact: <i>vickyhakimm@gmail.com</i>
	 * 
	 * @see com.anabatic.tpe.generic.persistence.dao.TypicalGenericDao#
	 * getByClientIdAndObject(java.lang.String, java.util.Map)
	 */
	@Override
	public List<ENTITY> getByClientIdAndObject(String clientId, Map<String, Object> obj, Integer firstResult,
			Integer maxResult) {
		try {
			CriteriaBuilder qb = super.entityManager.getCriteriaBuilder();
			CriteriaQuery<ENTITY> cq = qb.createQuery(super.getEntityClass());
			List<Predicate> predicates = new ArrayList<>();
			Root<ENTITY> clazz = cq.from(super.getEntityClass());

			predicates.add(qb.equal(clazz.get("clientId"), clientId));
			if (obj != null && !obj.isEmpty()) {
				for (Entry<String, Object> param : obj.entrySet()) {
					predicates.add(qb.equal(clazz.get(param.getKey()), param.getValue()));
				}
			}

			cq.select(clazz).where(predicates.toArray(new Predicate[] {})).orderBy(qb.asc(clazz.get("id")));
			return this.entityManager.createQuery(cq).setFirstResult(firstResult)
					.setMaxResults((String.valueOf(maxResult) == null ? PAGING_MAX_RECORD : maxResult)).getResultList();
		} catch (Exception e) {
			throw new GeneralException(ErrorConstant.INVALID_PARAMETER);
		}
	}
}
