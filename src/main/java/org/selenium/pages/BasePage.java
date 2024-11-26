package org.selenium.pages;

import static org.selenium.constants.FrameworkConstants.ICON_Navigate_Right;
import static org.selenium.constants.FrameworkConstants.WAIT;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.constants.FrameworkConstants;
import org.selenium.driver.DriverManager;
import org.selenium.enums.WaitStrategy;
import org.selenium.factories.ExplicitWaitFactory;
import org.selenium.reports.ExtentLogger;
import org.selenium.reports.ExtentManager;
import org.selenium.utils.ConfigLoader;
import org.selenium.utils.ScreenshotUtils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.util.concurrent.Uninterruptibles;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, FrameworkConstants.getExplicitWait());
	}
	
	public void launchBaseURL() {
		driver.get(ConfigLoader.getInstance().getBaseUrl());
		ExtentLogger.info(ICON_Navigate_Right + "  Navigating to : <b>" + ConfigLoader.getInstance().getBaseUrl()
				+ "</b>");
	}
	
	public void waitForOverlaysToDisappear(By overlay) {
		List<WebElement> overlays = driver.findElements(overlay);
		System.out.println("OVERLAY SIZE" + overlays.size());
		if (overlays.size() > 0) {
			wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
			System.out.println("OVERLAY INVISIBLE NOW");
		} else {
			System.out.println("OVERLAY NOT FOUND");
		}
	}

	protected void click(By by, WaitStrategy waitStrategy, String elementName) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
		ExtentLogger.pass("<b>" + elementName + "</b> is clicked", true);
	}

	protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).sendKeys(value);
		ExtentLogger.pass("<b>" + value + "</b> is entered successfully in <b>" + elementName + "</b>", true);
	}

	protected void clear(By by, WaitStrategy waitStrategy, String elementName) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).clear();
		ExtentLogger.info("Clearing the field  <b>" + elementName + "</b>");
	}

	protected void clearAndSendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.clear();
		element.sendKeys(value);
		ExtentLogger.pass("<b>" + value + "</b> is entered successfully in <b>" + elementName + "</b>", true);
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	protected void captureScreenshot() {
		ExtentManager.getExtentTest().info("Capturing Screenshot",
				MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
	}

	protected void waitForSomeTime() {
		Uninterruptibles.sleepUninterruptibly(WAIT, TimeUnit.SECONDS);
	}

	protected void waitForGivenTime(long time) {
		Uninterruptibles.sleepUninterruptibly(time, TimeUnit.SECONDS);
	}


}
