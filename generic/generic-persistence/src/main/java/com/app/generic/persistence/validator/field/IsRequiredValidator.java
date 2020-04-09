package com.app.generic.persistence.validator.field;

import java.util.Collection;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.app.generic.persistence.annotation.IsRequired;

/**
 *
 * @author taufik.muliahadi (&copy;Sep 14, 2018) 
 */
public class IsRequiredValidator implements ConstraintValidator<IsRequired, Object> {

	@Override
	public void initialize(IsRequired isRequired) {

	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext arg1) {
		if (value != null) {
			if (value instanceof String)
				return !((String) value).isEmpty();
			else if (value instanceof Collection) 
				return !((Collection<?>)value).isEmpty();
			else 
				return true;
		} else {
			return false;
		}
	}

}
