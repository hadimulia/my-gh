package com.app.generic.persistence.test.validator;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.generic.core.exception.GeneralException;
import com.app.generic.persistence.test.model.SpecialCharacterTestModel;
import com.app.generic.persistence.validator.field.ValidationCheck;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpecialCharacterTest {

	@Test
	public void test() {
		SpecialCharacterTestModel testModel= new SpecialCharacterTestModel();
		testModel.setValue("abcdABCD1234");
		ValidationCheck.hasValidate(testModel);
	}
	
	@Test(expected = GeneralException.class)
	public void test2() {
		SpecialCharacterTestModel testModel= new SpecialCharacterTestModel();
		testModel.setValue("~abcdABCD!234");
		ValidationCheck.hasValidate(testModel);
	}
	
	@Test
	public void test3() {
		SpecialCharacterTestModel testModel= new SpecialCharacterTestModel();
		ValidationCheck.hasValidate(testModel);
	}
}
