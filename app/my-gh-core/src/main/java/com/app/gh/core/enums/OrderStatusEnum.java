package com.app.gh.core.enums;

public enum OrderStatusEnum {

	PAID(0,"Paid"),
	UNPAID(1,"Unpaid"),
	OUTSTANDING(2,"Outstanding"),
	;
	private int key;
	private String value;
	
	
	private OrderStatusEnum(int key, String value) {
		this.key = key;
		this.value = value;
	}


	public int getKey() {
		return key;
	}


	public void setKey(int key) {
		this.key = key;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}
	
	public static boolean isMember(String value) {
		try {
			OrderStatusEnum.valueOf(value);
		} catch (IllegalArgumentException ex) {
			return false;
		}
		return true;
	}
	
}
