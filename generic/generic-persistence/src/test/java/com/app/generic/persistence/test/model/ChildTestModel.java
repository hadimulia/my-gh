package com.app.generic.persistence.test.model;

import com.app.generic.persistence.annotation.IsRequired;

public class ChildTestModel {

	@IsRequired 
	private String value;
		
	public ChildTestModel(String value) {
		super();
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
