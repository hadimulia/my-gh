package com.app.generic.core.exception;

import java.util.ArrayList;
import java.util.List;

import com.app.generic.core.constant.ErrorConstant;
import com.app.generic.core.exception.Error;

public class GeneralException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Error error;
	protected int httpStatus;

	private List<Error> errors = new ArrayList<>();
	
	public GeneralException() {
		super();
	}

	/**
	 * @param exceptionKey - {@link ErrorConstant} value
	 * @author kusmawati (&copy;Nov 12, 2018)
	 **/
	public GeneralException(Error exceptionKey) {
		super(exceptionKey.getErrorMessage());
		this.error = fetchError(exceptionKey);
		if (exceptionKey.getHttpStatus() == 0) exceptionKey.setHttpStatus(400);
		this.httpStatus = exceptionKey.getHttpStatus();
	}

	public GeneralException(List<Error> errors, int httpStatus) {
		super();
		this.errors = errors  == null? new ArrayList<>() : errors;
		this.httpStatus = httpStatus;
	}
	
	public GeneralException(String message,Throwable t){
		if(t instanceof GeneralException) {
			GeneralException exception = (GeneralException )t;
			this.error=exception.getError();
			this.errors=exception.getErrors();
			this.httpStatus =exception.getHttpStatus();
		}else {
			this.httpStatus = 500;
		}
	}
	
	public Error getError() {
		return error;
	}

	public Integer getHttpStatus() {
		return httpStatus;
	}

	public List<Error> getAllErrors() {
		if (getError() != null) {
			errors.add(getError());
		}
		return errors == null? new ArrayList<>(): this.errors;
	}
	
	public List<Error> getErrors() {
		return errors == null? new ArrayList<>(): this.errors;
	}

	 
	
	@Override
	public String getMessage() {
		if(error!=null) {
			return error.getErrorMessage();	
		}
		else return super.getMessage();
	}

	@Override
	public String getLocalizedMessage() {	
		if(error!=null) {
			return error.getErrorLocaleMessage();	
		}
		else return super.getLocalizedMessage();
	}
	
	/**
	 * Fetch new Error instance to not disturb Error constant
	 *
	 * @author Kusmawati (&copy;Jan 23, 2019)
	 * @param errorConstant {@link Error} from {@link ErrorConstant}
	 * @return
	 */
	public Error fetchError(Error errorConstant) {
		Error fetched = new Error();
		fetched.setErrorCode(errorConstant.getErrorCode());
		fetched.setErrorMessage(errorConstant.getErrorMessage());
		fetched.setErrorLocaleMessage(errorConstant.getErrorLocaleMessage());
		fetched.setHttpStatus(errorConstant.getHttpStatus());
		return fetched;
	}
	
}
