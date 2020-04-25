package com.app.generic.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.generic.core.constant.ErrorConstant;
import com.app.generic.core.exception.GeneralException;
import com.app.generic.endpoint.contract.BaseResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

/**
 * Controller advice to handle thrown exceptions: {@link TpeException},
 * {@link GeneralException}
 * 
 * @author Taufik Muliahadi (taufik.m &copy;Jan 22, 2019) <br>
 **/
@ControllerAdvice
public class GenericControllerAdvice {

	@ExceptionHandler(GeneralException.class)
	public static ResponseEntity<BaseResponse> handleGeneralException(final GeneralException exception) {

		return createErrorResponse(exception);
	}

	@ExceptionHandler(UnrecognizedPropertyException.class)
	public ResponseEntity<BaseResponse> handleUnRecognizedPropertyException(UnrecognizedPropertyException e) {
		GeneralException error = new GeneralException(ErrorConstant.INVALID_PARAMETER);
		error.getError().getField().clear();
		error.getError().setField(getFieldName(e));
		return createErrorResponse(error);
	}

	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<BaseResponse> handleInvalidFormatException(InvalidFormatException e) {
		GeneralException error = new GeneralException(ErrorConstant.INVALID_DATA_ENTRY);
		error.getError().getField().clear();
		error.getError().setField(getFieldName(e));
		return createErrorResponse(error);
	}
	
	@ExceptionHandler(JsonParseException.class)
	public ResponseEntity<BaseResponse> handleJsonParseException(JsonParseException e) {
		return createErrorResponse(new GeneralException(ErrorConstant.PARSING_ERROR));
	}
	
	public List<String> getFieldName(InvalidFormatException e) {
		List<String> result = new ArrayList<>();
		result.add(e.getPath().get(e.getPath().size() - 1).getFieldName());
		return result;
	}

	public List<String> getFieldName(UnrecognizedPropertyException e) {
		List<String> result = new ArrayList<>();
		result.add(e.getPath().get(e.getPath().size() - 1).getFieldName());
		return result;
	}

	/*
	 * @ExceptionHandler(LoggingException.class) public static
	 * ResponseEntity<BaseResponse> createErrorMessage(final LoggingException
	 * exception){ BaseResponse baseResponseError = new BaseResponse();
	 * 
	 * if(exception.getMessage()!=null){
	 * baseResponseError.setMessage(exception.getMessage());
	 * baseResponseError.setLocalMessage(exception.getLocalizedMessage()); }else{
	 * //no message available com.anabatic.generic.core.exception.Error
	 * defaultError= ErrorConstant.FAILED;
	 * baseResponseError.setMessage(defaultError.getErrorMessage());
	 * baseResponseError.setLocalMessage(defaultError.getErrorLocaleMessage()); }
	 * 
	 * com.anabatic.generic.core.exception.Error error = new
	 * com.anabatic.generic.core.exception.Error("TES", exception.getMessage() ,
	 * exception.getCause().getMessage()); List listError = new ArrayList();
	 * listError.add(error); baseResponseError.setErrors(listError);
	 * 
	 * return new ResponseEntity<BaseResponse>(baseResponseError,
	 * HttpStatus.BAD_REQUEST); }
	 */

	public static ResponseEntity<BaseResponse> createErrorResponse(GeneralException exception) {
		BaseResponse baseResponseError = new BaseResponse();

		if (exception.getError() != null) {
			baseResponseError.setMessage(exception.getMessage());
			baseResponseError.setLocalMessage(exception.getLocalizedMessage());
		} else {
			com.app.generic.core.exception.Error defaultError = ErrorConstant.FAILED;
			baseResponseError.setMessage(defaultError.getErrorMessage());
			baseResponseError.setLocalMessage(defaultError.getErrorLocaleMessage());
		}

		HttpStatus httpStatus = HttpStatus.valueOf(exception.getHttpStatus());
		baseResponseError.setErrors(exception.getAllErrors());

		return new ResponseEntity<>(baseResponseError, httpStatus);
	}
}
