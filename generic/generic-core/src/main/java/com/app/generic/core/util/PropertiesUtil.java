package com.app.generic.core.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:akbar.wijayanto94@gmail.com">Akbar Wijayanto</a>
 * Date Nov 20, 2016 2:13:00 PM
 */

@Component
public class PropertiesUtil {

	private static final String FILENAME = "application";
	
	protected static final Logger LOG = LogManager.getLogger(PropertiesUtil.class);

	public static String get(String key) {
		Properties prop = new Properties();
		String file = FILENAME;
		InputStream input = PropertiesUtil.class.getClassLoader().getResourceAsStream(file+".properties");
		try {
			prop.load(input);
			return prop.getProperty(key);
		} catch (IOException e) {
			if (LOG.isTraceEnabled()) 
				LOG.trace(e,e);
			else 
				LOG.error(e,e);
			return "We are unable to process your request at this point in time. Please call our 24-hour Anabatic Contact Center";
		} finally{
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					if (LOG.isTraceEnabled()) 
						LOG.trace(e,e);
					else 
						LOG.error(e,e);
				}
			}
        }
	}
	
}
