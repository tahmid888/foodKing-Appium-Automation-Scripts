package com.foodKing.foodKing.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.foodKing.foodKing.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPage extends AndroidActions {

	AndroidDriver driver;

	public SearchPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Search']/android.view.View[2]")
	private WebElement searchFieldBar;

	@AndroidFindBy(xpath = "//android.widget.EditText")
	private WebElement searchInput;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"No Item Available\"]")
	private WebElement noSearchMessage;

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Items Available')]")
	private WebElement itemAvailable;

	public void clickSearch() {
		searchFieldBar.click();
	}

	public void setSearch(String search) {
		searchFieldBar.click();
		WebElement input = waitForVisibility(searchInput, 10);
		input.click();
		input.sendKeys(search);

		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	}

	public String waitForItemsAvailableText() {
		WebElement visibleElement = waitForVisibility(itemAvailable, 15);
		return visibleElement.getAttribute("contentDescription");
	}
//	public void waitUntilItemsAvailableTextContains(String text) {
//	// Wait until contentDescription contains specific text
//	waitForAttributeContains(itemAvailable, "contentDescription", text, 15);
//}

	public String getNoSearchResult() {
		WebElement input = waitForVisibility(noSearchMessage, 10);
		return input.getAttribute("contentDescription");
	}

}
