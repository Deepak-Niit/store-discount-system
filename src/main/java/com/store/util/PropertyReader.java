package com.store.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/*
 * Utility class for reading property file
 */
public class PropertyReader {

    private static final String APPLICATION_PROPERTIES = "application.properties";
    static Properties prop = new Properties();

    private PropertyReader() {
    }

    public static Properties getProperty() {
	return prop;
    }

    static {
	String resourceName = APPLICATION_PROPERTIES;
	ClassLoader loader = Thread.currentThread().getContextClassLoader();

	try {
	    InputStream resourceStream = loader.getResourceAsStream(resourceName);
	    prop.load(resourceStream);
	} catch (IOException ex) {
	    System.err.println(ex);
	}
    }

}
