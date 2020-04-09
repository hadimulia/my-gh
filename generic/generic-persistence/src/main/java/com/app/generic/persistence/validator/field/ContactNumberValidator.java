package com.app.generic.persistence.validator.field;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.app.generic.persistence.annotation.ContactNumber;

/**
 *
 * @author taufik.muliahadi (&copy;Sep 14, 2018)
 */
public class ContactNumberValidator implements ConstraintValidator<ContactNumber, String>{

	private Boolean required;

	@Override
	public void initialize(ContactNumber contactNumber) {
		required = contactNumber.required();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext arg1) {
		if (required)
			return (value == null || value.isEmpty());

		return value != null && value.matches("[0-9]+") && (value.length() > 7 && value.length() <= 13);
	}

}
