package com.foodKing.foodKing.pageObjects.android;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.foodKing.foodKing.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenuPage extends AndroidActions {
	AndroidDriver driver;

	public MenuPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Beverages\"]")
	private WebElement menuLastItem;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc]")
	private WebElement menuAllItem;

	By menuItemsLocator = By
			.xpath("//android.widget.ScrollView/android.view.View[3]//android.view.View[@content-desc]");

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Appetizers\"]")
	private WebElement selectMenuItem;

	@AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Appetizers\"])[2]")
	private WebElement getMenuItem;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Add\"]")
	private WebElement clickAddBtn;
	


	// Swipe menu till it found
	public void swipeUntilElementVisible(WebElement element, String direction, int maxSwipes) {
		int attempts = 0;
		while (attempts < maxSwipes) {
			try {
				// If it's displayed, break out
				if (element.isDisplayed()) {
					System.out.println("Element found after " + attempts + " swipes.");
					return;
				}
			} catch (Exception e) {
				// Ignore NoSuchElement or StaleElement exceptions
			}

			// Perform swipe based on direction
			if (direction.equalsIgnoreCase("left")) {
				swipeLeftOnMenu();

			} else {
				swipeRightOnMenu();
			}

			attempts++;
		}
		throw new RuntimeException("Element not found after " + maxSwipes + " swipes");
	}

	public WebElement getLastMenuItem() {
		return menuLastItem;
	}

	// Count menu and Print all menu
	// If not return, Use void
	public List<String> countAndPrintMenuItems(String direction) {
		Set<String> seen = new LinkedHashSet<>();
		int sameCount = 0;

		while (sameCount < 3) { // stops when no new items appear twice in a row
			// grab visible items
			List<WebElement> visibleItems = driver.findElements(menuItemsLocator);

			for (WebElement item : visibleItems) {
				seen.add(item.getAttribute("content-desc")); // or getText()
			}

			int before = seen.size();
			if (direction.equalsIgnoreCase("left")) {
				swipeLeftOnMenu();
			} else {
				swipeRightOnMenu();
			}

			// small wait for UI to settle
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
			}

			if (seen.size() == before) {
				sameCount++; // no new items found
			} else {
				sameCount = 0; // new items found, keep swiping
			}
		}

		System.out.println("Total menu items found: " + seen.size());
		for (String name : seen) {
			System.out.println(name);
		}

		return new ArrayList<>(seen); // return as list for further use
	}

	public void tapMenu() {
		selectMenuItem.click();
	}

	public String getMenu() {
		waitForVisibility(getMenuItem, 10);
		return getMenuItem.getAttribute("content-desc");
	}

	public void scrollTo(String addAccId) {
		WebElement element = scrollToElementByAccessibilityId(addAccId);
		element.click();
	}
}
