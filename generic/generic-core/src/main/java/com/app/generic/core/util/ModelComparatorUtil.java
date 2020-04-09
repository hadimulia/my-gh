package com.app.generic.core.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author dimas.sulistyono
 *
 */
@Component
public class ModelComparatorUtil {
	
	@SuppressWarnings("unused")
	public static String convertForAuthorize(String value){
		try{
			String newValue = null;
			newValue = value.substring(1);
			newValue = newValue.substring(0, newValue.length() - 1);
			String[] firstSplit = newValue.split("\\],");
			firstSplit[firstSplit.length - 1] = firstSplit[firstSplit.length - 1]
					.substring(0, firstSplit[firstSplit.length - 1].length() - 1);
			String[] secondSplit = null;
			String[] thirdSplit = null;
			String[] fourthSplit = null;
			String[] idOnly = new String[firstSplit.length];
			for (int i = 0; i < firstSplit.length; i++) {
				secondSplit = firstSplit[i].split("\\{");
				for (int j = 0; j < secondSplit.length; j++) {
					thirdSplit = secondSplit[1].split(",");
					for (int k = 0; k < thirdSplit.length; k++) {
						fourthSplit = thirdSplit[0].split("=");
						idOnly[i] = fourthSplit[1];
					}
					break;
				}
			}
			String className = secondSplit[0].trim();
			String ids = StringUtils.join(idOnly, ",");
			newValue = className + " : " + ids;
			return newValue;
		}catch(Exception e){
			return "rusakk";
		}
	}
	
	public static Object[] convertToId(String value){
		Object[] id = null;
		String[] firstSplit = value.split(" : ");
		String[] secondSplit = null;
		for (int i = 0; i < firstSplit.length; i++) {
			secondSplit = firstSplit[1].split(",");
			id = new String[secondSplit.length + 1];
			id[0] = firstSplit[0].trim();
			for (int j = 0; j < secondSplit.length; j++) {
				id[j+1] = secondSplit[j];
			}
		}
		
		return id;
	}
}
