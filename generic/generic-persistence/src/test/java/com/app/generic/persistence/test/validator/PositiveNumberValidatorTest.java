package com.app.generic.persistence.test.validator;

import java.math.BigDecimal;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.generic.core.exception.GeneralException;
import com.app.generic.persistence.test.model.PositiveNumberTestModel;
import com.app.generic.persistence.validator.field.ValidationCheck;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
public class PositiveNumberValidatorTest {
	private PositiveNumberTestModel positiveNumberTestModel = new PositiveNumberTestModel();
	
	@Test(expected = GeneralException.class)
	public void testValid1(){
		positiveNumberTestModel.setTest(1);;
		positiveNumberTestModel.setTest2(-5L);
		positiveNumberTestModel.setTest3(new BigDecimal("-1000"));
		
		ValidationCheck.hasValidate(positiveNumberTestModel);
	}
}
