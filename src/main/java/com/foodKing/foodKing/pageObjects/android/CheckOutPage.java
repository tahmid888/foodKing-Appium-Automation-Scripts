package com.foodKing.foodKing.pageObjects.android;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.foodKing.foodKing.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckOutPage extends AndroidActions {

	AndroidDriver driver;

	public CheckOutPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Procced to Checkout")
	private WebElement proceedToCheckoutBtn;

	@AndroidFindBy(accessibility = "Checkout")
	private WebElement checkoutTitle;

	@AndroidFindBy(accessibility = "Delivery Address")
	private WebElement deliveryAddressSection;

	@AndroidFindBy(accessibility = "Preference Time to Delivery")
	private WebElement preferenceTimeSection;

	@AndroidFindBy(accessibility = "Cart Summary")
	private WebElement cartSummarySection;

	@AndroidFindBy(accessibility = "Total")
	private WebElement totalSection;

	@AndroidFindBy(accessibility = "Welcome Back!")
	private WebElement loginText;

	@AndroidFindBy(xpath = "//*[contains(@content-desc, 'Work')]")
	private WebElement workAddressType;

	@AndroidFindBy(xpath = "//*[contains(@content-desc, 'Dhaka') or contains(@content-desc, 'Bangladesh') or contains(@content-desc, 'Mirpur')]")
	private WebElement addressText;

	@AndroidFindBy(accessibility = "Edit")
	private WebElement editText;

	@AndroidFindBy(accessibility = "Confirm Location")
	private WebElement confirmLocationBtn;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Home Dhaka Bangladesh 625, Gulshan 2\"]")
	private WebElement menuLastAddress;
	
	@AndroidFindBy(accessibility = "Add")
	private WebElement addDeliveryAddress;
	
	@AndroidFindBy(accessibility = "Today")
	private WebElement todayDelivery;
	
	@AndroidFindBy(accessibility = "Now")
	private WebElement nowDelivery;
	
	@AndroidFindBy(accessibility = "Delivery")
	private WebElement deliveryTab;
	
	@AndroidFindBy(accessibility = "Takeaway")
	private WebElement takewayTab;
	
    @AndroidFindBy(xpath = "//android.view.View[@content-desc]")
	private List<WebElement> cartItems;
    
    @AndroidFindBy(accessibility = "Place Order")
	private WebElement placeOrderBtn;
    
    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Order Confirmed')]")
    private WebElement orderConfirmedText;


	public void tapProceedToCheckoutBtn() {
		proceedToCheckoutBtn.click();
	}

	public String getLoginText() {
		return loginText.getAttribute("content-desc");
	}

	public WebElement scrollToElement(String addAccId) {
		WebElement element = scrollToElementByAccessibilityIdForDescription(addAccId);
		// System.out.println("Scrolled to: " + element.getAttribute("content-desc"));
		return element;
	}

	public WebElement getCheckoutTitle() {
		return checkoutTitle;
	}

	public WebElement getDeliveryAddressSection() {
		return deliveryAddressSection;
	}

	public WebElement getPreferenceTimeSection() {
		return preferenceTimeSection;
	}

	public WebElement getCartSummarySection() {
		return cartSummarySection;
	}

	public WebElement getTotal() {
		scrollToElement("Total");
		return totalSection;
	}

	// Address
	public void clickWorkAddress() {
		workAddressType.click();
	}

	public String getUpdatedAddress() {
		return addressText.getAttribute("content-desc");
	}

	public void clickEditAddress() {
		editText.click();
	}
	
	public void clickAddAddress() {
		addDeliveryAddress.click();
	}

	public String getConfirmLocation() {
		return confirmLocationBtn.getAttribute("content-desc");
	}
	
	// Permission
	public void handleLocationPermission() {
	    try {
	        if (driver.findElements(By.xpath("//*[@text='Allow only while using the app']")).size() > 0) {
	            driver.findElement(By.xpath("//*[@text='Allow only while using the app']")).click();
	        } else if (driver.findElements(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).size() > 0) {
	            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
	        } else if (driver.findElements(By.xpath("//*[@text='Allow']")).size() > 0) {
	            driver.findElement(By.xpath("//*[@text='Allow']")).click();
	        }
	    } catch (Exception e) {
	        System.out.println("No permission popup displayed.");
	    }
	}
	
	public void clickTodayDelivery() {
		todayDelivery.click();
	}
	
	public void clickNowDelivery() {
		nowDelivery.click();
	}

	public void clickDeliveryTab() {
		deliveryTab.click();
	}
	
	public void clickTakeawayTab() {
		takewayTab.click();
	}
	
	// Order / Cart Details
	public Map<String, String> getCartItemDetails(String expectedName) {

        for (WebElement item : cartItems) {

            String desc = item.getAttribute("contentDescription");
            // Example:
            // "1\nChicken\nDumplings\n$\n2.50"

            String[] lines = desc.split("\n");

            String qty = lines[0];           // 1
            String price = lines[lines.length - 1];   // 2.50

            // Name = middle lines except `$`
            StringBuilder nameBuilder = new StringBuilder();
            for (int i = 1; i < lines.length - 2; i++) {
                nameBuilder.append(lines[i]).append(" ");
            }

            String name = nameBuilder.toString().trim();

            if (name.equalsIgnoreCase(expectedName)) {

                Map<String, String> details = new HashMap<>();
                details.put("qty", qty);
                details.put("name", name);
                details.put("price", price);

                return details;
            }
        }

        return null;
    }
	
	// Scrolling Down -> Checkout Page
	public void scrollDownFromXY() {
	    int screenWidth = driver.manage().window().getSize().width;
	    int screenHeight = driver.manage().window().getSize().height;

	    // x and y are the starting point of swipe
	    int startX = 510;            // horizontal center
	    int startY = 1240;           // vertical start
	    int endY = (int)(screenHeight * 0.3);  // scroll up by some percentage of screen

	    Map<String, Object> params = new HashMap<>();
	    params.put("left", startX);
	    params.put("top", startY);
	    params.put("width", screenWidth - startX);  // width of gesture
	    params.put("height", startY - endY);        // height of gesture
	    params.put("direction", "down");            // scroll down
	    params.put("percent", 0.6);                 // scroll 60% of area

	    driver.executeScript("mobile: scrollGesture", params);
	}



	public String getAmountByLabel(String label) {

	    // Try to find element with scroll up loop
	    for (int i = 0; i < 5; i++) {
	        try {
	            WebElement value = driver.findElement(By.xpath(
	                    "//*[@content-desc='" + label + "']/following-sibling::android.view.View[2]"
	            ));
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
	
	public void placeOrderBtn() {
	     placeOrderBtn.click();
	}
	
	
	// Get full content-desc text
    public String getFullOrderMessage() {
       WebElement element = orderConfirmedText;
        return element.getAttribute("content-desc");
    }

    // Extract only "Order Confirmed" from the full text
    public String getOrderConfirmedLine() {
        String fullText = getFullOrderMessage();
        // Split by newline and find the line that contains "Order Confirmed"
        for (String line : fullText.split("\n")) {
            if (line.trim().equalsIgnoreCase("Order Confirmed")) {
                return line.trim();
            }
        }
        return "";
    }

    // Validate presence
    public boolean isOrderConfirmedVisible() {
        return !getOrderConfirmedLine().isEmpty();
    }


}

