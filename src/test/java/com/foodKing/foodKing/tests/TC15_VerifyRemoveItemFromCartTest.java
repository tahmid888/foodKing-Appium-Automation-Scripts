package com.foodKing.foodKing.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.foodKing.foodKing.base.AndroidBase;
import com.foodKing.foodKing.pageObjects.android.CartPage;
import com.foodKing.foodKing.pageObjects.android.MenuPage;

public class TC15_VerifyRemoveItemFromCartTest extends AndroidBase {

	@Test()
	public void verifyRemoveItemFromCart() {

		MenuPage menuPage = new MenuPage(driver);
		menuPage.tapMenu();

		CartPage cartPage = new CartPage(driver);
		cartPage.tapAddItem();
		cartPage.tapAddToCart();
		cartPage.tapViewCart();
		cartPage.clickRemoveBtn();
		
		if (cartPage.isCartEmpty()) {
			Assert.assertTrue(true, "Cart is empty as expected.");
		} else {
			Assert.fail("Cart still contains items!");
		}

	}

}
