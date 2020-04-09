package com.app.generic.persistence.test.validator;

import java.math.BigDecimal;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.generic.core.exception.GeneralException;
import com.app.generic.persistence.test.model.MinMaxTestModel;
import com.app.generic.persistence.validator.field.ValidationCheck;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
public class MinMaxValidatorTest {
	private MinMaxTestModel minMaxTestModel = new MinMaxTestModel();

	@Test(expected = GeneralException.class)
	public void testValid1(){
		minMaxTestModel.setTestMin(new BigDecimal("10000"));;
		minMaxTestModel.setTestMax(new BigDecimal("5000"));
		minMaxTestModel.setTest2Min(5);
		minMaxTestModel.setTest2Max(10);
		
		ValidationCheck.hasValidate(minMaxTestModel);
	}
}
