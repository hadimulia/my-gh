package com.app.generic.core.util;

/**
 * This class for fixing boxes boolean on sonarqube <br>
 * Performance - Method needlessly boxes a boolean constant
 * <br>
 * So next time for set variable Boolean Type use this class
 * 
 *
 * @author taufik.muliahadi (&copy;Jan 16, 2019) 
 */
public final class BooleanUtils extends org.apache.commons.lang3.BooleanUtils{

	public static Boolean isTrue() {
		return Boolean.TRUE;
	}
	
	public static Boolean isFalse() {
		return Boolean.FALSE;
	}
}
