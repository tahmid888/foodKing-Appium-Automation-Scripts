package com.foodKing.foodKing.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.foodKing.foodKing.base.AndroidBase;
import com.foodKing.foodKing.pageObjects.android.MenuPage;

public class TC11_CountAllMenuAndDisplayedTest extends AndroidBase {

	@Test()
	public void countMenuIsDisplayAndPrint() throws InterruptedException {

		MenuPage menuPage = new MenuPage(driver);

		// menuPage.countAndPrintMenuItems("left");

		List<String> categories = menuPage.countAndPrintMenuItems("left");

		// You can now assert:
		Assert.assertTrue(categories.contains("Beverages"));
		Assert.assertTrue(categories.contains("Side Orders"));
		Assert.assertTrue(categories.size() > 0);

		// or just print
		// System.out.println("Categories: " + categories);

	}
}
