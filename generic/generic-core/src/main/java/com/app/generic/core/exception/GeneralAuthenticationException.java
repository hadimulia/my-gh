package com.app.generic.core.exception;

import java.util.List;

/**
 * Exception thrown from Authentication Filter
 **/
public class GeneralAuthenticationException extends GeneralException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1139235852294002556L;

	public GeneralAuthenticationException() {
		super();
	}

	public GeneralAuthenticationException(Error exceptionKey) {
		super(exceptionKey);
	}

	public GeneralAuthenticationException(List<Error> errors, int httpStatus) {
		super(errors, httpStatus);
	}

	public GeneralAuthenticationException(String message, Throwable t) {
		super(message, t);
	}

	
}
