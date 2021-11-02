package pageObjects;

import commons.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PageGenerator extends BasePage {

	static LoginPageObject loginPage;
	static RegisterPageObject registerPage;
	static HomePageObject homePage;

	public static LoginPageObject getLoginPage(AndroidDriver<MobileElement> driver) {
		if (loginPage == null) {
			loginPage = new LoginPageObject(driver);
		}
		return loginPage;
	}

	public static RegisterPageObject getRegisterPage(AndroidDriver<MobileElement> driver) {
		if (registerPage == null) {
			registerPage = new RegisterPageObject(driver);
		}
		return registerPage;
	}

	public static HomePageObject getHomePage(AndroidDriver<MobileElement> driver) {
		if (homePage == null) {
			homePage = new HomePageObject(driver);
		}
		return homePage;
	}

}
