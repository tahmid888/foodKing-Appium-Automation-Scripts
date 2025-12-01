package com.foodKing.foodKing.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.foodKing.foodKing.base.AndroidBase;
import com.foodKing.foodKing.pageObjects.android.CartPage;
import com.foodKing.foodKing.pageObjects.android.CheckOutPage;
import com.foodKing.foodKing.pageObjects.android.MenuPage;

public class TC18_ProceedToCheckoutwithoutLoginTest extends AndroidBase{

	
	@Test
	public void proceedToCheckout() {
		
		MenuPage menuPage = new MenuPage(driver);
		menuPage.tapMenu();

		CartPage cartPage = new CartPage(driver);
		cartPage.tapAddItem();
		cartPage.tapAddToCart();
		cartPage.tapViewCart();
		
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		checkOutPage.tapProceedToCheckoutBtn();
		
		String actualText = checkOutPage.getLoginText();
		String expectedText = "Welcome Back!";
		
		Assert.assertEquals(actualText, expectedText, "Text mismatch!");
		

	}
	
}
