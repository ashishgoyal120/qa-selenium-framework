package org.selenium.tests;

import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.enums.AuthorType;
import org.selenium.enums.CategoryType;
import org.selenium.pages.LoginPage;
import org.selenium.reports.ExtentLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@FrameworkAnnotation(author = { AuthorType.ASHISH, AuthorType.ANISHA }, category = { CategoryType.SANITY, CategoryType.REGRESSION })
	@Test(groups = { "SANITY", "REGRESSION" })
	public void verifyPresenceOfElements() {
		LoginPage login = new LoginPage(getDriver()).launchURL();
		int elementCount = 0;
		elementCount += (login.getTxtUsername() == null ? 0 : 1);
		elementCount += (login.getTxtUserPassword() == null ? 0 : 1);
		elementCount += (login.getBtnLoginButton() == null ? 0 : 1);
		elementCount += (login.getForgetPasswordLink() == null ? 0 : 1);
		if (elementCount != 4) {
			Assert.fail("Elements not present");
			ExtentLogger.info("Login Element Not present");
		}
	}
	
	@FrameworkAnnotation(author = { AuthorType.ASHISH}, category = { CategoryType.SANITY, CategoryType.REGRESSION })
	@Test(groups = { "SANITY", "REGRESSION" })
	public void performLogin() throws InterruptedException {
		LoginPage login = new LoginPage(getDriver()).launchURL();
		login.logIntoApplication("Admin", "admin123");
		ExtentLogger.info("Perform Login is completed Successfully!");
	}

}
