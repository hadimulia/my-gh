
package com.app.generic.service;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * For General Entity
 * 
 * @author taufik.muliahadi
 *
 * @param <M>
 * @param <ID>
 */
public interface GenericGeneralService<M , ID extends Serializable> {

	public M save(M entity);

	public List<M> getAll();

	public M get(ID id, Class<?> entityClass);

	public void remove(ID id, Class<?> entityClass);

	public List<M> getAllDistinct();

	public List<M> getPagingResults(Integer firstResult, Integer maxResults);

	public Long getRecordCount();
}
