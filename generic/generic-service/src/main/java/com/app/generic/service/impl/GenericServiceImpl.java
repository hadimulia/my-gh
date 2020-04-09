/*
* ATI - CORE -TPE
* Transaction Processing Engine(TPE)
* @Author- V.N.V.L.PRASANNA 
*/
package com.app.generic.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.app.generic.core.constant.ErrorConstant;
import com.app.generic.core.exception.GeneralException;
import com.app.generic.persistence.dao.GenericDao;
import com.app.generic.persistence.dto.Pageable;
import com.app.generic.persistence.dto.Paging;
import com.app.generic.persistence.dto.Range;
import com.app.generic.persistence.enums.Condition;
import com.app.generic.persistence.model.GenericModel;
import com.app.generic.service.GenericService;

public abstract class GenericServiceImpl<M extends GenericModel, ID extends Serializable>
		implements GenericService<M, ID> {

	/*
	 * @Author- V.N.V.L.PRASANNA
	 */
	protected GenericDao<M, ID> genericDao;

	public GenericServiceImpl(GenericDao<M, ID> genericDao) {
		this.genericDao = genericDao;
	}

	public GenericServiceImpl() {

	}

	@Override
	public M save(M model) {
		if (model == null) {
			throw new GeneralException(ErrorConstant.NULL_ENTITY);
		}
		return genericDao.save(model);
	}

	@Override
	public List<M> getAll() {
		return genericDao.getAll();
	}

	@Override
	public M get(ID id) {
		return genericDao.get(id);
	}

	@Override
	public void remove(ID id) {
		genericDao.remove(id);
	}

	@Override
	public List<M> getAllDistinct() {
		return genericDao.getAllDistinct();
	}

	@Override
	public Long getRecordCount() {
		return genericDao.getRecordCount();
	}

	@Override
	public Long getRecordCount(Map<String, Object> parameters, Condition condition) {
		return genericDao.getRecordCount(parameters, condition);
	}

	@Override
	public Long getRecordCount(Map<String, Object> parameters, Range<?> range) {
		return genericDao.getRecordCount(parameters, range);
	}

	@Override
	public Paging<M> getAll(Pageable pageable) {
		if (pageable != null) {
			if (pageable.getPage() != null && pageable.getPageSize() != null) {
				Integer startPosition = getPage(pageable.getPage(), pageable.getPageSize());
				Long recordTotal = getRecordCount();
				return new Paging<>(pageable.getPage(), pageable.getPageSize(), recordTotal,
						genericDao.getPagingResults(startPosition, pageable.getPageSize(), pageable.getOrderBy(),
								pageable.getOrder()));
			} else if (pageable.getPage() == null && pageable.getPageSize() == null) {
				return new Paging<>(null, null, null, this.getAll());
			} else {
				throw new GeneralException(ErrorConstant.INVALID_PARAMETER);
			}
		} else {
			return new Paging<>(null, null, null, this.getAll());
		}
	}

	@Override
	public Paging<M> getAllBy(Pageable pageable, Map<String, Object> parameters, Condition condition) {
		Integer startPosition = null;
		if (pageable.getPage() != null && pageable.getPageSize() != null && pageable.getPage() != 0
				&& pageable.getPageSize() != 0) {
			startPosition = getPage(pageable.getPage(), pageable.getPageSize());
		}
		List<M> data = genericDao.getAllBy(startPosition, pageable.getPageSize(), pageable.getOrderBy(),
				pageable.getOrder(), parameters, condition);
		Long recordTotal = getRecordCount(parameters, condition);
		return new Paging<>(pageable.getPage(), pageable.getPageSize(), recordTotal, data);
	}

	@Override
	public Paging<M> getAllByAndBetween(Pageable pageable, Map<String, Object> parameters, Range<?> range) {
		Integer startPosition = null;
		List<M> data = null;
		if (pageable.getPage() != null && pageable.getPageSize() != null) {
			startPosition = getPage(pageable.getPage(), pageable.getPageSize());
			data = genericDao.getAllByAndBetween(startPosition, pageable.getPageSize(), pageable.getOrderBy(),
					pageable.getOrder(), parameters, range);
		} else if (pageable.getPage() == null && pageable.getPageSize() == null) {
			data = genericDao.getAllByAndBetween(startPosition, pageable.getPageSize(), pageable.getOrderBy(),
					pageable.getOrder(), parameters, range);
		} else {
			throw new GeneralException(ErrorConstant.INVALID_PARAMETER);
		}
		Long recordTotal = getRecordCount(parameters, range);
		return new Paging<>(pageable.getPage(), pageable.getPageSize(), recordTotal, data);
	}

	protected Integer getPage(int page, int pageSize) {
		return (page - 1) * pageSize;
	}
}
