package com.company.auth;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGenerator;

public class TC_02_Login extends BaseTest {

	AndroidDriver<MobileElement> driver;
	HomePageObject homePage;
	LoginPageObject loginPage;

	String email, password;

	@BeforeClass
	public void init() {
		email = "test@me.com";
		password = "12345678";

		driver = getAppiumDriver();
		homePage = PageGenerator.getHomePage(driver);
	}

	@Test
	public void TC_02_Login_With_Valid_Email_And_Password() {

		log.info("Step 1: Open Sign up/Login Screen.");
		loginPage = homePage.clickToLoginMenu(driver);

		log.info("Step 2: Enter email '" + email + "' to email textbox.");
		loginPage.enterToEmailTextbox(email);

		log.info("Step 3: Enter password '" + password + "' to password textbox.");
		loginPage.enterToPasswordTextbox(password);

		log.info("Step 4: Click to Login button.");
		loginPage.clickOnLoginButton();

		log.info("Step 5: Verify login successfull message displayed on the popup.");
		Assert.assertTrue(loginPage.isSuccessMessageDisplayed(driver, "You are logged in!"));

		log.info("Step 6: Accept alert popup");
		loginPage.acceptPopup(driver);
	}

	@AfterClass
	public void tearDown() {
		closeApp(driver);
	}

}
