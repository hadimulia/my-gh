package com.app.generic.core.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class DateUtil {

	private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
	private static SimpleDateFormat isoDateMiliSecondFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
	private static SimpleDateFormat uiFullFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat dbFullFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat dbFullStripFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat uiSimpleFormat = new SimpleDateFormat("dd MMMM yyyy");
	private static SimpleDateFormat uiSimpleFormatWithStripe = new SimpleDateFormat("dd-MM-yyyy");
	private static SimpleDateFormat uiSimpleFormatWithSlash = new SimpleDateFormat("MM/dd/yyyy");
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat simpleStripeDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static final String TIME_PATTERN = "HH:mm";

    /**
     * Checkstyle rule: utility classes should not have public constructor
     */
    private DateUtil() {
    }

    /**
     * Return default datePattern (MM/dd/yyyy)
     *
     * @return a string representing the date pattern on the UI
     */
    public static String getDatePattern() {
        String defaultDatePattern;
        try {
            defaultDatePattern = DEFAULT_DATE_PATTERN;
        } catch (MissingResourceException mse) {
            defaultDatePattern = "MM/dd/yyyy";
        }

        return defaultDatePattern;
    }

    public static String getDateReportPattern() {
        String defaultDatePattern;
        try {
            defaultDatePattern = DEFAULT_DATE_PATTERN;
        } catch (MissingResourceException mse) {
            defaultDatePattern = "dd MMMMM yyyy";
        }

        return defaultDatePattern;
    }

    public static String getDateTimePattern() {
        return DateUtil.getDatePattern() + " HH:mm:ss.S";
    }

    /**
     * This method attempts to convert an Oracle-formatted date
     * in the form dd-MMM-yyyy to mm/dd/yyyy.
     *
     * @param aDate date from database as a string
     * @return formatted string for the ui
     */
    public static String getDate(Date aDate) {
        SimpleDateFormat df;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(getDatePattern());
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    public static String getReportDate(Date aDate) {
        SimpleDateFormat df;
        String returnValue = "";

        if (aDate != null) {
            // TODO: Use locale from user  or global setting
            df = new SimpleDateFormat(getDateReportPattern(), new Locale("id", "ID"));
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }
    /**
     * This method generates a string representation of a date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param strDate a string representation of a date
     * @return a converted Date object
     * @throws ParseException when String doesn't match the expected format
     * @see java.text.SimpleDateFormat
     */
    public static Date convertStringToDate(String aMask, String strDate)
            throws ParseException {
        SimpleDateFormat df;
        Date date;
        df = new SimpleDateFormat(aMask);

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            //log.error("ParseException: " + pe);
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }

    /**
     * This method returns the current date time in the format:
     * MM/dd/yyyy HH:MM a
     *
     * @param theTime the current time
     * @return the current date/time
     */
    public static String getTimeNow(Date theTime) {
        return getDateTime(TIME_PATTERN, theTime);
    }

    /**
     * This method returns the current date in the format: MM/dd/yyyy
     *
     * @return the current date
     * @throws ParseException when String doesn't match the expected format
     */
    public static Calendar getToday() throws ParseException {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

        // This seems like quite a hack (date -> string -> date),
        // but it works ;-)
        String todayAsString = df.format(today);
        Calendar cal = new GregorianCalendar();
        cal.setTime(convertStringToDate(todayAsString));

        return cal;
    }

    /**
     * This method generates a string representation of a date's date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param aDate a date object
     * @return a formatted string representation of the date
     * @see java.text.SimpleDateFormat
     */
    public static String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
            System.err.append("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * This method generates a string representation of a date based
     * on the System Property 'dateFormat'
     * in the format you specify on input
     *
     * @param aDate A date to convert
     * @return a string representation of the date
     */
    public static String convertDateToString(Date aDate) {
        return getDateTime(getDatePattern(), aDate);
    }

    /**
     * This method converts a String to a date using the datePattern
     *
     * @param strDate the date to convert (in format MM/dd/yyyy)
     * @return a date object
     * @throws ParseException when String doesn't match the expected format
     */
    public static Date convertStringToDate(final String strDate) throws ParseException {
        return convertStringToDate(getDatePattern(), strDate);
    }

	public static Long getDateDiff(Date time, Date time2) {
		Calendar ca1 = Calendar.getInstance();
        Calendar ca2 = Calendar.getInstance();

        // Set the date for both of the calendar to get difference
        ca1.setTime(time);
        ca2.setTime(time2);
        
		// Get date in milliseconds
        long milisecond1 = ca1.getTimeInMillis();
        long milisecond2 = ca2.getTimeInMillis();

        // Find date difference in milliseconds
        long diffInMSec = milisecond2 - milisecond1;

        // Find date difference in days 
        // (24 hours 60 minutes 60 seconds 1000 millisecond)
        long diffOfDays = diffInMSec / (24 * 60 * 60 * 1000);
        
		return diffOfDays;
	}

	
	public static final Calendar toCalendar(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}

	 
	public long getDifferenceDays(Date d1, Date d2) {
	    long diff = d2.getTime() - d1.getTime();
	    return Math.abs(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
	}
	
	public final Date fromISODateMilisecond(String isoDate) throws ParseException{
		return StringUtils.trimToNull(isoDate)==null ? null : isoDateMiliSecondFormat.parse(isoDate);
	}
	
	public final String toISODateMilisecond(Date isoDate) {
		if (isoDate == null) return null;
		return isoDateMiliSecondFormat.format(isoDate);
	}
	
	/**
	 * @author ahlul.esasjana
	 * @param date
	 * @return dd/MM/yyyy HH:mm:ss
	 */
	public final String toUIFullFormat(Date date){
		return date==null ? null : uiFullFormat.format(date);
	}
	public final Date fromUiFullFormat(String dateString) throws ParseException {
		return uiFullFormat.parse(dateString);
	}
	/**
	 * @author ahlul.esasjana
	 * @param date
	 * @return dd/MM/yyyy HH:mm:ss
	 */
	public final String toDBFullFormat(Date date){
		return date==null ? null : dbFullFormat.format(date);
	}
	
	/**
	 * @author ahlul.esasjana
	 * @param date
	 * @return dd MMMM yyyy
	 */
	public final String toUISimpleFormat(Date date){
		return date==null ? null : uiSimpleFormat.format(date);
	}
	
	/**Return date with formatted string pattern 'dd-MM-yyyy' 
	 * @author ahlul.esasjana
	 * @param ddMMMMyyyy
	 * @return
	 * @throws ParseException
	 */
	public final Date simpleStripedFormatToDate(String ddMMyyy) throws ParseException {
		return uiSimpleFormatWithStripe.parse(ddMMyyy);
	}
	
	/**Return date with formatted string pattern 'dd-MM-yyyy HH:mm:ss' 
	 * @author ahlul.esasjana
	 * @param dd-MM-yyyy HH:mm:ss
	 * @return
	 * @throws ParseException
	 */
	public final Date fullStripedFormatToDate(String ddMMyyy) throws ParseException {
		return dbFullStripFormat.parse(ddMMyyy);
	}
	
	/**Return date with formatted string pattern 'MM/dd/yyyy' 
	 * @author hosea.simanjuntak
	 * @param ddMMMMyyyy
	 * @return
	 * @throws ParseException
	 */
	public final Date simpleSlashFormatToDate(String ddMMyyy) throws ParseException {
		return uiSimpleFormatWithSlash.parse(ddMMyyy);
	}
	
	/**Return date with formatted string pattern 'yyyyMMdd'
	 * @author ahlul.esasjana
	 * @param yyyyMMdd
	 * @return 
	 * @throws ParseException
	 */
	public final static Date toSimpleFormat(String yyyyMMdd) throws ParseException {
		simpleDateFormat.setLenient(false);
		return simpleDateFormat.parse(yyyyMMdd);
	}
	
	/**Return string pattern 'yyyyMMdd'
	 * @author ahlul.esasjana
	 * @param date
	 * @return
	 */
	public final String toStringSimpleFormat(Date date) {
		return date==null ? null : simpleDateFormat.format(date);
	}
	
	/**Return date with formatted string pattern 'yyyy-MM-dd'
	 * @author ahlul.esasjana
	 * @param yyyyMMdd
	 * @return
	 * @throws ParseException
	 */
	public final Date toSimpleStripeFormat(String yyyyMMdd) throws ParseException {
		return simpleStripeDateFormat.parse(yyyyMMdd);
	}
	
	/**Return string pattern 'yyyy-MM-dd'
	 * @author ahlul.esasjana
	 * @param date
	 * @return
	 */
	public final String toStringSimpleStripeFormat(Date date) {
		return date==null ? null : simpleStripeDateFormat.format(date);
	}


    /**
     * Convert a date to a String and a String to a Date
     * @param type String, Date or Timestamp
     * @param value value to convert
     * @return Converted value for property population
     */
    public Object convert(final Class<?> type, final Object value) {
        if (value == null) {
            return null;
        } else if (type == Timestamp.class) {
            return convertToDate(type, value, DateUtil.getDateTimePattern());
        } else if (type == Date.class) {
            return convertToDate(type, value, DateUtil.getDatePattern());
        } else if (type == String.class) {
            return convertToString(value);
        }

        throw new ConversionException("Could not convert " + value.getClass().getName() + " to " + type.getName());
    }

    /**
     * Convert a String to a Date with the specified pattern.
     * @param type String
     * @param value value of String
     * @param pattern date pattern to parse with
     * @return Converted value for property population
     */
    protected Object convertToDate(final Class<?> type, final Object value, final String pattern) {
        final DateFormat df = new SimpleDateFormat(pattern);
        if (value instanceof String) {
            try {
                if (StringUtils.isEmpty(value.toString())) {
                    return null;
                }

                final Date date = df.parse((String) value);
                if (type.equals(Timestamp.class)) {
                    return new Timestamp(date.getTime());
                }
                return date;
            } catch (final Exception e) {
                throw new ConversionException("Error converting String to Date", e);
            }
        }
        throw new ConversionException("Could not convert " + value.getClass().getName() + " to " + type.getName());
    }

    /**
     * Convert a java.util.Date or a java.sql.Timestamp to a String. Or does a toString
     * @param value value to convert
     * @return Converted value for property population
     */
    protected Object convertToString(final Object value) {
        if (value instanceof Date) {
            DateFormat df = new SimpleDateFormat(DateUtil.getDatePattern());
            if (value instanceof Timestamp) {
                df = new SimpleDateFormat(DateUtil.getDateTimePattern());
            }

            try {
                return df.format(value);
            } catch (final Exception e) {
                throw new ConversionException("Error converting Date to String", e);
            }
        } else {
            return value.toString();
        }
    }
    
    public static Date truncDate(Date date) {
    	Calendar cal = Calendar.getInstance(); // locale-specific
    	cal.setTime(date);
    	cal.set(Calendar.HOUR_OF_DAY, 0);
    	cal.set(Calendar.MINUTE, 0);
    	cal.set(Calendar.SECOND, 0);
    	cal.set(Calendar.MILLISECOND, 0);
    	return cal.getTime();
    }
    
    public static Date addDate(Date date,int day) {
    	Calendar c = Calendar.getInstance(); 
    	c.setTime(date); 
    	c.add(Calendar.DATE, day);
    	date = c.getTime();
    	return date;
    }
    
    public static Date addSeconds(Date date,int second) {
    	Calendar c = Calendar.getInstance(); 
    	c.setTime(date); 
    	c.add(Calendar.SECOND, second);
    	date = c.getTime();
    	return date;
    }

}
