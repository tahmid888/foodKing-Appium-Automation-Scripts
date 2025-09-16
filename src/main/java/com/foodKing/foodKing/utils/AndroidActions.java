package com.foodKing.foodKing.utils;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import testappium.utils.AppiumUtils;

public class AndroidActions extends AppiumUtils {

	AndroidDriver driver;
	WebDriverWait wait;

	public AndroidActions(AndroidDriver driver) {
		this.driver = driver;
	}

	// Scroll
	public WebElement scrollToElementByAccessibilityId(String accId) {
		return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().description(\"" + accId + "\"));"));
	}

	/*
	 * // waitForElementVisible public WebElement waitForElementVisible(By locator,
	 * int timeoutInSeconds) { WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(timeoutInSeconds)); return
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); }
	 * 
	 * // waitForElementClickable public WebElement waitForElementClickable(By
	 * locator, int timeoutInSeconds) { WebDriverWait wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)); return
	 * wait.until(ExpectedConditions.elementToBeClickable(locator)); }
	 * 
	 * // waitForTextToBePresent public boolean waitForTextToBePresent(By locator,
	 * String text, int timeoutInSeconds) { WebDriverWait wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)); return
	 * wait.until(ExpectedConditions.textToBePresentInElementLocated(locator,
	 * text)); }
	 */
	/** Wait until element is visible */
	public WebElement waitForVisibility(WebElement element, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	/** Wait until element is clickable */
	public WebElement waitForClickable(WebElement element, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/** Wait until an element’s attribute contains a specific value */
	public void waitForAttributeContains(WebElement element, String attribute, String value, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	}

	/** Wait until text appears inside an element */
	public void waitForTextInElement(WebElement element, String text, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

}
