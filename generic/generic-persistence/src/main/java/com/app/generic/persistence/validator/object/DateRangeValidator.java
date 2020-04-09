package com.app.generic.persistence.validator.object;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.app.generic.core.constant.ErrorConstant;
import com.app.generic.core.exception.GeneralException;
import com.app.generic.persistence.annotation.DateRange;

public class DateRangeValidator implements ConstraintValidator<DateRange, Object> {

	private String datePattern;
	private String[] fieldNames;
	private Date startDate = null;
	private Date endDate = null;
	private Boolean flag = Boolean.TRUE;
	private static final String START_DATE = "StartDate";
	private static final String END_DATE = "EndDate";

	@Override
	public void initialize(DateRange dateRange) {
		datePattern = dateRange.pattern();
		fieldNames = dateRange.fieldNames();
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		context.disableDefaultConstraintViolation();
		for (String fieldName : fieldNames) {
			try {
				/*
				 * Validating the field name that startDate and endDate
				 */
				validate(fieldName, obj, obj.getClass());

				if (!startDate.before(endDate)) {
					flag = Boolean.FALSE;
					context.buildConstraintViolationWithTemplate(ErrorConstant.INVALID_DATE_RANGE_KEY)
							.addPropertyNode(fieldName.concat(START_DATE)).addConstraintViolation();
				}
			} catch (NullPointerException | ParseException e) {
				// Null pointer to be handled by is required
				// Parse Exception to be handled by is valid date
				flag = Boolean.TRUE;
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				flag = Boolean.FALSE;
				context.buildConstraintViolationWithTemplate(ErrorConstant.UNKNOWN_ERROR_KEY)
						.addPropertyNode(fieldName.concat(START_DATE)).addConstraintViolation();
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
	 * @throws IllegalArgumentException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 * 
	 * @see DateRange
	 */
	private void validate(String fieldName, Object obj, Class<?> clazz) throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, ParseException {
		Field field = null;
		Class<?> superClass = clazz.getSuperclass();
		try {
			field = clazz.getDeclaredField(fieldName + END_DATE);
			field.setAccessible(true);
			if (field.getType() == Date.class) {
				if (field.get(obj) == null || field.get(obj).toString().equals("")) {
					throw new NullPointerException();
				}
				endDate = (Date) field.get(obj);

				field = clazz.getDeclaredField(fieldName + START_DATE);
				field.setAccessible(true);

				if (field.get(obj) == null) {
					throw new NullPointerException();
				}
				startDate = (Date) field.get(obj);
			} else if (field.getType() == String.class) {
				if (field.get(obj) == null || field.get(obj).toString().equals("")) {
					throw new NullPointerException();
				}
				String endDateString = (String) field.get(obj);
				endDate = new SimpleDateFormat(datePattern).parse(endDateString);

				field = clazz.getDeclaredField(fieldName + START_DATE);
				field.setAccessible(true);

				if (field.get(obj) == null) {
					throw new NullPointerException();
				}
				String startDateString = (String) field.get(obj);
				startDate = new SimpleDateFormat(datePattern).parse(startDateString);
			}
		} catch (NoSuchFieldException | SecurityException e) {
			if (!superClass.equals(Object.class)) {
				validate(fieldName, obj, superClass);
			} else {
				throw new GeneralException(e.getMessage(), e);
			}
		}
	}

}
