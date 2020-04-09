package com.app.generic.persistence.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.app.generic.core.constant.ErrorConstant;
import com.app.generic.persistence.validator.field.ValidExpiredDateValidator;

/**
 * <br>
 * <b>Note:</b> Must be declare for date pattern style and will be validation
 * automatically
 * <br>If field is not filled, validation will be ignored
 *  
 * @author M Lukmanul Hakim (m.hakim &copy;Jan 7, 2019) <br>
 *         for further info contact: <i>vickyhakimm@gmail.com</i>
 */
@Documented
@Constraint(validatedBy = ValidExpiredDateValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidExpiredDate {
	
	String message() default ErrorConstant.INVALID_EXPIRED_DATE_KEY;

	/**
	 * This is required field
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Jan 7, 2019) <br>
	 *         for further info contact: <i>vickyhakimm@gmail.com</i>
	 * @return
	 */
	String pattern();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		ValidExpiredDate[] value();
	}
}
