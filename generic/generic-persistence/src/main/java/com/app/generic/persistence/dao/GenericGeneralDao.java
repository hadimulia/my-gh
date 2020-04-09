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

public interface GenericGeneralDao<M, ID extends Serializable> {
	
	/**
	 * This method to be used for insert or update Entiry
	 * @param model class with anotation  @Entity
	 * @return entity object
	 * @see {@link javax.persistence.Entity}
	 */
	public M save(M model);

	public List<M> getAll();

	public M get(ID id, Class<?> entityClass);

	public void remove(ID id, Class<?> entityClass);

	public List<M> getAllDistinct();
	
	public List<M> getPagingResults(Integer firstResult, Integer maxResults);
	
	public Long getRecordCount();
}
