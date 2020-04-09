package com.app.generic.persistence.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.app.generic.core.constant.ErrorConstant;
import com.app.generic.persistence.validator.object.MinMaxValidator;


/**
 * This validation will be compare your **Min and **Max.
 * <br>Min must be smaller than max.
 * <br><b>Note:</b> Must be declare for field name and will be validation automatically.
 * 
 * @author M Lukmanul Hakim (m.hakim &copy;Sep 12, 2018) 
 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
 */
@Documented
@Constraint(validatedBy = MinMaxValidator.class)
@Target( {ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface MinMax {
	String message() default ErrorConstant.INVALID_MIN_MAX_KEY;

	/**
	 * field name that contain Min and Max.
	 * <p>
	 * <b> Example:</b>
	 * 
	 * <pre>
	 * &#64;MinMax(fieldNames = {["xxx", "yyy"]})
	 * public class Example{
	 * 	private Date xxxMin;
	 *  	private Date xxxMax;
	 *  	private Date yyyMin;
	 *  	private Date yyyMax;
	 * }
	 * </pre>
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Nov 21, 2018) <br>
	 *         for further info contact: <i>vickyhakimm@gmail.com</i>
	 */
	String[] fieldNames();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		ValidDate[] value();
	}
}
