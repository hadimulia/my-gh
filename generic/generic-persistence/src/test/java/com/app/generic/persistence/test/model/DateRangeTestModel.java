package com.app.generic.persistence.test.model;

import java.util.Date;

import com.app.generic.persistence.annotation.DateRange;

@DateRange(pattern="yyyy-MM-dd", fieldNames = { "test","test2" })
public class DateRangeTestModel {
	private Date testStartDate;
	private Date testEndDate;
	private Date test2StartDate;
	private Date test2EndDate;
	
	public Date getTestStartDate() {
		return testStartDate;
	}
	public void setTestStartDate(Date testStartDate) {
		this.testStartDate = testStartDate;
	}
	public Date getTestEndDate() {
		return testEndDate;
	}
	public void setTestEndDate(Date testEndDate) {
		this.testEndDate = testEndDate;
	}
	public Date getTest2StartDate() {
		return test2StartDate;
	}
	public void setTest2StartDate(Date test2StartDate) {
		this.test2StartDate = test2StartDate;
	}
	public Date getTest2EndDate() {
		return test2EndDate;
	}
	public void setTest2EndDate(Date test2EndDate) {
		this.test2EndDate = test2EndDate;
	}
}
