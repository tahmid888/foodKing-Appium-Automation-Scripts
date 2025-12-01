package com.foodKing.foodKing.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.foodKing.foodKing.base.AndroidBase;
import com.foodKing.foodKing.pageObjects.android.CartPage;
import com.foodKing.foodKing.pageObjects.android.CheckOutPage;
import com.foodKing.foodKing.pageObjects.android.LoginPage;
import com.foodKing.foodKing.pageObjects.android.MenuPage;

public class TC19_ProceedToCheckoutTest extends AndroidBase {

	@Test()
	public void proceedToCheckout() {

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

		
		Assert.assertTrue(checkoutPage.getCheckoutTitle().isDisplayed(), "Checkout title not visible");

		Assert.assertTrue(checkoutPage.getDeliveryAddressSection().isDisplayed(), "Delivery Address section not visible");

		Assert.assertTrue(checkoutPage.getPreferenceTimeSection().isDisplayed(), "Preference Time to Delivery section not visible");

		Assert.assertTrue(checkoutPage.getCartSummarySection().isDisplayed(), "Cart Summary section not visible");

		checkoutPage.scrollToElement("Total");

		Assert.assertTrue(checkoutPage.getTotal().isDisplayed(), "Total section not visible");

	}

}
