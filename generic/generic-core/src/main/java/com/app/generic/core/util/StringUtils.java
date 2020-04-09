package com.app.generic.core.util;

public class StringUtils extends org.apache.commons.lang3.StringUtils{

	public static String simpleName (String className) {
		String objectName = "";
		String[] arrayCamelClassName = className.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])");
		
		for (String string : arrayCamelClassName) {
			objectName = objectName+string+" ";
		}
		
		return objectName;
	}
}
