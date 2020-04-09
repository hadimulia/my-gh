package com.app.generic.persistence.test.validator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.app.generic.core.exception.GeneralException;
import com.app.generic.persistence.test.model.ChildTestModel;
import com.app.generic.persistence.test.model.ParentTestModel;
import com.app.generic.persistence.validator.field.ValidationCheck;

public class CheckItValidatorTest {

	@Test(expected=GeneralException.class)
	public void test01() {
		List<ChildTestModel> children = new ArrayList<ChildTestModel>();
		children.add(new ChildTestModel("1"));
		children.add(new ChildTestModel(null));

		ParentTestModel parent = new ParentTestModel();
		parent.setId(1L);
		parent.setName("p1");
		parent.setChildren(children);

		ValidationCheck.hasValidate(parent);
	}

}
