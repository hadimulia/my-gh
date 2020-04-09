package com.app.generic.persistence.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.app.generic.core.constant.ErrorConstant;
import com.app.generic.persistence.validator.field.ContactNumberValidator;


/**
 * 
 * @author taufik.muliahadi (&copy;Sep 14, 2018) 
 */
@Documented
@Constraint(validatedBy = ContactNumberValidator.class)
@Target( {ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactNumber {
	String message() default ErrorConstant.INVALID_CONTACT_NUMBER_KEY;
	
	boolean required() default false;
	
	Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
    	ContactNumber[] value();
    }
}
