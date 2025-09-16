package com.foodKing.foodKing.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.foodKing.foodKing.base.AndroidBase;
import com.foodKing.foodKing.pageObjects.android.EmptyFieldsPage;
import com.foodKing.foodKing.pageObjects.android.LoginPage;

public class TC03_LoginEmptyFieldTest extends AndroidBase {

	@Test(dataProvider = "getData")
	public void loginEmptyFields(HashMap<String, String> input) {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.profile();
		loginPage.tapLogin();
		loginPage.setEmail(input.get("email"));
		loginPage.setPassword(input.get("password"));
		loginPage.tapLogin();

		EmptyFieldsPage emptyFieldsPage = new EmptyFieldsPage(driver);

		String errorEmailMsg = emptyFieldsPage.getEmailError();
		Assert.assertEquals(errorEmailMsg, "Enter valid email");

		String errorPasswordMsg = emptyFieldsPage.getPasswordError();
		Assert.assertEquals(errorPasswordMsg, "Password must be at least 6 charecter");

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(
				System.getProperty("user.dir") + "//src//test//java//com//foodKing//foodKing//testData//testData.json");

		return new Object[][] { { data.get(3) } };
	}

}
