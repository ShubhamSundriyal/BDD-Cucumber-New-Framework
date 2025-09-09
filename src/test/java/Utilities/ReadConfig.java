package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

	Properties properties;

	String filePath = "C:\\Users\\Dell\\eclipse-workspace\\BDDUIFramework\\Config.properties";

	public ReadConfig() {

		properties = new Properties();

		try {
			//to open config .properties file in input mode and load the file
			FileInputStream fis = new FileInputStream(filePath);
			properties.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getBrowser() {

		String value = properties.getProperty("browser");

		if (value != null) {
			return value;
		} else {
			throw new RuntimeException("browser value not configured in config file");
		}
	}

	/*
	 * Properties properties;
	 * 
	 * String path =
	 * "C:\\Users\\Dell\\eclipse-workspace\\BDDUIFramework\\src\\test\\resources\\log4j2.properties";
	 * 
	 * //constructor public ReadConfig() { try { properties = new Properties();
	 * 
	 * FileInputStream fis = new FileInputStream(path); properties.load(fis); }
	 * catch (Exception e) { e.printStackTrace(); } }
	 * 
	 * public String getBrowser() { String value =
	 * properties.getProperty("browser");
	 * 
	 * if (value != null) { return value; } else { throw new
	 * RuntimeException("browser not specified in config file."); } }
	 */

	/*
	 * public String getBaseUrl() { String value =
	 * properties.getProperty("baseUrl");
	 * 
	 * if (value != null) { return value; } else { throw new
	 * RuntimeException("url not specified in config file."); } }
	 * 
	 * 
	 * 
	 * public String getEmail() { String email = properties.getProperty("email"); if
	 * (email != null) { return email; } else { throw new
	 * RuntimeException("email not specified in config file."); } }
	 * 
	 * public String getPassword() { String password =
	 * properties.getProperty("password"); if (password != null) { return password;
	 * } else { throw new RuntimeException("password not specified in config file");
	 * } }
	 */

}
