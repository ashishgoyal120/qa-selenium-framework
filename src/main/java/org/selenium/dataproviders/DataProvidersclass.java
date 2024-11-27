package org.selenium.dataproviders;

import org.selenium.utils.ConfigLoader;
import org.testng.annotations.DataProvider;

public class DataProvidersclass {
	
	private static String USERNAME = "username";
	private static String PASSWORD = "password";

	@DataProvider(name = "credentialsProvider")
	public Object[][] credentialsProvider() {
		String username = System.getProperty(USERNAME, ConfigLoader.getInstance().getUserName());
		String password = System.getProperty(PASSWORD, ConfigLoader.getInstance().getUserPassword());
		return new Object[][] { { username, password } };
	}

}
