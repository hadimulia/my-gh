package com.app.gh.core.enums;

public enum StockStatusEnum {

	READY(0,"ready"),
	OUTOFSTOCK(1,"Out of Stock"),
	PREORDER(2,"Pre Order"),
	;
	
	private int key;
	private String value;
	
	private StockStatusEnum(int key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public static boolean isMember(String value) {
		try {
			StockStatusEnum.valueOf(value);
		} catch (IllegalArgumentException ex) {
			return false;
		}
		return true;
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
	
	
}
