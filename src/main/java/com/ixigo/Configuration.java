package com.ixigo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class Configuration {

	private Properties prop = null;

	public Configuration() {
		try {
			FileInputStream fis = new FileInputStream(new File("TestInput.properties"));
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {
			throw new RuntimeException("Please check for TestInput.properties file");
		}
	}

	public String getBrowserName() {
		return prop.getProperty("browser");
	}

	public String getEmail() {
		String email = prop.getProperty("emailaddress");
		return email.replace("19", new Random().nextInt(10000)+"");
	}

	public String getFirstName() {
		return prop.getProperty("customerName");
	}

	public String getLastName() {
		return prop.getProperty("lastName");
	}

	public String getPassword() {
		return prop.getProperty("pwd");
	}

	public String getAddress() {
		return prop.getProperty("address");
	}

	public String getInstanceURL() {
		return prop.getProperty("instance.url");
	}
}
