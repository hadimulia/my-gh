package com.app.generic.core.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class NumberUtil {

	private static DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");
	private static NumberFormat numberFormat = NumberFormat.getPercentInstance();
	
	/**
	 * 
	 * @param BigDecimal
	 * @return ###,##0.00 EQ 1,000,000.00
	 */
	public static final String toDecimalFormat(BigDecimal decimal){
		if(decimal == null) decimal = new BigDecimal(0);
		return decimalFormat.format(decimal);
	}
	
	/**
	 * 
	 * @param BigDecimal
	 * @return String (decimal*100)% 
	 */
	public static final String toPercentageFormat(BigDecimal decimal){
		return numberFormat.format(decimal);
	}
	

	/**
	 * 
	 * @param String
	 * @return BigDecimal
	 */
	public static final BigDecimal removeDecimalFormat(String formatted){
//		String unformatted = formatted.replaceAll("(?<=^\\d+)\\.0*$", ""); 
		String unformatted = formatted.replace(",", ""); 
		
		return new BigDecimal(unformatted);
	}
	
	/**
	 * 
	 * @param BigDecimal
	 * @return ###,##0.00 EQ 1,000,000.00
	 */
	public static final String toDecimalFormat(String decimal){
		BigDecimal dec = BigDecimal.ZERO;
		if (StringUtils.isNotEmpty(decimal)) {
			dec = new BigDecimal(decimal);
		}
		return decimalFormat.format(dec);
	}
	

	public static String getDecimalFormat(String pattern) {
		try{
			String hasil = "";
			String buntut = "";
			String formatSebelum = pattern;
			String[] formatPotongan = formatSebelum.split(" ");
			hasil = "#";
			hasil += formatPotongan[1];
			hasil += "##0";
			hasil += formatPotongan[2];
			for (int ctr = 0; ctr < Integer.valueOf(formatPotongan[0]); ctr++) {
				buntut += "0";
			}
			hasil += buntut;
			return hasil;
		}catch(Exception e){
			e.printStackTrace();
			return "#,###.00";
		}
	} 
	
	public static Long getLongFromLongOrInteger(Object longOrInt) {
		if(longOrInt != null) {
			if(longOrInt.getClass().equals(Long.class)) return (Long) longOrInt;
			else {
				// hopefully it's an integer
				return ((Integer) longOrInt).longValue();
			}
		} else {
			return null;
		}
	}

}
