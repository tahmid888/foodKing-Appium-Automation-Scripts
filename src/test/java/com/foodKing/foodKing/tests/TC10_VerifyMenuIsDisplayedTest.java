package com.foodKing.foodKing.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.foodKing.foodKing.base.AndroidBase;
import com.foodKing.foodKing.pageObjects.android.MenuPage;

public class TC10_VerifyMenuIsDisplayedTest extends AndroidBase {

	@Test()
	//dataProvider = "getData"
	//HashMap<String, String> input
	public void verifyMenuIsDisplay() throws InterruptedException {

		MenuPage menuPage = new MenuPage(driver);
		//menuPage.swipeUntilElementVisible(menuPage.getLastMenuItem(), input.get("direction"),10);
		menuPage.swipeUntilElementVisible(menuPage.getLastMenuItem(), "left", 10);
		
		String actualMessage = menuPage.getLastMenuItem().getAttribute("content-desc");
		System.out.println("UI message content-desc: " + actualMessage);
		Assert.assertEquals(actualMessage, "Beverages");
		
	}

//	@DataProvider
//	public Object[][] getData() throws IOException {
//		List<HashMap<String, String>> data = getJsonData(
//				System.getProperty("user.dir") + "//src//test//java//com//foodKing//foodKing//testData//testData.json");
//
//		return new Object[][] { { data.get(7) } };
//	}

}
