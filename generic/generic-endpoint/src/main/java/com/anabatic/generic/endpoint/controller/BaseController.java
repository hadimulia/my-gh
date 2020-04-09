package com.anabatic.generic.endpoint.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;

import com.anabatic.generic.endpoint.contract.BaseResponse;

/**
 * This class for refrence base controller using library JAX-RS
 *
 * @author taufik.muliahadi (&copy;Sep 14, 2018) 
 * @param <ID> Class type of entity id
 */
public interface  BaseController<ID extends Serializable> {

	
	public ResponseEntity<BaseResponse> getAll();
	
	public ResponseEntity<BaseResponse> get(ID id);
	
	public ResponseEntity<BaseResponse> insert(Object request);
	
	public ResponseEntity<BaseResponse> update(Object request);
	
	public ResponseEntity<BaseResponse> delete(ID id); 
}
