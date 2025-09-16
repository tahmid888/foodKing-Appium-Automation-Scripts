package com.foodKing.foodKing.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.foodKing.foodKing.base.AndroidBase;
import com.foodKing.foodKing.pageObjects.android.SearchPage;

public class TC07_SearchFunctionalityTest extends AndroidBase {

	@Test(dataProvider = "getData")
	public void searchFunctionality(HashMap<String, String> input) throws InterruptedException {

		SearchPage searchPage = new SearchPage(driver);
		searchPage.setSearch(input.get("search"));
		// searchPage.waitUntilItemsAvailableTextContains("Items Available");
		String actualMessage = searchPage.waitForItemsAvailableText();
		System.out.println("UI message: " + actualMessage);

		Assert.assertTrue(actualMessage.contains("Items Available"),
				"Expected 'Items Available' message but got: " + actualMessage);

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(
				System.getProperty("user.dir") + "//src//test//java//com//foodKing//foodKing//testData//testData.json");

		return new Object[][] { { data.get(5) } };
	}

}
