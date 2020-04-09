package com.app.generic.persistence.test.model;

import com.app.generic.persistence.annotation.WithoutSpecialCharacter;

public class SpecialCharacterTestModel {

	@WithoutSpecialCharacter
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
