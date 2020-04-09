package com.app.generic.persistence.validator.field;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.app.generic.persistence.annotation.ValidExpiredDate;

/**
 * @author M Lukmanul Hakim (m.hakim &copy;Jan 7, 2019) 
 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
 */
public class ValidExpiredDateValidator implements ConstraintValidator<ValidExpiredDate, String> {

	private String datePattern;

	@Override
	public void initialize(ValidExpiredDate validDate) {
		datePattern = validDate.pattern();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || "".equals(value)) {
			return true; // will handled by isRequired
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
		dateFormat.setLenient(false);
		Date date;
		try {
			date = dateFormat.parse(value);
		} catch (ParseException e) {
			return false;
		}
		return date.after(new Date());
	}
}
