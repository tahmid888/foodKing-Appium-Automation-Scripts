package com.foodKing.foodKing.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.foodKing.foodKing.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenuPage  extends AndroidActions{
	AndroidDriver driver;

	public MenuPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath ="//android.view.View[@content-desc=\"Beverages\"]")
	private WebElement menuLastItem;
	

	
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
    
    public WebElement getLastMenuItem()
    {
    	return menuLastItem;
    }
    

}
