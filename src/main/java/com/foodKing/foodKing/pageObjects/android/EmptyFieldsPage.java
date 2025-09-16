package com.foodKing.foodKing.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.foodKing.foodKing.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EmptyFieldsPage extends AndroidActions {

	AndroidDriver driver;

	public EmptyFieldsPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Enter valid email")
	private WebElement emailError;

	@AndroidFindBy(accessibility = "Password must be at least 6 charecter")
	private WebElement passwordError;

	@AndroidFindBy(accessibility = "Please type password")
	private WebElement newPasswordError;

	@AndroidFindBy(accessibility = "Please type your first name")
	private WebElement firstNameError;

	@AndroidFindBy(accessibility = "Please type your last name")
	private WebElement lastNameError;

	public String getEmailError() {
		return emailError.getAttribute("content-desc");
	}

	public String getPasswordError() {
		return passwordError.getAttribute("content-desc");
	}

	public String getFirstNameError() {
		return firstNameError.getAttribute("content-desc");
	}

	public String getLastNameError() {
		return lastNameError.getAttribute("content-desc");
	}

	public String getNewPasswordError() {
		return newPasswordError.getAttribute("content-desc");
	}

}
