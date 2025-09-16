package com.foodKing.foodKing.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import testappium.utils.AppiumUtils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AndroidBase extends AppiumUtils {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass()
	public void setUp() throws IOException {

		// Load properties
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/com/foodKing/foodKing/properties/data.properties");
		prop.load(fis);

		String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress")
				: prop.getProperty("ipAddress");
		// String port = prop.getProperty("port");
		int port = Integer.parseInt(prop.getProperty("port"));

		// Start Appium server programmatically
		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node")) // Node
																												// executable
						.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js")) // Appium
																										// main.js
						.withIPAddress(ipAddress).usingPort(port));
		service.start();

		// Configure Android driver
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
		options.setApp(
				System.getProperty("user.dir") + "/src/test/java/com/foodKing/foodKing/resources/FoodKingApp.apk");
		options.setCapability("autoGrantPermissions", true);

		// Initialize Android driver
		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass()
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}
