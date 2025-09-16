package com.foodKing.foodKing.pageObjects.android;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.foodKing.foodKing.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpPage extends AndroidActions {

	AndroidDriver driver;

	public SignUpPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Sign Up")
	private WebElement signUpLink;

	@AndroidFindBy(xpath = "//android.widget.EditText")
	private WebElement mobileField;

	@AndroidFindBy(accessibility = "Continue")
	private WebElement continueButton;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]")
	private WebElement firstNameField;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]")
	private WebElement lastNameField;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[3]")
	private WebElement emailField;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[4]")
	private WebElement passwordField;

	public void signUp() {
		signUpLink.click();

	}

	public void setMobile(String mobile) {
		mobileField.click();
		mobileField.clear();
		mobileField.sendKeys(mobile);
		// Do NOT hide keyboard here to prevent 'back' behavior
	}

	public void clickContinue() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		continueButton.click();
		// Hide keyboard AFTER clicking
		// driver.hideKeyboard();
	}

	public void setFirstName(String firstName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
		firstNameField.click();
		firstNameField.clear();
		firstNameField.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(lastNameField));
		lastNameField.click();
		lastNameField.clear();
		lastNameField.sendKeys(lastName);
	}

	public void setEmail(String email) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(emailField));
		emailField.click();
		emailField.clear();
		emailField.sendKeys(email);
	}

	public void setPassword(String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(passwordField));
		passwordField.click();
		passwordField.clear();
		passwordField.sendKeys(password);
	}

}
