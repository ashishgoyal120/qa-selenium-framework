package org.selenium.utils;

import java.util.Properties;

import org.selenium.enums.EnvType;

public class ConfigLoader {
	
	private Properties properties;
	private static ConfigLoader configLoader;
	private static final String ENV = "env";
	private static final String BASE_URL = "baseUrl";
	private static final String DEFAULT_BROWSER = "browser";
	private static final String SEND_EMAIL_TO_USERS = "send_email_to_users";
	private static final String OVERRIDE_REPORTS = "override_reports";
	private static final String CONFIG_PROPERTIES = "config.properties";
	private static final String STG_CONFIG_PROPERTIES = "stg_" + CONFIG_PROPERTIES;
	private static final String PROD_CONFIG_PROPERTIES = "prod_" + CONFIG_PROPERTIES;
	private static final String QA_CONFIG_PROPERTIES = "qa_" + CONFIG_PROPERTIES;
	private static final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/test/resources/";
	private static final String PASSED_STEPS_SCREENSHOT = "passed_steps_screenshot";
	private static final String FAILED_STEPS_SCREENSHOT = "failed_steps_screenshot";
	private static final String SKIPPED_STEPS_SCREENSHOT = "skipped_steps_screenshot";
	private static final String RETRY_FAILED_TESTS = "retry_failed_tests";
	private static final String ZIPPED_REPORT = "zipped_report";
	private static final String USERNAME = "username";
	private static final String USERPASSWORD = "password";

	
	
	
	
	private ConfigLoader() {

		String env = System.getProperty(ENV, getConfigPropertyFile(CONFIG_PROPERTIES).getProperty(ENV));
		System.out.println("ENV : "+env);

		switch (EnvType.valueOf(env.toUpperCase())) {
		/* Only STAGE is working, Rest are taken for example */

		case STAGE: {
			properties = getConfigPropertyFile(STG_CONFIG_PROPERTIES);
			break;
		}
		case QA: {
			properties = getConfigPropertyFile(QA_CONFIG_PROPERTIES);
			break;
		}
		case PRODUCTION: {
			properties = getConfigPropertyFile(PROD_CONFIG_PROPERTIES);
			break;
		}
		default: {
			throw new IllegalStateException("Invalid EnvType: " + env);
		}
		}
	}
	
	private Properties getConfigPropertyFile(String configFile) {
		return PropertyUtils.propertyLoader(RESOURCES_PATH + configFile);
	}
	
	private String getPropertyValue(String propertyKey) {
		String prop = properties.getProperty(propertyKey);
		if (prop != null) {
			return prop.trim();
		} else {
			throw new RuntimeException("Property " + propertyKey + " is not specified in the config.properties file");
		}
	}
	
	public static ConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}
	
	public String getOverrideReports() {
		return getPropertyValue(OVERRIDE_REPORTS);
	}
	
	public String getSendEmailToUsers() {
		return getPropertyValue(SEND_EMAIL_TO_USERS);
	}
	public String getPassedStepsScreenshot() {
		return getPropertyValue(PASSED_STEPS_SCREENSHOT);
	}
	public String getFailedStepsScreenshot() {
		return getPropertyValue(FAILED_STEPS_SCREENSHOT);
	}
	public String getSkippedStepsScreenshot() {
		return getPropertyValue(SKIPPED_STEPS_SCREENSHOT);
	}
	public String getBaseUrl() {
		return getPropertyValue(BASE_URL);
	}
	public String getDefaultBrowser() {
		return getPropertyValue(DEFAULT_BROWSER);
	}
	public String getRetryFailedTests() {
		return getPropertyValue(RETRY_FAILED_TESTS);
	}
	public String getZippedReport() {
		return getPropertyValue(ZIPPED_REPORT);
	}

	public String getUserName() {
		return getPropertyValue(USERNAME);
	}
	public String getUserPassword() {
		return getPropertyValue(USERPASSWORD);
	}

}
