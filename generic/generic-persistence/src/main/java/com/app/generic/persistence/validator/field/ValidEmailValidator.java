package com.app.generic.persistence.validator.field;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.app.generic.persistence.annotation.ValidEmail;


/**
 *
 * @author taufik.muliahadi (&copy;Sep 14, 2018) 
 */
public class ValidEmailValidator implements ConstraintValidator<ValidEmail, String>{

	
	@Override
    public void initialize(ValidEmail validEmail) {
		
    }
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext arg1) {
		if (value == null) {
			return true; // will handled by isRequired
		}
		return value != null && value.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,63}$") && (value.length()>7 && value.length()<=13);
	}

}
