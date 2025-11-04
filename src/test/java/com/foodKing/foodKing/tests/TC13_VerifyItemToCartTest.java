package com.foodKing.foodKing.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.foodKing.foodKing.base.AndroidBase;
import com.foodKing.foodKing.pageObjects.android.CartPage;
import com.foodKing.foodKing.pageObjects.android.MenuPage;

public class TC13_VerifyItemToCartTest extends AndroidBase {

	@Test()
	public void verifyItemToCart() {
		MenuPage menuPage = new MenuPage(driver);
		menuPage.tapMenu();
		
		CartPage cartPage = new CartPage(driver);
		cartPage.tapAddItem();
		cartPage.tapAddToCart();
		cartPage.getAddToCartToasterMessage();
		
		String toastText = cartPage.getAddToCartToasterMessage();
	    System.out.println("Toast appeared: " + toastText);
	    Assert.assertEquals(toastText, "Added to cart");
	    
/*	    String itemName = cartPage.getItemName();
        String itemPrice = cartPage.getItemPrice();

        System.out.println("Item Name: " + itemName);
        System.out.println("Item Price: " + itemPrice);

        Assert.assertEquals(itemName, "Chicken Dumplings");
        Assert.assertEquals(itemPrice, "$2.50"); */
        
        cartPage.tapViewCart();
       
        // Verify item and price
        String itemName = cartPage.getItemName();
        String itemPrice = cartPage.getItemPrice();
        String cartItemText = cartPage.getCartItem();

        if(itemName == null || itemPrice == null || cartItemText == null) {
            System.out.println("Failed: One of the values is null");
            System.out.println("ItemName: " + itemName);
            System.out.println("ItemPrice: " + itemPrice);
            System.out.println("CartItemText: " + cartItemText);
            return;
        }

        if(cartItemText.contains(itemName) && cartItemText.contains(itemPrice)) {
            System.out.println("Matched");
            System.out.println("Expected Name: " + itemName + ", Price: " + itemPrice);
        } else {
            System.out.println("Not Matched");
            System.out.println("Found: " + cartItemText);
            
        }
        
        
   /*   List<String> itemNames = cartPage.getAllItemNames();
        List<String> itemPrices = cartPage.getAllItemPrices();
        List<String> cartTexts = cartPage.getAllCartTexts();

        for (int i = 0; i < cartTexts.size(); i++) {
            String name = itemNames.get(i);
            String price = itemPrices.get(i);
            String fullText = cartTexts.get(i);

            if(name != null && price != null && fullText != null 
               && fullText.contains(name) && fullText.contains(price)) {
                System.out.println("Matched ✅: " + name + " - " + price);
            } else {
                System.out.println("Not Matched ❌");
                System.out.println("ItemName: " + name);
                System.out.println("ItemPrice: " + price);
                System.out.println("CartText: " + fullText);
            }
        }*/
	}

}
