package com.app.generic.persistence.validator.object;

import java.lang.reflect.Field;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.app.generic.core.constant.ErrorConstant;
import com.app.generic.persistence.annotation.DateRange;
import com.app.generic.persistence.annotation.MinMax;

public class MinMaxValidator implements ConstraintValidator<MinMax, Object> {

	private String[] fieldNames;
	private Number max = null;
	private Number min = null;
	private static final String MAX = "Max";
	private static final String MIN = "Min";

	@Override
	public void initialize(MinMax minMax) {
		fieldNames = minMax.fieldNames();
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		Boolean flag = Boolean.TRUE;
		context.disableDefaultConstraintViolation();
		for (String fieldName : fieldNames) {
			try {
				/*
				 * Validating the field name that contains MIN and MAX
				 */
				validate(fieldName, obj);

				if (max.doubleValue() < min.doubleValue()) {
					flag = Boolean.FALSE;
					context.buildConstraintViolationWithTemplate(ErrorConstant.INVALID_MIN_MAX_KEY)
							.addPropertyNode(fieldName.concat(MAX)).addConstraintViolation();
				}
			} catch (NullPointerException e) {
				flag = Boolean.FALSE;
				context.buildConstraintViolationWithTemplate(ErrorConstant.REQUIRED_FIELD_KEY)
						.addPropertyNode(fieldName.concat(MAX)).addConstraintViolation();
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
					| SecurityException e) {
				flag = Boolean.FALSE;
				context.buildConstraintViolationWithTemplate(ErrorConstant.UNKNOWN_ERROR_KEY)
						.addPropertyNode(fieldName.concat(MAX)).addConstraintViolation();
			}
		}
		return flag;
	}

	/**
	 * This method is for private only, useful for validating the field on the
	 * object, the validate is for comparing startDate and endDate that the name of
	 * field is has been set on &#64;DateRange
	 * 
	 * @author M Lukmanul Hakim (m.hakim &copy;Nov 21, 2018) <br>
	 *         for further info contact: <i>vickyhakimm@gmail.com</i>
	 * @param fieldName
	 * @param obj
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * 
	 * @see DateRange
	 */
	private void validate(String fieldName, Object obj)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		Field field = obj.getClass().getDeclaredField(fieldName + MAX);
		field.setAccessible(true);
		if (field.get(obj) instanceof Number) {
			max = (Number) field.get(obj);

			field = obj.getClass().getDeclaredField(fieldName + MIN);
			field.setAccessible(true);

			min = (Number) field.get(obj);
		}
	}
}
