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
 * @author M Lukmanul Hakim (m.hakim &copy;Sep 24, 2018) <br>
 *         for further info contact: <i>vickyhakimm@gmail.com</i>
 * @param <M>
 * @param <ID>
 */
public interface TypicalGenericService<M extends GenericModel, ID extends Serializable> extends GenericService<M, ID> {

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
	 * Get All Object using Client Id and Custom Parameter declare on Map&lt;String,
	 * Object&gt; for the parameter <b>
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
	 * Get All Object using Client Id and Custom Parameter declare on Map&lt;String,
	 * Object&gt; for the parameter <b>. Start page position from 1.
	 * <p>
	 * Note: </b> <br>
	 * <b>&#9679</b> Key on Map must be same with the object name or field name</li>
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Jan 15, 2019) <br>
	 *         for further info contact: <i>vickyhakimm@gmail.com</i>
	 * @param clientId
	 * @param obj
	 * @param page
	 * @param pageSize
	 * @return
	 */
	Paging<M> getByClientIdAndObject(String clientId, Map<String, Object> obj, int page, int pageSize);

	/**
	 * Smarter getByClientId, this method will sorting you are finding by Custom
	 * Parameter or not.
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Sep 26, 2018) <br>
	 *         for further info contact: <i>vickyhakimm@gmail.com</i>
	 * @param clientId
	 * @param obj
	 * @return
	 */
	List<M> getByClientId(String clientId, Map<String, Object> obj);

	/**
	 * Smarter getByClientIdAndObject, this method will sorting you are finding by
	 * paging or not. Return only data if pageable doesn't contain page & pageSize. Start page position from 1.
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Jan 15, 2019) <br>
	 *         for further info contact: <i>vickyhakimm@gmail.com</i>
	 * @param clientId
	 * @param obj
	 * @param pageable
	 * @return
	 */
	Paging<M> getByClientIdAndObject(String clientId, Map<String, Object> obj, Pageable pageable);
}
