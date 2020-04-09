package com.app.generic.persistence.test.model;

import java.util.List;

import javax.validation.Valid;

import com.app.generic.persistence.annotation.IsRequired;

public class ParentTestModel {

	private Long id;
	
	private String name;

	@IsRequired
	@Valid
	private List<ChildTestModel> children;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<ChildTestModel> getChildren() {
		return children;
	}

	public void setChildren(List<ChildTestModel> children) {
		this.children = children;
	}

}
