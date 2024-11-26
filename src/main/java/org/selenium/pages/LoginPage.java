package org.selenium.pages; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.enums.WaitStrategy;

public class LoginPage extends BasePage {

	private final By txtUsername = By.name("username");
	private final By txtUserPassword = By.name("password");
	private final By btnLoginButton = By.cssSelector("button[type='submit']");
	private final By forgetPasswordLink = By.cssSelector(".oxd-text.oxd-text--p.orangehrm-login-forgot-header");



	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public By getTxtUsername() {
		return txtUsername;
	}

	public By getTxtUserPassword() {
		return txtUserPassword;
	}

	public By getBtnLoginButton() {
		return btnLoginButton;
	}

	public By getForgetPasswordLink() {
		return forgetPasswordLink;
	}

	public LoginPage launchURL() {
		launchBaseURL();
		return this;
	}
	
	public void logIntoApplication(String username, String password) {
		clearAndSendKeys(txtUsername,username, WaitStrategy.CLICKABLE, "entered : " + username);
		clearAndSendKeys(txtUserPassword, password, WaitStrategy.CLICKABLE, "entered : " + password);
		click(btnLoginButton, WaitStrategy.CLICKABLE, "Login button");
	}
	
	


}
