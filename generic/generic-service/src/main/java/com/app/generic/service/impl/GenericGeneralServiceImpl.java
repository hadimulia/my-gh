/*
* ATI - CORE -TPE
* Transaction Processing Engine(TPE)
* @Author- V.N.V.L.PRASANNA 
*/
package com.app.generic.service.impl;

import java.io.Serializable;
import java.util.List;

import com.app.generic.core.constant.ErrorConstant;
import com.app.generic.core.exception.GeneralException;
import com.app.generic.persistence.dao.GenericGeneralDao;
import com.app.generic.service.GenericGeneralService;

/**
 * @author taufik.muliahadi
 *
 * @param <M>
 * @param <ID>
 */
public abstract class GenericGeneralServiceImpl<M, ID extends Serializable> implements GenericGeneralService<M, ID> {

	
	protected GenericGeneralDao<M, ID> genericGeneralDao;

	public GenericGeneralServiceImpl(GenericGeneralDao<M, ID> genericDao) {
		this.genericGeneralDao = genericDao;
	}

	public GenericGeneralServiceImpl() {

	}

	@Override
	public M save(M model) {
		if (model == null) {
			throw new GeneralException(ErrorConstant.NULL_ENTITY);
		}
		return genericGeneralDao.save(model);
	}

	@Override
	public List<M> getAll() {
		return genericGeneralDao.getAll();
	}

	@Override
	public M get(ID id, Class<?> entityClass) {
		return genericGeneralDao.get(id, entityClass);
	}

	@Override
	public void remove(ID id, Class<?> entityClass) {
		genericGeneralDao.remove(id, entityClass);
	}

	@Override
	public List<M> getAllDistinct() {
		return genericGeneralDao.getAllDistinct();
	}

	@Override
	public List<M> getPagingResults(Integer firstResult, Integer maxResults) {
		return genericGeneralDao.getPagingResults(firstResult, maxResults);
	}

	@Override
	public Long getRecordCount() {
		return genericGeneralDao.getRecordCount();
	}
}
