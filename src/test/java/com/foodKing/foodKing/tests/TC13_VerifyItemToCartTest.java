package com.foodKing.foodKing.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.foodKing.foodKing.base.AndroidBase;
import com.foodKing.foodKing.pageObjects.android.CartPage;
import com.foodKing.foodKing.pageObjects.android.MenuPage;

public class TC13_VerifyItemToCartTest extends AndroidBase{
	
	
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
		
		
	}

}
