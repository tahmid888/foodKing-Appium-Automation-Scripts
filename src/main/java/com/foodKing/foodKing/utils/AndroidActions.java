package com.foodKing.foodKing.utils;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

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
	
//	public void swipeAction(WebElement ele,String direction)
//    {
//        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement)ele).getId(),
//
//                "direction", direction,
//                "percent", 0.75
//            ));
//
//
//    }
	
	public void swipeHorizontal(int startX, int endX, int y, int durationMillis) {
        // Create a finger input
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // Build the swipe sequence
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(durationMillis),
                PointerInput.Origin.viewport(), endX, y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the swipe
        driver.perform(Arrays.asList(swipe));
    }

    /** Convenience: swipe left on menu (reveal right-side items). */
    public void swipeLeftOnMenu() {
        swipeHorizontal(961, 200, 642, 300);
    }

    /** Convenience: swipe right on menu (go back). */
    public void swipeRightOnMenu() {
        swipeHorizontal(200, 961, 642, 300);
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
