package com.app.generic.persistence.test.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.generic.core.exception.GeneralException;
import com.app.generic.persistence.test.model.DateRangeTestModel;
import com.app.generic.persistence.validator.field.ValidationCheck;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
public class DateRangeValidatorTest {
	private DateRangeTestModel dateRangeTestModel = new DateRangeTestModel();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Test(expected = GeneralException.class)
	public void testValid1() throws ParseException {
		dateRangeTestModel.setTestStartDate(sdf.parse("2015-08-26"));
		dateRangeTestModel.setTestEndDate(sdf.parse("2015-05-26"));
		dateRangeTestModel.setTest2StartDate(sdf.parse("2015-05-26"));
		dateRangeTestModel.setTest2EndDate(sdf.parse("2015-08-26"));
		
		ValidationCheck.hasValidate(dateRangeTestModel);
	}
}