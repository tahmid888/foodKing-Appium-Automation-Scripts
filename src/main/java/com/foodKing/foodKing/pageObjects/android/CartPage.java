package com.foodKing.foodKing.pageObjects.android;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	//Chicken Dumplings
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, \"Egg Roll\")]")
	private WebElement tapAddItem;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, \"Add to Cart\")]")
	private WebElement addToCartBtn;

	@AndroidFindBy(xpath = "//android.widget.Toast[@text=\"Added to cart\"]")
	private WebElement addToCartToasterMessage;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc[contains(., 'Egg Roll')]]")
	private WebElement itemName;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc[contains(.,\"View cart\")]]")
	private WebElement viewCartBtn;

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'$')]")
	private WebElement cartItem;

	// Dynamic list of all items in the cart
//	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'$')]")
//    private List<WebElement> cartItems;
	
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,' ') and contains(@content-desc,'1')]/android.widget.ImageView[1]")
	private WebElement removeBtn;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Your cart is empty']")
	private List<WebElement> emptyCartMsg;

	

	

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

	/*
	 * // Extract item name from a contentDescription public String
	 * getItemName(String content) { if(content == null) return null; Pattern
	 * pattern = Pattern.compile("^(.*?)\\s*\\$", Pattern.DOTALL); Matcher matcher =
	 * pattern.matcher(content); if (matcher.find()) { return
	 * matcher.group(1).trim(); } return null; }
	 * 
	 * // Extract item price from a contentDescription public String
	 * getItemPrice(String content) { if(content == null) return null; Pattern
	 * pattern = Pattern.compile("\\$\\s*(\\d+\\.\\d+)", Pattern.DOTALL); Matcher
	 * matcher = pattern.matcher(content); if (matcher.find()) { return
	 * matcher.group(1); } return null; }
	 * 
	 * // Get all item names in the cart public List<String> getAllItemNames() {
	 * List<String> names = new ArrayList<>(); for (WebElement item : cartItems) {
	 * names.add(getItemName(item.getAttribute("contentDescription"))); } return
	 * names; }
	 * 
	 * // Get all item prices in the cart public List<String> getAllItemPrices() {
	 * List<String> prices = new ArrayList<>(); for (WebElement item : cartItems) {
	 * prices.add(getItemPrice(item.getAttribute("contentDescription"))); } return
	 * prices; }
	 * 
	 * // Get full contentDescriptions of all items public List<String>
	 * getAllCartTexts() { List<String> texts = new ArrayList<>(); for (WebElement
	 * item : cartItems) { texts.add(item.getAttribute("contentDescription")); }
	 * return texts; }
	 */
	
	
	public void clickRemoveBtn() {
	    removeBtn.click();
	}
	public boolean isCartEmpty() {
	    return !emptyCartMsg.isEmpty();
	}
}