package com.app.generic.endpoint.controller;

import java.io.Serializable;
import java.util.Map;

import org.springframework.http.ResponseEntity;

/**
 * Controller if the model have a Client Id
 * @author M Lukmanul Hakim (m.hakim &copy;Sep 24, 2018) 
 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
 * @param <ID>
 */
public interface TypicalBaseController<ID extends Serializable> extends BaseController<ID>{
	/**
	 * Get by Client Id Controller
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Sep 24, 2018) 
	 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
	 * @param clientId
	 * @return all object that have the Client Id on request
	 */
	ResponseEntity<?> getByClientId(String clientId);
	/**
	 * Get by Client Id & Custom Object parameter Controller
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Sep 24, 2018) 
	 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
	 * @param clientId
	 * @param obj
	 * @return all object that have the Client Id & that custom parameter on request
	 */
	ResponseEntity<?>  getByClientIdAndObject(String clientId, Map<String, Object> obj);
}
