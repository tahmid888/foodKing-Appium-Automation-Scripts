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
import com.foodKing.foodKing.pageObjects.android.SignUpPage;

public class TC05_SignUpEmptyFieldTest extends AndroidBase {

	@Test(dataProvider = "getData")
	public void signUpEmptyFields(HashMap<String, String> input) {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.profile();
		loginPage.tapLogin();

		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.signUp();
		signUpPage.setMobile(input.get("mobile"));
		signUpPage.clickContinue();
		signUpPage.setFirstName(input.get("firstName"));
		signUpPage.setLastName(input.get("lastName"));
		signUpPage.setEmail(input.get("email"));
		signUpPage.setPassword(input.get("password"));
		signUpPage.signUp();

		EmptyFieldsPage emptyFieldsPage = new EmptyFieldsPage(driver);

		String errorFirstNameMsg = emptyFieldsPage.getFirstNameError();
		Assert.assertEquals(errorFirstNameMsg, "Please type your first name");

		String errorLastNameMsg = emptyFieldsPage.getLastNameError();
		Assert.assertEquals(errorLastNameMsg, "Please type your last name");

		String errorEmailMsg = emptyFieldsPage.getEmailError();
		Assert.assertEquals(errorEmailMsg, "Enter valid email");

		String errorNewPasswordMsg = emptyFieldsPage.getNewPasswordError();
		Assert.assertEquals(errorNewPasswordMsg, "Please type password");

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(
				System.getProperty("user.dir") + "//src//test//java//com//foodKing//foodKing//testData//testData.json");

		return new Object[][] { { data.get(4) } };
	}
}
