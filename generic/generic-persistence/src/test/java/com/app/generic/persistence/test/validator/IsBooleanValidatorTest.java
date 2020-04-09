package com.app.generic.persistence.test.validator;

import org.junit.Test;

import com.app.generic.core.exception.GeneralException;
import com.app.generic.persistence.test.model.IsBooleanTestModel;
import com.app.generic.persistence.validator.field.ValidationCheck;

public class IsBooleanValidatorTest {
	private IsBooleanTestModel testModel = new IsBooleanTestModel();
	
	@Test
	public void  test01valid() {
		ValidationCheck.hasValidate(testModel); //pass to IsRequired validator
		testModel.setValue("true");
		ValidationCheck.hasValidate(testModel);
		testModel.setValue("FALSE");
		ValidationCheck.hasValidate(testModel);
		testModel.setValue("True");
		ValidationCheck.hasValidate(testModel);
		testModel.setValue("fALSe");
		ValidationCheck.hasValidate(testModel);
	}
	
	@Test(expected = GeneralException.class )
	public void  test02invalidNumber() {
		testModel.setValue("1");
		ValidationCheck.hasValidate(testModel);
	}
}
