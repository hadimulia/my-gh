package com.app.generic.persistence.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.app.generic.core.constant.ErrorConstant;
import com.app.generic.persistence.validator.object.DateRangeValidator;

/**
 * This validation will be compare your **StartDate and **EndDate.
 * <br>start date must be earlier than end date.
 * <br><b>Note:</b> Must be declare for date pattern style and will be validation automatically.
 * 
 * @author M Lukmanul Hakim (m.hakim &copy;Sep 12, 2018) 
 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
 */
@Documented
@Constraint(validatedBy = DateRangeValidator.class)
@Target( {ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateRange {

	String message() default ErrorConstant.INVALID_DATE_RANGE_KEY;
	
	/**
	 * This is required field
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Nov 21, 2018) 
	 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
	 */
	String pattern();

	/**
	 * field name that contain startDate and endDate.
	 * <p><b> Example:</b>
	 * <pre>
	 * &#64;DateRange(fieldNames = {["xxx", "yyy"]})
	 * public class Example{
	 * 	private Date xxxStartDate;
	 *  	private Date xxxEndDate;
	 *  	private Date yyyStartDate;
	 *  	private Date yyyEndDate;
	 * }
	 * </pre>
	 *
	 * @author M Lukmanul Hakim (m.hakim &copy;Nov 21, 2018) 
	 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
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
