package com.app.generic.persistence.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.app.generic.core.constant.ErrorConstant;
import com.app.generic.persistence.validator.field.CheckItValidator;

/**
 * Use this annotation to validate child element of object
 *
 * @author abdullah.alim (&copy;Jan 2, 2019)
 */
@Documented
@Constraint(validatedBy = CheckItValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckIt {
	String message() default ErrorConstant.UNKNOWN_ERROR_KEY;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
