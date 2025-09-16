package com.foodKing.foodKing.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.foodKing.foodKing.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LogOutPage extends AndroidActions {

	AndroidDriver driver;

	public LogOutPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Log Out")
	private WebElement logOut;

	// Reusable Click using scroll
	public void clickLogOut(String logOutAccId) {
		WebElement element = scrollToElementByAccessibilityId(logOutAccId);
		element.click();
	}

}
