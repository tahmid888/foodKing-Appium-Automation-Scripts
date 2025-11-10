package com.foodKing.foodKing.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.foodKing.foodKing.base.AndroidBase;
import com.foodKing.foodKing.pageObjects.android.CartPage;
import com.foodKing.foodKing.pageObjects.android.MenuPage;

public class TC16_SubTotalAmountTest extends AndroidBase{

	@Test
	public void verifySubtotal() throws InterruptedException {
		MenuPage menuPage = new MenuPage(driver);
		menuPage.tapMenu();

		CartPage cartPage = new CartPage(driver);
		cartPage.tapAddItem();
		cartPage.tapAddToCart();
		cartPage.tapViewCart();
		
		double actualSubtotal = cartPage.getSubtotalAmount();
	    System.out.println("Subtotal value found: " + actualSubtotal);

	    double expectedSubtotal = 2.50;
	    Assert.assertEquals(actualSubtotal, expectedSubtotal, "Subtotal mismatch!");

	}
}
