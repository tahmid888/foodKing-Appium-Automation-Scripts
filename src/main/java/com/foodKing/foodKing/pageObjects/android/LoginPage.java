package com.foodKing.foodKing.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.foodKing.foodKing.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends AndroidActions {

	AndroidDriver driver;

	public LoginPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Profile")
	private WebElement profile;

	@AndroidFindBy(accessibility = "Login")
	private WebElement loginButton;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]")
	private WebElement emailField;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]")
	private WebElement passwordField;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Success\nLogin Successfully.']")
	private WebElement loginSuccessMessage;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='ERROR\nInvalid credentials or you are blocked']")
	private WebElement invalidLoginMessage;

	public void profile() {
		profile.click();
	}

	public void tapLogin() {
		loginButton.click();
	}

	public void setEmail(String email) {
		emailField.click();
		emailField.clear();
		emailField.sendKeys(email);
	}

	public void setPassword(String password) {
		passwordField.click();
		passwordField.clear();
		passwordField.sendKeys(password);
	}

	public WebElement loginSuccessMessage() {
		return loginSuccessMessage;
	}

	public WebElement invalidLoginMessage() {
		return invalidLoginMessage;
	}

}
