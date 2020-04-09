package com.app.generic.persistence.validator.field;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.app.generic.persistence.annotation.PositiveNumber;

public class PositiveNumberValidator implements ConstraintValidator<PositiveNumber, Object> {

	boolean includeZero;

	@Override
	public void initialize(PositiveNumber positiveNumber) {
		includeZero = positiveNumber.includeZero();
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		if (obj == null || obj.toString().equals("")) {
			return true; // handle with is required.
		}
		if (obj instanceof Number) {
			Number number = (Number) obj;
			if ((number.doubleValue() >= 0 && includeZero) || (number.doubleValue() > 0 && !includeZero))
				return true;
		}
		return false;
	}
}
