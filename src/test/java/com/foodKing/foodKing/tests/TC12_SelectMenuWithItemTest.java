package com.foodKing.foodKing.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.foodKing.foodKing.base.AndroidBase;
import com.foodKing.foodKing.pageObjects.android.LogOutPage;
import com.foodKing.foodKing.pageObjects.android.MenuPage;

public class TC12_SelectMenuWithItemTest extends AndroidBase{

	
	@Test()
	public void selectMenuItemAndVerify() throws InterruptedException {
		MenuPage menuPage = new MenuPage(driver);
		menuPage.tapMenu();
		
		String actualMsg = menuPage.getMenu();
		Assert.assertTrue(actualMsg.contains("Appetizers"));
		
		menuPage.scrollTo("Vegetable Roll");
		
		Thread.sleep(5000);
		
	}
	
	
}
