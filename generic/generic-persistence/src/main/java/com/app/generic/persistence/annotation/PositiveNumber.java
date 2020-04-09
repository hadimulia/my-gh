package com.app.generic.persistence.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.app.generic.core.constant.ErrorConstant;
import com.app.generic.persistence.validator.field.PositiveNumberValidator;

/**
 * This validation will be check your field is need to be a positive number.
 * 
 * <ol>
 * <li>includeZero <b>default</b> value is true.</li> if includeZero value is
 * true. Positive number including zero.
 * </ol>
 * 
 * @author M Lukmanul Hakim (m.hakim &copy;Sep 12, 2018) <br>
 *         for further info contact: <i>vickyhakimm@gmail.com</i>
 */
@Documented
@Constraint(validatedBy = PositiveNumberValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PositiveNumber {
	String message() default ErrorConstant.INVALID_POSITIVE_NUMBER_KEY;

	boolean includeZero() default true;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		PositiveNumber[] value();
	}
}
