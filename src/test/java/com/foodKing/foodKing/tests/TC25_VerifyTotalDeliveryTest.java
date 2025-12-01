package com.foodKing.foodKing.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.foodKing.foodKing.base.AndroidBase;
import com.foodKing.foodKing.pageObjects.android.CartPage;
import com.foodKing.foodKing.pageObjects.android.CheckOutPage;
import com.foodKing.foodKing.pageObjects.android.LoginPage;
import com.foodKing.foodKing.pageObjects.android.MenuPage;

public class TC25_VerifyTotalDeliveryTest extends AndroidBase {

	@Test()
	public void verifyTotalDelivery() {

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
		checkoutPage.clickWorkAddress();
		checkoutPage.clickDeliveryTab();

		String subtotal = checkoutPage.getSubtotalValue();
		String discount = checkoutPage.getDiscountValue();
		String deliveryCharge = checkoutPage.getDeliveryChargeValue();
		String total = checkoutPage.getTotalValue();

		System.out.println("Subtotal: " + subtotal);
		System.out.println("Discount: " + discount);
		System.out.println("Delivery Charge: " + deliveryCharge);
		System.out.println("Total: " + total);

		Assert.assertNotNull(subtotal);
		Assert.assertNotNull(discount);
		Assert.assertNotNull(deliveryCharge);
		Assert.assertNotNull(total);

	}

}
