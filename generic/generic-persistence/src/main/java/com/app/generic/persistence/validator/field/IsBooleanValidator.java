package com.app.generic.persistence.validator.field;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.app.generic.persistence.annotation.IsBoolean;

public class IsBooleanValidator implements ConstraintValidator<IsBoolean, String> {
	private static final String FALSE = "false";
	private static final String TRUE = "true";

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value != null) {
			String text = value.trim();
			if (TRUE.equalsIgnoreCase(text) || FALSE.equalsIgnoreCase(text)) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

}
