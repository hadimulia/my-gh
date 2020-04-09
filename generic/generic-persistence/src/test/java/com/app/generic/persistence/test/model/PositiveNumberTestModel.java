package com.app.generic.persistence.test.model;

import java.math.BigDecimal;

import com.app.generic.persistence.annotation.PositiveNumber;

public class PositiveNumberTestModel {
	@PositiveNumber
	private int test;
	@PositiveNumber
	private Long test2;
	@PositiveNumber
	private BigDecimal test3;
	
	public int getTest() {
		return test;
	}
	public void setTest(int test) {
		this.test = test;
	}
	public Long getTest2() {
		return test2;
	}
	public void setTest2(Long test2) {
		this.test2 = test2;
	}
	public BigDecimal getTest3() {
		return test3;
	}
	public void setTest3(BigDecimal test3) {
		this.test3 = test3;
	}
}
