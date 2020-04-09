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
 * Service that have a Client Id inside the model
 * 
 * @author M Lukmanul Hakim (m.hakim &copy;Sep 24, 2018) <br>
 *         for further info contact: <i>vickyhakimm@gmail.com</i>
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
	 * @author M Lukmanul Hakim (m.hakim &copy;Sep 24, 2018) <br>for further info
	 * contact: <i>vickyhakimm@gmail.com</i>
	 * 
	 * @see
	 * com.anabatic.tpe.generic.service.TypicalGenericService#getByClientId(java.
	 * lang.String)
	 */
	@Override
	public List<M> getByClientId(String clientId) {
		return typicalGenericDao.getByClientId(clientId);
	}

	/*
	 * Calling TypicalGenericDao for get {E} by Client Id and Custom Parameter
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Sep 24, 2018) <br>for further info
	 * contact: <i>vickyhakimm@gmail.com</i>
	 * 
	 * @see
	 * com.anabatic.tpe.generic.service.TypicalGenericService#getByClientIdAndObject
	 * (java.lang.String, java.util.Map)
	 */
	@Override
	public List<M> getByClientIdAndObject(String clientId, Map<String, Object> obj) {
		return typicalGenericDao.getByClientIdAndObject(clientId, obj);
	}

	/*
	 * Calling TypicalGenericDao for get {E} by Client Id and Custom Parameter with
	 * paging return
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Sep 24, 2018) <br>for further info
	 * contact: <i>vickyhakimm@gmail.com</i>
	 * 
	 * @see
	 * com.anabatic.tpe.generic.service.TypicalGenericService#getByClientIdAndObject
	 * (java.lang.String, java.util.Map)
	 */
	@Override
	public Paging<M> getByClientIdAndObject(String clientId, Map<String, Object> obj, int page, int pageSize) {
		Integer startPosition = getPage(page, pageSize);
		List<M> data = typicalGenericDao.getByClientIdAndObject(clientId, obj, startPosition, pageSize);
		if (obj != null) {
			obj.put("clientId", clientId);
		}
		Long recordTotal = getRecordCount(obj, Condition.EQUAL);
		return new Paging<>(page, pageSize, recordTotal, data);
	}

	/*
	 * Calling for get {E} by Client Id and Custom Parameter
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Sep 26, 2018) <br>for further info
	 * contact: <i>vickyhakimm@gmail.com</i>
	 * 
	 * @see
	 * com.anabatic.tpe.generic.service.TypicalGenericService#getByClientId(java.
	 * lang.String, java.util.Map)
	 */
	@Override
	public List<M> getByClientId(String clientId, Map<String, Object> obj) {
		if (obj == null || obj.isEmpty()) {
			return this.getByClientId(clientId);
		} else {
			return this.getByClientIdAndObject(clientId, obj);
		}
	}

	/*
	 * Calling for get {E} by Client Id and Custom Parameter
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Sep 26, 2018) <br>for further info
	 * contact: <i>vickyhakimm@gmail.com</i>
	 * 
	 * @see
	 * com.anabatic.tpe.generic.service.TypicalGenericService#getByClientId(java.
	 * lang.String, java.util.Map)
	 */
	@Override
	public Paging<M> getByClientIdAndObject(String clientId, Map<String, Object> obj, Pageable pageable) {
		if (pageable != null) {
			if (pageable.getPage() != null && pageable.getPageSize() != null) {
				return this.getByClientIdAndObject(clientId, obj, pageable.getPage(), pageable.getPageSize());
			} else if (pageable.getPage() == null && pageable.getPageSize() == null) {
				return new Paging<>(null, null, null, this.getByClientIdAndObject(clientId, obj));
			} else {
				throw new GeneralException(ErrorConstant.INVALID_PARAMETER);
			}
		} else {
			return new Paging<>(null, null, null, this.getByClientIdAndObject(clientId, obj));
		}
	}
}
