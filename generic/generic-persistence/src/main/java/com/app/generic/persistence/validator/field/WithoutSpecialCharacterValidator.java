package com.app.generic.persistence.validator.field;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.app.generic.persistence.annotation.WithoutSpecialCharacter;

public class WithoutSpecialCharacterValidator implements ConstraintValidator<WithoutSpecialCharacter, String> {
	@Override
	public void initialize(WithoutSpecialCharacter constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		
		Pattern regex = Pattern.compile("[^A-Za-z0-9]");
		Matcher matcher = regex.matcher(value);
		
		return !matcher.find();
	}

}
