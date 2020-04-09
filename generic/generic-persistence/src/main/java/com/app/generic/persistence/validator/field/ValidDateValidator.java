package com.app.generic.persistence.validator.field;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.app.generic.persistence.annotation.ValidDate;

/**
 * @author M Lukmanul Hakim (m.hakim &copy;Sep 12, 2018) 
 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
 */
public class ValidDateValidator implements ConstraintValidator<ValidDate, String> {

	private String datePattern;
	
	@Override
	public void initialize(ValidDate validDate) {
		datePattern = validDate.pattern();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || "".equals(value)) {
			return true; // will handled by isRequired
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(value);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
}
