package com.app.generic.persistence.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.app.generic.core.constant.ErrorConstant;
import com.app.generic.persistence.validator.field.IsBooleanValidator;

@Documented
@Constraint(validatedBy = IsBooleanValidator.class)
@Target( {ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsBoolean {
	String message() default ErrorConstant.INVALID_BOOLEAN_FORMAT_KEY;
	Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
    	IsRequired[] value();
    }
}
