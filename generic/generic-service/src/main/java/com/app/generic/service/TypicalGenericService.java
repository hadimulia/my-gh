package com.app.generic.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.app.generic.persistence.dto.Pageable;
import com.app.generic.persistence.dto.Paging;
import com.app.generic.persistence.model.GenericModel;

/**
 * Interface Service that have a Client Id inside the model
 * 
 * @author Taufik Muliahadi (taufik.m &copy;Sep 24, 2018) <br>
 * @param <M>
 * @param <ID>
 */
public interface TypicalGenericService<M extends GenericModel, ID extends Serializable> extends GenericService<M, ID> {

	/**
	 * Get All Object using Client Id for the parameter.
	 * @param storeId
	 * @return List the object
	 */
	List<M> getByStoreId(String storeId);

	/**
	 * Get All Object using Client Id and Custom Parameter declare on Map&lt;String,
	 * Object&gt; for the parameter <b>
	 * <p>
	 * Note: </b> <br>
	 * <b>&#9679</b> Key on Map must be same with the object name or field name</li>
	 *
	 * @param storeId
	 * @param obj
	 * @return List the object
	 */
	List<M> getByStoreIdAndObject(String storeId, Map<String, Object> obj);

	/**
	 * Get All Object using Client Id and Custom Parameter declare on Map&lt;String,
	 * Object&gt; for the parameter <b>. Start page position from 1.
	 * <p>
	 * Note: </b> <br>
	 * <b>&#9679</b> Key on Map must be same with the object name or field name</li>
	 * @param storeId
	 * @param obj
	 * @param page
	 * @param pageSize
	 * @return
	 */
	Paging<M> getByStoreIdAndObject(String storeId, Map<String, Object> obj, int page, int pageSize);

	/**
	 * Smarter getBystoreId, this method will sorting you are finding by Custom
	 * Parameter or not.
	 * @param storeId
	 * @param obj
	 * @return
	 */
	List<M> getByStoreId(String storeId, Map<String, Object> obj);

	/**
	 * Smarter getBystoreIdAndObject, this method will sorting you are finding by
	 * paging or not. Return only data if pageable doesn't contain page & pageSize. Start page position from 1.
	 *
	 * @param storeId
	 * @param obj
	 * @param pageable
	 * @return
	 */
	Paging<M> getByStoreIdAndObject(String storeId, Map<String, Object> obj, Pageable pageable);
}
