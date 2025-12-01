package com.foodKing.foodKing.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.foodKing.foodKing.base.AndroidBase;
import com.foodKing.foodKing.pageObjects.android.CartPage;
import com.foodKing.foodKing.pageObjects.android.CheckOutPage;
import com.foodKing.foodKing.pageObjects.android.LoginPage;
import com.foodKing.foodKing.pageObjects.android.MenuPage;
import com.foodKing.foodKing.pageObjects.android.OrderConfirmedPage;
import com.foodKing.foodKing.pageObjects.android.OrderStatusPage;

public class TC28_VerifyPlacedOrderTest extends AndroidBase {

	@Test()
	public void verifyPlacedOrder() throws InterruptedException {

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

		// =========================
		// Capture Checkout Values
		// =========================
		String subtotal = checkoutPage.getSubtotalValue();
		String discount = checkoutPage.getDiscountValue();
		String deliveryCharge = checkoutPage.getDeliveryChargeValue();
		String total = checkoutPage.getTotalValue();

		System.out.println("Subtotal: " + subtotal);
		System.out.println("Discount: " + discount);
		System.out.println("Delivery Charge: " + deliveryCharge);
		System.out.println("Total: " + total);
		checkoutPage.placeOrderBtn();

		OrderConfirmedPage orderConfirmedPage = new OrderConfirmedPage(driver);
		orderConfirmedPage.goToDetailsClick();

		OrderStatusPage orderStatusPage = new OrderStatusPage(driver);
		String title = orderStatusPage.getOrderStatusTitle();
		System.out.println("Title: " + title);
		Assert.assertEquals(title, "Order Status", "Order Status title mismatch!");

		String orderId = orderStatusPage.getOrderId();
		System.out.println("Captured Order ID = " + orderId);
		Assert.assertFalse(orderId.isEmpty(), "Order ID is empty!");
		Assert.assertTrue(orderId.matches("\\d+"), "Order ID format invalid!");

		// =========================
		// Validate Amounts in Order Details
		// =========================
		String subtotalUpdated = orderStatusPage.getSubtotalValue();
		String discountUpdated = orderStatusPage.getDiscountValue();
		String deliveryChargeUpdated = orderStatusPage.getDeliveryChargeValue();
		String totalUpdated = orderStatusPage.getTotalValue();

		Assert.assertEquals(subtotalUpdated, subtotal, "Subtotal value mismatch!");
		Assert.assertEquals(discountUpdated, discount, "Discount value mismatch!");
		Assert.assertEquals(deliveryChargeUpdated, deliveryCharge, "Delivery Charge mismatch!");
		Assert.assertEquals(totalUpdated, total, "Total amount mismatch!");

		Thread.sleep(3000);

	}

}
