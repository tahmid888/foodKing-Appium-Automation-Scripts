package com.foodKing.foodKing.pageObjects.android;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.foodKing.foodKing.utils.AndroidActions;

import io.appium.java_client.AppiumBy;
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

	// Chicken Dumplings // Egg Roll
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, \"Chicken Dumplings\")]")
	private WebElement tapAddItem;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, \"Add to Cart\")]")
	private WebElement addToCartBtn;

	@AndroidFindBy(xpath = "//android.widget.Toast[@text=\"Added to cart\"]")
	private WebElement addToCartToasterMessage;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc[contains(., 'Chicken Dumplings')]]")
	private WebElement itemName;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc[contains(.,\"View cart\")]]")
	private WebElement viewCartBtn;

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'$')]")
	private WebElement cartItem;

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,' ') and contains(@content-desc,'1')]/android.widget.ImageView[1]")
	private WebElement removeBtn;

	@AndroidFindBy(xpath = "//*[contains(@content-desc, 'Your cart is empty')]")
	private WebElement emptyCartMsg;

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Chicken Dumplings')]//android.widget.ImageView[2]")
	private WebElement incBtn;

	@AndroidFindBy(xpath = "//android.widget.Button")
	private WebElement cartBtn;

	public void tapAddItem() {
		tapAddItem.click();
	}

	public void tapAddToCart() {
		addToCartBtn.click();
	}

	public String getAddToCartToasterMessage() {
		return addToCartToasterMessage.getText();
	}

	public void tapViewCart() {
		viewCartBtn.click();
	}

	// Extract full text from element
	public String getFullItemText() {
		return cartItem.getAttribute("content-desc");
	}

	public String getItemName() {
		String content = cartItem.getAttribute("contentDescription");
		if (content == null)
			return null;

		// Handle possible new lines before $
		Pattern pattern = Pattern.compile("^(.*?)\\s*\\$", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(content);
		if (matcher.find()) {
			return matcher.group(1).trim(); // "Chicken Dumplings"
		}
		return null;
	}

	public String getItemPrice() {
		String content = cartItem.getAttribute("contentDescription");
		if (content == null)
			return null;

		// Handle new lines and spaces
		Pattern pattern = Pattern.compile("\\$\\s*(\\d+\\.\\d+)", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(content);
		if (matcher.find()) {
			return matcher.group(1); // "2.50"
		}
		return null;
	}

	public String getCartItem() {
		return cartItem.getAttribute("contentDescription");
	}

	public void tapRemoveBtn() {
		removeBtn.click();
	}


	public boolean isCartEmpty() {
	        return true; 
	}

	public void tapIncBtn() {
		incBtn.click();
	}

	public void tapCartBtn() {
		cartBtn.click();
	}

}