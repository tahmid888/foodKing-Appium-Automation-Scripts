package com.foodKing.foodKing.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.foodKing.foodKing.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions {
	AndroidDriver driver;

	public CartPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath ="//android.view.View[contains(@content-desc, \"Chicken Dumplings\")]")
	private WebElement addItem;
	
	@AndroidFindBy(xpath ="//android.widget.ImageView[contains(@content-desc, \"Add to Cart\")]")
	private WebElement addToCart;
	
	@AndroidFindBy(xpath="//android.widget.Toast[@text=\"Added to cart\"]")
	private WebElement addToCartToasterMessage;
	
	
	

	public void tapAddItem() {
		addItem.click();
	}
	
	public void tapAddToCart() {
		addToCart.click();
	}
	public String getAddToCartToasterMessage() {
		return addToCartToasterMessage.getText();
	}
	
}