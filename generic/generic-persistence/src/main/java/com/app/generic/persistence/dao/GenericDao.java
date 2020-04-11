/**
* ATI - CORE -TPE
* Transaction Processing Engine(TPE)
* @Author- V.N.V.L.PRASANNA 
* @author taufik.muliahadi
* <p>
* 	
* </p>
*/

package com.app.generic.persistence.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.app.generic.persistence.dto.Range;
import com.app.generic.persistence.enums.Condition;
import com.app.generic.persistence.enums.Order;
import com.app.generic.persistence.model.GenericModel;

/**
 * GenericDao using for transaction between application and database.
 * 
 * @author Taufik Muliahadi (taufik.m &copy;Jan 17, 2019) <br>
 *         for further info contact: <i>kotaksurat.taufik@gmail.com</i>
 * @param <M>
 * @param <ID>
 */
public interface GenericDao<M extends GenericModel, ID extends Serializable> {

	/**
	 * This method to be used for insert or update Entiry
	 * 
	 * @param model class with anotation @Entity
	 * @return entity object
	 * @see {@link javax.persistence.Entity}
	 */
	public M save(M model);

	public List<M> getAll();

	public M get(ID id);

	public void remove(ID id);

	public List<M> getAllDistinct();

	public List<M> getPagingResults(Integer firstResult, Integer maxResults, String orderBy, Order order);

	/**
	 * Get All by parameter, page and pageSize. Return only data if pageable doesn't
	 * contain page & pageSize. Start page position from 1. <br>
	 * Custom Parameter declare on Map&lt;String, Object&gt; for the parameter
	 *
	 * @param firstResult
	 * @param maxResult
	 * @param parameters
	 * @return
	 */
	public List<M> getAllBy(Integer firstResult, Integer maxResult, String orderBy, Order order,
			Map<String, Object> parameters, Condition condition);

	public Long getRecordCount();

	public Long getRecordCount(Map<String, Object> parameters, Condition condition);

	public Long getRecordCount(Map<String, Object> parameters, Range<?> range);

	/**
	 * Find All with filter, between range, and paging.
	 *
	 * @param firstResult
	 * @param maxResult
	 * @param parameters
	 * @param range
	 * @return
	 */
	public List<M> getAllByAndBetween(Integer firstResult, Integer maxResult, String orderBy, Order order,
			Map<String, Object> parameters, Range<?> range);
}
