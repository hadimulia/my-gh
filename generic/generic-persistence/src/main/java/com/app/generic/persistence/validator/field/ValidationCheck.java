package com.app.generic.persistence.validator.field;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.app.generic.core.constant.ErrorConstant;
import com.app.generic.core.exception.Error;
import com.app.generic.core.exception.GeneralException;


/**
 *  Validate All Custom validation
 *
 * @author taufik.muliahadi (&copy;Sep 14, 2018) 
 */
public class ValidationCheck {

	
	/**
	 * Validate All Custom validation
	 * 
	 * @param object like entity, dto, contract that have attributes which need validation
	 */
	public static <O> void hasValidate(O object){
		List<Error> errors = new ArrayList<>();
		ValidatorFactory validatorFactory = 
				Validation.byDefaultProvider()
				.providerResolver(new OsgiServiceDiscoverer())
				.configure().buildValidatorFactory();
		
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<O>> violations = 
				validator.validate(object);

		if (violations != null && !violations.isEmpty()) {
			for (ConstraintViolation<O> violation : violations) {
				String msg = violation.getMessage();
				
				Error baseError = ErrorConstant.getError(msg);
				Error error = new Error(baseError.getErrorCode(), 
						baseError.getErrorMessage(), 
						baseError.getErrorLocaleMessage());
				
				Error tmp = errors.stream().filter(x -> error.getErrorCode()
						.equals(x.getErrorCode())).findAny().orElse(null);
				
				if (tmp == null) {
					error.addField(violation.getPropertyPath().toString());
					errors.add(error);
				}else if (tmp != null) {
					errors.forEach(x -> {
						if (x.getErrorCode() == tmp.getErrorCode()) {
							x.addField(violation.getPropertyPath().toString());
						}
					});
					}
				}
			throw new GeneralException(errors, 400);
			}
			
		}
	
	public static <O> void hasValidate(O object, Class<?> errorConstant){
		Object obj = null;
		try {
			obj = errorConstant.newInstance();
		} catch (InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		} 
		List<Error> errors = new ArrayList<>();
		ValidatorFactory validatorFactory = 
				Validation.byDefaultProvider()
				.providerResolver(new OsgiServiceDiscoverer())
				.configure().buildValidatorFactory();
		
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<O>> violations = 
				validator.validate(object);

		if (violations != null && !violations.isEmpty()) {
			for (ConstraintViolation<O> violation : violations) {
				String msg = violation.getMessage();
				Error baseError = null;
				try {
					Method method = errorConstant.getSuperclass().getDeclaredMethod("getError", String.class);
					method.setAccessible(true);
					baseError = (Error) method.invoke(obj, msg);
					
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
				
				if(baseError!=null) {
					Error error = new Error(baseError.getErrorCode(), 
							baseError.getErrorMessage(), 
							baseError.getErrorLocaleMessage());
					
					Error tmp = errors.stream().filter(x -> error.getErrorCode()
							.equals(x.getErrorCode())).findAny().orElse(null);
					
					if (tmp == null) {
						error.addField(violation.getPropertyPath().toString());
						errors.add(error);
					}else {
						errors.forEach(x -> {
							if (x.getErrorCode() == tmp.getErrorCode()) {
								x.addField(violation.getPropertyPath().toString());
							}
						});
						}
					}
				}
				
			throw new GeneralException(errors, 400);
			}
			
		}
	
	public static <O, T extends ErrorConstant> void hasValidate(O object, T errorConstant){
		List<Error> errors = new ArrayList<>();
		ValidatorFactory validatorFactory = 
				Validation.byDefaultProvider()
				.providerResolver(new OsgiServiceDiscoverer())
				.configure().buildValidatorFactory();
		
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<O>> violations = 
				validator.validate(object);

		if (violations != null && !violations.isEmpty()) {
			for (ConstraintViolation<O> violation : violations) {
				String msg = violation.getMessage();
				
				
				Error baseError = errorConstant.getError(msg);
				Error error = new Error(baseError.getErrorCode(), 
						baseError.getErrorMessage(), 
						baseError.getErrorLocaleMessage());
				
				Error tmp = errors.stream().filter(x -> error.getErrorCode()
						.equals(x.getErrorCode())).findAny().orElse(null);
				
				if (tmp == null) {
					error.addField(violation.getPropertyPath().toString());
					errors.add(error);
				}else if (tmp != null) {
					errors.forEach(x -> {
						if (x.getErrorCode() == tmp.getErrorCode()) {
							x.addField(violation.getPropertyPath().toString());
						}
					});
					}
				}
			throw new GeneralException(errors, 400);
			}
			
		}
}
