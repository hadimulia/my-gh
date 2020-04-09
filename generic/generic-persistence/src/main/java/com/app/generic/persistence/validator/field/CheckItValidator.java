package com.app.generic.persistence.validator.field;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.app.generic.persistence.annotation.CheckIt;

public class CheckItValidator implements ConstraintValidator<CheckIt, Object> {

	@Override
	public void initialize(CheckIt checkIt) {
		
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		if (object instanceof List) {
			for (Object o : (List) object) {
				if (o != null) ValidationCheck.hasValidate(o);
			}
		} else {			
			if (object != null) 
				ValidationCheck.hasValidate(object); 
		}
		
		return true;
	}

}
