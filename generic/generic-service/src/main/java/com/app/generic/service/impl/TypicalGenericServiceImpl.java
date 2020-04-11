package com.app.generic.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.app.generic.core.constant.ErrorConstant;
import com.app.generic.core.exception.GeneralException;
import com.app.generic.persistence.dao.TypicalGenericDao;
import com.app.generic.persistence.dto.Pageable;
import com.app.generic.persistence.dto.Paging;
import com.app.generic.persistence.enums.Condition;
import com.app.generic.persistence.model.TypicalGenericModel;
import com.app.generic.service.TypicalGenericService;

/**
 * Service that have a Store Id inside the model
 * 
 * @author Taufik Muliahadi (taufik.m &copy;Sep 24, 2018) <br>
 * @param <M>
 * @param <ID>
 */

public abstract class TypicalGenericServiceImpl<M extends TypicalGenericModel, ID extends Serializable>
		extends GenericServiceImpl<M, ID> implements TypicalGenericService<M, ID> {

	/**
	 * DAO for Typical Generic
	 *
	 * TypicalGenericDao<E,K> typicalGenericDao
	 */
	protected TypicalGenericDao<M, ID> typicalGenericDao;

	/*
	 * Calling TypicalGenericDao for get {E} by Client Id
	 * 
	 * @see
	 * com.anabatic.tpe.generic.service.TypicalGenericService#getByStoreId(java.
	 * lang.String)
	 */
	@Override
	public List<M> getByStoreId(String storeId) {
		return typicalGenericDao.getByStoreId(storeId);
	}

	/*
	 * Calling TypicalGenericDao for get {E} by Client Id and Custom Parameter
	 *
	 * 
	 * @see
	 * com.anabatic.tpe.generic.service.TypicalGenericService#getByStoreIdAndObject
	 * (java.lang.String, java.util.Map)
	 */
	@Override
	public List<M> getByStoreIdAndObject(String storeId, Map<String, Object> obj) {
		return typicalGenericDao.getByStoreIdAndObject(storeId, obj);
	}

	/*
	 * Calling TypicalGenericDao for get {E} by Client Id and Custom Parameter with
	 * paging return
	 *
	 * 
	 * @see
	 * com.anabatic.tpe.generic.service.TypicalGenericService#getByStoreIdAndObject
	 * (java.lang.String, java.util.Map)
	 */
	@Override
	public Paging<M> getByStoreIdAndObject(String storeId, Map<String, Object> obj, int page, int pageSize) {
		Integer startPosition = getPage(page, pageSize);
		List<M> data = typicalGenericDao.getByStoreIdAndObject(storeId, obj, startPosition, pageSize);
		if (obj != null) {
			obj.put("storeId", storeId);
		}
		Long recordTotal = getRecordCount(obj, Condition.EQUAL);
		return new Paging<>(page, pageSize, recordTotal, data);
	}

	/*
	 * Calling for get {E} by Client Id and Custom Parameter
	 * 
	 * @see
	 * com.anabatic.tpe.generic.service.TypicalGenericService#getByStoreId(java.
	 * lang.String, java.util.Map)
	 */
	@Override
	public List<M> getByStoreId(String storeId, Map<String, Object> obj) {
		if (obj == null || obj.isEmpty()) {
			return this.getByStoreId(storeId);
		} else {
			return this.getByStoreIdAndObject(storeId, obj);
		}
	}

	/*
	 * Calling for get {E} by Client Id and Custom Parameter
	 *
	 * @see
	 * com.anabatic.tpe.generic.service.TypicalGenericService#getByStoreId(java.
	 * lang.String, java.util.Map)
	 */
	@Override
	public Paging<M> getByStoreIdAndObject(String storeId, Map<String, Object> obj, Pageable pageable) {
		if (pageable != null) {
			if (pageable.getPage() != null && pageable.getPageSize() != null) {
				return this.getByStoreIdAndObject(storeId, obj, pageable.getPage(), pageable.getPageSize());
			} else if (pageable.getPage() == null && pageable.getPageSize() == null) {
				return new Paging<>(null, null, null, this.getByStoreIdAndObject(storeId, obj));
			} else {
				throw new GeneralException(ErrorConstant.INVALID_PARAMETER);
			}
		} else {
			return new Paging<>(null, null, null, this.getByStoreIdAndObject(storeId, obj));
		}
	}
}
