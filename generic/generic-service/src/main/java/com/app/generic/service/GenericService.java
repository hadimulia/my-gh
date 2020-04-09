/*
* ATI - CORE -TPE
* Transaction Processing Engine(TPE)
* @Author- V.N.V.L.PRASANNA 
*/
package com.app.generic.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.app.generic.persistence.dto.Pageable;
import com.app.generic.persistence.dto.Paging;
import com.app.generic.persistence.dto.Range;
import com.app.generic.persistence.enums.Condition;
import com.app.generic.persistence.model.GenericModel;

public interface GenericService<M extends GenericModel, ID extends Serializable> {

	public M save(M entity);

	public List<M> getAll();

	public M get(ID id);

	public void remove(ID id);

	public List<M> getAllDistinct();

	/**
	 * Get All by page and pageSize. Return only data if pageable doesn't contain page &
	 * pageSize. Start page position from 1.
	 *
	 * @see com.app.generic.persistence.dto.Paging
	 * @author M Lukmanul Hakim (m.hakim &copy;Jan 15, 2019) <br>
	 *         for further info contact: <i>vickyhakimm@gmail.com</i>
	 * @param pageable
	 * @return
	 */
	public Paging<M> getAll(Pageable pageable);
	
	/**
	 * Get All by parameter, page and pageSize. Return only data if pageable doesn't contain page &
	 * pageSize. Start page position from 1. 
	 * <br>Custom Parameter declare on Map&lt;String,
	 * Object&gt; for the parameter
	 *
	 * @see com.app.generic.persistence.dto.Paging
	 * @author M Lukmanul Hakim (m.hakim &copy;Jan 15, 2019) <br>
	 *         for further info contact: <i>vickyhakimm@gmail.com</i>
	 * @param pageable
	 * @param parameters
	 * @return
	 */
	public Paging<M> getAllBy(Pageable pageable, Map<String, Object> parameters, Condition condition);

	public Long getRecordCount();
	
	public Long getRecordCount(Map<String, Object> parameters, Condition condition);
	
	public Long getRecordCount(Map<String, Object> parameters, Range<?> range);
	
	/**
	 * Find All with filter, between range, and paging.
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Jan 17, 2019) 
	 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
	 * @param page
	 * @param pageSize
	 * @param parameters
	 * @param range
	 * @return
	 */
	public Paging<M> getAllByAndBetween(Pageable pageable, Map<String, Object> parameters,
			Range<?> range);
}
