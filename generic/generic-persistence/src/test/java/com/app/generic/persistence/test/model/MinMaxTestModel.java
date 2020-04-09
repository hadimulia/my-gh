package com.app.generic.persistence.test.model;

import java.math.BigDecimal;

import com.app.generic.persistence.annotation.MinMax;

@MinMax(fieldNames = { "test", "test2" })
public class MinMaxTestModel {
	private BigDecimal testMin;
	private BigDecimal testMax;
	private int test2Min;
	private int test2Max;
	
	public BigDecimal getTestMin() {
		return testMin;
	}
	public void setTestMin(BigDecimal testMin) {
		this.testMin = testMin;
	}
	public BigDecimal getTestMax() {
		return testMax;
	}
	public void setTestMax(BigDecimal testMax) {
		this.testMax = testMax;
	}
	public int getTest2Min() {
		return test2Min;
	}
	public void setTest2Min(int test2Min) {
		this.test2Min = test2Min;
	}
	public int getTest2Max() {
		return test2Max;
	}
	public void setTest2Max(int test2Max) {
		this.test2Max = test2Max;
	}
}
