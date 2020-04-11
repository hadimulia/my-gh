package com.app.gh.core.enums;

public enum UnitEnum {

	UNIT(0,"Unit","unit"),
	/*Satuan Berat */
	MGR(1,"Miligram","mg"),
	GR(2,"Gram" ,"g"),
	KG(3,"Kilogram","Kg"),
	KWT(4,"Kuintal","Kw"),
	TON(5,"Ton","ton"),
	
	/* Volume */
	ML(6,"Mililiter","ml"),
	LITER(7,"Liter","L"),
	
	LUSIN(8,"Lusin","lsn"),
	BOX(9,"Box","box"),
	PIECES(10,"Pcs","pcs"),
	
	;
	private int key;
	private String value;
	private String shortFor;
	
	private UnitEnum(int key, String value,String shortFor) {
		this.key = key;
		this.value = value;
		this.shortFor = shortFor;
	}
	
	public int getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public String getShortFor() {
		return shortFor;
	}

	public static boolean isMember(String value) {
		try {
			UnitEnum.valueOf(value);
		} catch (IllegalArgumentException ex) {
			return false;
		}
		return true;
	}
}
