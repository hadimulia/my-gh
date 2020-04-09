package com.anabatic.generic.endpoint.contract;

import java.io.Serializable;
import java.util.List;

import com.app.generic.core.constant.ErrorConstant;
import com.app.generic.core.exception.Error;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author heri.purwanto
 *
 * This class for Base Response, with CustomAnnotation
 */
@JsonInclude(Include.NON_NULL)
public class BaseResponse  implements Serializable{
	
	private static final long serialVersionUID = -3769929025525852531L;
	private static final String SUCCESS_CODE = "00";
	private static final String ERROR_CODE = "01";
	
	private String responseCode = SUCCESS_CODE;
	private String message = ErrorConstant.SUCCESS.getErrorMessage();
	private String localMessage = ErrorConstant.SUCCESS.getErrorLocaleMessage();
	private String reserved01;
	private String reserved02;
	private String reserved03;
	private String reserved04;
	private String reserved05;
	private Object response;
	
	private List<Error> errors;

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> listErrorCodes) {
		setResponseCode(ERROR_CODE);
		this.errors = listErrorCodes;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	public String getLocalMessage() {
		return localMessage;
	}

	public void setLocalMessage(String localMessage) {
		this.localMessage = localMessage;
	}

	public String getReserved01() {
		return reserved01;
	}

	public void setReserved01(String reserved01) {
		this.reserved01 = reserved01;
	}

	public String getReserved02() {
		return reserved02;
	}

	public void setReserved02(String reserved02) {
		this.reserved02 = reserved02;
	}

	public String getReserved03() {
		return reserved03;
	}

	public void setReserved03(String reserved03) {
		this.reserved03 = reserved03;
	}

	public String getReserved04() {
		return reserved04;
	}

	public void setReserved04(String reserved04) {
		this.reserved04 = reserved04;
	}

	public String getReserved05() {
		return reserved05;
	}

	public void setReserved05(String reserved05) {
		this.reserved05 = reserved05;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	
	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}
	
}
