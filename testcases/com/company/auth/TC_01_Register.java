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
import pageObjects.RegisterPageObject;

public class TC_01_Register extends BaseTest {

	AndroidDriver<MobileElement> driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	
	String email, password;

	@BeforeClass
	public void init() {
		email = "test@me.com";
		password = "12345678";
		
		driver = getAppiumDriver();
		homePage = PageGenerator.getHomePage(driver);
	}

	@Test
	public void TC_01_Register_With_Valid_Email_And_Password() {

		log.info("Step 1: Open Sign up/Login Screen.");
		loginPage = homePage.clickToLoginMenu(driver);

		log.info("Step 2: Click to Sign Up label.");
		registerPage = loginPage.clickOnLabel("Sign up");

		log.info("Step 3: Enter email '" + email + "' to email textbox.");
		registerPage.enterToEmailTextbox(email);
		
		log.info("Step 4: Enter password '" + password + "' to password textbox.");
		registerPage.enterToPasswordTextbox(password);
		
		log.info("Step 5: Enter confirm password '" + password + "' to confirm password textbox.");
		registerPage.enterToConfirmPasswordTextbox(password);
		
		log.info("Step 6: Click to Sign Up button.");
		registerPage.clickToSignUpButton();

		log.info("Step 7: Verify register successfull message displayed on the popup.");
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed(driver, "You successfully signed up!"));

		log.info("Step 8: Accept alert popup");
		registerPage.acceptPopup(driver);

	}
	
	@AfterClass
	public void tearDown() {
		closeApp(driver);
	}
}
