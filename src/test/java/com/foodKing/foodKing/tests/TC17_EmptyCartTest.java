package com.foodKing.foodKing.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.foodKing.foodKing.base.AndroidBase;
import com.foodKing.foodKing.pageObjects.android.CartPage;
import com.foodKing.foodKing.pageObjects.android.MenuPage;

public class TC17_EmptyCartTest extends AndroidBase{

	@Test
	public void verifyEmptyCart() throws InterruptedException {

		CartPage cartPage = new CartPage(driver);
		cartPage.tapCartBtn();
		
		if (cartPage.isCartEmpty()) {
			Assert.assertTrue(true, "Cart is empty as expected.");
		} else {
			Assert.fail("Cart still contains items!");
		}


	}
}
