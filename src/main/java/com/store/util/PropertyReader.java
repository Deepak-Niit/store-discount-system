package com.store.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	static Properties prop = new Properties();

	public static Properties getProperty() {
		return prop;
	}

	static {
		String resourceName = "application.properties"; // could also be a constant
		ClassLoader loader = Thread.currentThread().getContextClassLoader();

		try {
			InputStream resourceStream = loader.getResourceAsStream(resourceName);
			prop.load(resourceStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
