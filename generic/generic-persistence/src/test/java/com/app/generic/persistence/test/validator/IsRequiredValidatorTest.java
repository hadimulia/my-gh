package com.app.generic.persistence.test.validator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.app.generic.core.exception.GeneralException;
import com.app.generic.persistence.test.model.IsRequiredTestModel;
import com.app.generic.persistence.validator.field.ValidationCheck;

public class IsRequiredValidatorTest {
	private IsRequiredTestModel testModel = new IsRequiredTestModel();
	
	@Before
	public void initialize() {
		
		testModel.setLongValue(1L);
		testModel.setStringValue("test");
		testModel.setBigDecimalValue(BigDecimal.ONE);
		List<String> arrayList = new ArrayList<>(); 
		arrayList.add("tes");
		Set<String> set = new HashSet<>();
		set.add("test");
		testModel.setListValue(arrayList);
		testModel.setSetValue(set);
		
	}
	
	@Test
	public void test01AllFilled() {
		ValidationCheck.hasValidate(testModel);
	}
	
	@Test(expected=GeneralException.class)
	public void test02NullLong() {
		testModel.setLongValue(null);
		ValidationCheck.hasValidate(testModel);
	}
	
	@Test(expected=GeneralException.class)
	public void test03NullString() {
		testModel.setStringValue(null);
		ValidationCheck.hasValidate(testModel);
	}
	
	@Test(expected=GeneralException.class)
	public void test04NullBigDecimal() {
		testModel.setBigDecimalValue(null);
		ValidationCheck.hasValidate(testModel);
	}
	
	@Test(expected=GeneralException.class)
	public void test05NullList() {
		testModel.setListValue(null);
		ValidationCheck.hasValidate(testModel);
	}
	
	@Test(expected=GeneralException.class)
	public void test06NullSet() {
		testModel.setSetValue(null);
		ValidationCheck.hasValidate(testModel);
	}
	
	@Test(expected=GeneralException.class)
	public void test07EmptyList() {
		testModel.setListValue(new ArrayList<>());
		ValidationCheck.hasValidate(testModel);
	}
	
	@Test(expected=GeneralException.class)
	public void test08EmptySet() {
		testModel.setSetValue(new HashSet<>());
		ValidationCheck.hasValidate(testModel);
	}
	
	@Test(expected=GeneralException.class)
	public void test09EmptyString() {
		testModel.setStringValue("");
		ValidationCheck.hasValidate(testModel);
	}
	
}
