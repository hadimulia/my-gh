package com.app.generic.persistence.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.app.generic.persistence.model.TypicalGenericModel;

/**
 * Interface DAO that have a Store Id inside the model
 * 
 * @author Taufik Muliahadi(taufik.m &copy;Sep 24, 2018) 
 * <br>for further info contact: <i>kotaksurat.taufik@gmail.com</i>
 * @param <M>
 * @param <ID>
 */
public interface TypicalGenericDao<M extends TypicalGenericModel, ID extends Serializable> extends GenericDao<M, ID>{
	/**
	 * Get All Object using Client Id for the parameter.
	 *
	 * @param storeId
	 * @return List the object
	 */
	List<M> getByStoreId(String storeId);

	/**
	 * Get All Object using Store Id and Custom Parameter declare on Map&lt;String, Object&gt; for the parameter
	 * <b>
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
	 * Get All Object using Store Id and Custom Parameter declare on Map&lt;String, Object&gt; for the parameter
	 * <b>
	 * <p>
	 * Note: </b> <br>
	 * <b>&#9679</b> Key on Map must be same with the object name or field name</li>
	 *
	 * @param storeId
	 * @param obj
	 * @param firstResult
	 * @param maxResult
	 * @return List the object
	 */
	List<M> getByStoreIdAndObject(String storeId, Map<String, Object> obj, Integer firstResult, Integer maxResult);
}
