package com.foodKing.foodKing.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.foodKing.foodKing.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckOutPage extends AndroidActions{
	
	AndroidDriver driver;

	public CheckOutPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility = "Procced to Checkout")
	private WebElement proceedToCheckoutBtn;
	
	@AndroidFindBy(accessibility = "Welcome Back!")
	private WebElement loginText;
	
	
	public void tapProceedToCheckoutBtn() {
		 proceedToCheckoutBtn.click();
	}
	
	public String getLoginText() {
	return 	loginText.getAttribute("content-desc");
	}


}
