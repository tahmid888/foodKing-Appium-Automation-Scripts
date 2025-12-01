package com.foodKing.foodKing.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.foodKing.foodKing.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OrderConfirmedPage extends AndroidActions {
	AndroidDriver driver;

	public OrderConfirmedPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Go to Details")
	private WebElement goToDetailsBtn;
	
	@AndroidFindBy(accessibility = "Pay Now")
	private WebElement payNowBtn;

	public void goToDetailsClick() {
		goToDetailsBtn.click();
	}
	
	public void payNowClick() {
		payNowBtn.click();
	}

}
