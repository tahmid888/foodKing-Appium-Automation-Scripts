package com.foodKing.foodKing.pageObjects.android;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.foodKing.foodKing.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OrderStatusPage extends AndroidActions {
	AndroidDriver driver;

	public OrderStatusPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Order Status")
	private WebElement orderStatusTitle;

	@AndroidFindBy(accessibility = "Order Status")
	private WebElement orderId;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Order ID: #']/following-sibling::android.view.View[1]")
	private WebElement orderIdValue;

	public String getOrderStatusTitle() {
		return orderStatusTitle.getAttribute("content-desc");
	}

	public String getOrderId() {
		return orderIdValue.getAttribute("content-desc").trim();
	}

	// Scrolling Down -> Order Status Page
	public void scrollDownFromXY() {
		int screenWidth = driver.manage().window().getSize().width;
		int screenHeight = driver.manage().window().getSize().height;

		// x and y are the starting point of swipe
		int startX = 510; // horizontal center
		int startY = 1240; // vertical start
		int endY = (int) (screenHeight * 0.3); // scroll up by some percentage of screen

		Map<String, Object> params = new HashMap<>();
		params.put("left", startX);
		params.put("top", startY);
		params.put("width", screenWidth - startX); // width of gesture
		params.put("height", startY - endY); // height of gesture
		params.put("direction", "down"); // scroll down
		params.put("percent", 0.6); // scroll 60% of area

		driver.executeScript("mobile: scrollGesture", params);
	}

	public String getAmountByLabel(String label) {

		// Try to find element with scroll up loop
		for (int i = 0; i < 5; i++) {
			try {
				WebElement value = driver.findElement(
						By.xpath("//*[@content-desc='" + label + "']/following-sibling::android.view.View[2]"));
				return value.getAttribute("content-desc");
			} catch (Exception e) {
				scrollDownFromXY(); // scroll up until element is found
			}
		}

		throw new RuntimeException(label + " not found after scrolling up!");
	}

	public String getSubtotalValue() {
		return getAmountByLabel("Subtotal");
	}

	public String getDiscountValue() {
		return getAmountByLabel("Discount");
	}

	public String getDeliveryChargeValue() {
		return getAmountByLabel("Delivery Charge");
	}

	public String getTotalValue() {
		return getAmountByLabel("Total");
	}

}
