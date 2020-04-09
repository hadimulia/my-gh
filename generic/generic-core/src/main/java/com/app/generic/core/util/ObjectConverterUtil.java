package com.app.generic.core.util;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;



/**
 * Utility class to convert one object to another.
 *
 * @author <a href="mailto:ab.annas@gmail.com">Andi Baso Annas</a>
 */
@Component
public final class ObjectConverterUtil {
    private static final Log log = LogFactory.getLog(ObjectConverterUtil.class);

    /**
     * Checkstyle rule: utility classes should not have public constructor
     */
    private ObjectConverterUtil() {
    }

    /**
     * Method to convert a ResourceBundle to a Map object.
     *
     * @param rb a given resource bundle
     * @return Map a populated map
     */
    public static Map<String, String> convertBundleToMap(ResourceBundle rb) {
        Map<String, String> map = new HashMap<String, String>();

        Enumeration<String> keys = rb.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            map.put(key, rb.getString(key));
        }

        return map;
    }


    /**
     * Method to convert a ResourceBundle to a Properties object.
     *
     * @param rb a given resource bundle
     * @return Properties a populated properties object
     */
    public static Properties convertBundleToProperties(ResourceBundle rb) {
        Properties props = new Properties();

        for (Enumeration<String> keys = rb.getKeys(); keys.hasMoreElements();) {
            String key = keys.nextElement();
            props.put(key, rb.getString(key));
        }

        return props;
    }

    /**
     * Convenience method used by tests to populate an object from a
     * ResourceBundle
     *
     * @param obj an initialized object
     * @param rb a resource bundle
     * @return a populated object
     */
    public static Object populateObject(Object obj, ResourceBundle rb) {
        try {
            Map<String, String> map = convertBundleToMap(rb);
            BeanUtils.copyProperties(obj, map);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception occurred populating object: " + e.getMessage());
        }

        return obj;
    }
    @SuppressWarnings("rawtypes")
    public static Object convertObject(Class to, Object from)
    {
    	
    	if(to.equals(Integer.class) || to.equals(Integer.TYPE))
    	{
    		if(from.getClass().equals(String.class))
    			return Integer.parseInt((String)from);
    	}
    	
    	if(to.equals(Long.class) || to.equals(Long.TYPE))
    	{
    		if(from.getClass().equals(String.class))
    			return Long.parseLong((String)from);
    		else if(from.getClass().equals(Integer.class) || from.getClass().equals(Integer.TYPE))
    			return Integer.valueOf((Integer)from).longValue();
    	}
    	
    	if(to.equals(Boolean.class) || to.equals(Boolean.TYPE))
    	{
    		if(from.getClass().equals(String.class))
    			return from.equals("1")? true:false;
    		else if(from.getClass().equals(Integer.class) || from.getClass().equals(Integer.TYPE))
    			return (Integer)from==1? true:false;
    	}
    	
    	if(to.equals(BigDecimal.class))
    	{
    		if(from.getClass().equals(String.class))
    			return new BigDecimal((String) from);
    		else if(from.getClass().equals(Integer.class) || from.getClass().equals(Integer.TYPE))
    			return new BigDecimal((Integer) from);
    		else if(from.getClass().equals(Long.class) || from.getClass().equals(Long.TYPE))
    			return new BigDecimal((Long) from);
    		else if(from.getClass().equals(Double.class) || from.getClass().equals(Double.TYPE))
    			return new BigDecimal((Double) from);
    		else if(from.getClass().equals(Float.class) || from.getClass().equals(Float.TYPE))
    			return new BigDecimal((Float) from);
    	}
    	
    	if(to.equals(Date.class))
    	{
    		if(from.getClass().equals(Long.class) || from.getClass().equals(Long.TYPE))
    			return new Date((Long) from);
    		if(from.getClass().equals(java.sql.Date.class))
    			return new Date(((java.sql.Date)from).getTime());
    	}
    	
    	if(to.equals(java.sql.Date.class))
    	{
    		if(from.getClass().equals(Long.class) || from.getClass().equals(Long.TYPE))
    			return new java.sql.Date((Long) from);
    		if(from.getClass().equals(Date.class))
    			return new java.sql.Date(((Date)from).getTime());
    	}
    	
    	if(to.equals(String.class))
    		return String.valueOf(from);
    	return null;
    }
}
