package com.app.generic.persistence.validator.field;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.app.generic.persistence.annotation.OnlyNumber;


/**
 *
 * @author taufik.muliahadi (&copy;Sep 14, 2018) 
 */
public class OnlyNumberValidator implements ConstraintValidator<OnlyNumber, String>{

	@Override
    public void initialize(OnlyNumber onlyNumber) {
    }
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext arg1) {
		if (value == null) {
			return true; // will handled by isRequired
		}
		return value != null && value.matches("[0-9]+");
	}

}
