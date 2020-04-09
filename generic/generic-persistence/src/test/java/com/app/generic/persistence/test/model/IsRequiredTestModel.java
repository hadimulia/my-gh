package com.app.generic.persistence.test.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import com.app.generic.persistence.annotation.IsRequired;

public class IsRequiredTestModel {

	@IsRequired
	private String stringValue;
	@IsRequired
	private Long longValue;
	@IsRequired
	private BigDecimal bigDecimalValue;
	@IsRequired
	private List<String> listValue;
	@IsRequired
	private Set<String> setValue;
	public String getStringValue() {
		return stringValue;
	}
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
	public Long getLongValue() {
		return longValue;
	}
	public void setLongValue(Long longValue) {
		this.longValue = longValue;
	}
	public BigDecimal getBigDecimalValue() {
		return bigDecimalValue;
	}
	public void setBigDecimalValue(BigDecimal bigDecimalValue) {
		this.bigDecimalValue = bigDecimalValue;
	}
	public List<String> getListValue() {
		return listValue;
	}
	public void setListValue(List<String> listValue) {
		this.listValue = listValue;
	}
	public Set<String> getSetValue() {
		return setValue;
	}
	public void setSetValue(Set<String> setValue) {
		this.setValue = setValue;
	}
	
	
	
}
