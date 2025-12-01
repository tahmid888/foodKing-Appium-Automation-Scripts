package com.foodKing.foodKing.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.foodKing.foodKing.base.AndroidBase;
import com.foodKing.foodKing.pageObjects.android.CartPage;
import com.foodKing.foodKing.pageObjects.android.CheckOutPage;
import com.foodKing.foodKing.pageObjects.android.LoginPage;
import com.foodKing.foodKing.pageObjects.android.MenuPage;

public class TC24_VerifyCartSummeryDetailsTest extends AndroidBase{

	@Test()
	public void verifyCartSummeryDetails() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.profile();
		loginPage.tapLogin();
		loginPage.setEmail("customer@example.com");
		loginPage.setPassword("123456");
		loginPage.tapLogin();

		MenuPage menuPage = new MenuPage(driver);
		menuPage.tapMenu();

		CartPage cartPage = new CartPage(driver);
		cartPage.tapAddItem();
		cartPage.tapAddToCart();
		cartPage.tapViewCart();

		CheckOutPage checkoutPage = new CheckOutPage(driver);
		checkoutPage.tapProceedToCheckoutBtn();
		checkoutPage.clickDeliveryTab();
		
		Map<String, String> item = checkoutPage.getCartItemDetails("Chicken Dumplings");
		
		System.out.println(item.get("qty"));
		System.out.println(item.get("name"));
		System.out.println(item.get("price"));
		
	    Assert.assertEquals(item.get("qty"), "1");
	    Assert.assertEquals(item.get("name"), "Chicken Dumplings");
	    Assert.assertEquals(item.get("price"), "2.50");
	}
	
}
