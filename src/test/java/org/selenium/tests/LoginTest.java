package org.selenium.tests;

import java.io.IOException;

import org.selenium.annotations.FrameworkAnnotation;
import org.selenium.base.BaseTest;
import org.selenium.dataproviders.DataProvidersclass;
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
		//ExtentLogger.pass("Elements Are Present", true);  //We need to optimize screenshot for passed tcs
		if (elementCount != 4) {
			Assert.fail("Elements not present");
			ExtentLogger.info("Login Element Not present");
		}
	}
	
	@FrameworkAnnotation(author = { AuthorType.ASHISH}, category = { CategoryType.SANITY, CategoryType.REGRESSION })
	@Test(groups = { "SANITY", "REGRESSION" }, dataProviderClass = DataProvidersclass.class, dataProvider = "credentialsProvider")
	public void performLogin(String userName, String password) throws InterruptedException, IOException {
		LoginPage login = new LoginPage(getDriver()).launchURL();
		login.logIntoApplication(userName, password);
		ExtentLogger.info("Perform Login is completed Successfully!");
	}

}
