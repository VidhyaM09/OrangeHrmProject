package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	private final static String propertypath = "./src/test/resources/Config.properties";

	static Properties properties;
	static FileInputStream fis;

	public static String getValue(String key) throws Throwable {
		try {
			properties = new Properties();
			fis = new FileInputStream(propertypath);
			properties.load(fis);
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Config property file not available at" + propertypath);
		}
		return properties.getProperty(key);

	}
}
