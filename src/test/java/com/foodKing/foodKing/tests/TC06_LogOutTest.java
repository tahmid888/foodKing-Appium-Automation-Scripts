package com.foodKing.foodKing.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.foodKing.foodKing.base.AndroidBase;
import com.foodKing.foodKing.pageObjects.android.LogOutPage;
import com.foodKing.foodKing.pageObjects.android.LoginPage;

public class TC06_LogOutTest extends AndroidBase {

	@Test(dataProvider = "getData")
	public void logOut(HashMap<String, String> input) {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.profile();
		loginPage.tapLogin();
		loginPage.setEmail(input.get("email"));
		loginPage.setPassword(input.get("password"));
		loginPage.tapLogin();
		loginPage.profile();
		WebElement successMessage = loginPage.loginSuccessMessage();
		String actualMessage = successMessage.getAttribute("contentDescription");
		Assert.assertEquals(actualMessage, "Success\nLogin Successfully.", "Login message did not match!");

		LogOutPage logOutPage = new LogOutPage(driver);
		logOutPage.clickLogOut("Log Out");

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(
				System.getProperty("user.dir") + "//src//test//java//com//foodKing//foodKing//testData//testData.json");

		return new Object[][] { { data.get(1) } };
	}
}
