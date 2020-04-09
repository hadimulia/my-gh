package com.app.generic.core.exception;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author M Lukmanul Hakim (m.hakim &copy;Sep 5, 2018) 
 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
 *
 */
@JsonInclude(Include.NON_NULL)
public class Error {
	
	private String errorCode;
	private String errorMessage;
	private String errorLocaleMessage;
	
	private int httpStatus;
	
	private List<String> field;
	
	public Error() {
		/*no arg constructor*/
	}
	
	
	public Error(String errorCode, String errorMessage, String errorLocaleMessage, int httpStatus) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorLocaleMessage = errorLocaleMessage;
		this.httpStatus = httpStatus;
	}
	
	public Error(String errorCode, String errorMessage, String errorLocaleMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorLocaleMessage = errorLocaleMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorLocaleMessage() {
		return errorLocaleMessage;
	}
	public void setErrorLocaleMessage(String errorLocaleMessage) {
		this.errorLocaleMessage = errorLocaleMessage;
	}
	public List<String> getField() {
		return field == null? new ArrayList<String>() : this.field;
	}
	public void setField(List<String> field) {
		this.field = field == null? new ArrayList<String>() : field;
	}
	public void addField(String field) {
		if (this.field == null) {
			this.field = new ArrayList<>();
		}
		this.field.add(field);
	}
	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}
	public int getHttpStatus() {
		return httpStatus;
	}
}