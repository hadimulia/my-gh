package com.app.generic.persistence.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.app.generic.persistence.model.TypicalGenericModel;

/**
 * Interface DAO that have a Client Id inside the model
 * 
 * @author M Lukmanul Hakim (m.hakim &copy;Sep 24, 2018) 
 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
 * @param <M>
 * @param <ID>
 */
public interface TypicalGenericDao<M extends TypicalGenericModel, ID extends Serializable> extends GenericDao<M, ID>{
	/**
	 * Get All Object using Client Id for the parameter.
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Sep 24, 2018) <br>
	 *         for further info contact: <i>vickyhakimm@gmail.com</i>
	 * @param clientId
	 * @return List the object
	 */
	List<M> getByClientId(String clientId);

	/**
	 * Get All Object using Client Id and Custom Parameter declare on Map&lt;String, Object&gt; for the parameter
	 * <b>
	 * <p>
	 * Note: </b> <br>
	 * <b>&#9679</b> Key on Map must be same with the object name or field name</li>
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Sep 24, 2018) <br>
	 *         for further info contact: <i>vickyhakimm@gmail.com</i>
	 * @param clientId
	 * @param obj
	 * @return List the object
	 */
	List<M> getByClientIdAndObject(String clientId, Map<String, Object> obj);
	
	/**
	 * Get All Object using Client Id and Custom Parameter declare on Map&lt;String, Object&gt; for the parameter
	 * <b>
	 * <p>
	 * Note: </b> <br>
	 * <b>&#9679</b> Key on Map must be same with the object name or field name</li>
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Sep 24, 2018) <br>
	 *         for further info contact: <i>vickyhakimm@gmail.com</i>
	 * @param clientId
	 * @param obj
	 * @param firstResult
	 * @param maxResult
	 * @return List the object
	 */
	List<M> getByClientIdAndObject(String clientId, Map<String, Object> obj, Integer firstResult, Integer maxResult);
}
