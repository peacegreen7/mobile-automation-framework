package pageObjects;

import commons.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HomePageObject extends BasePage {

	private AndroidDriver<MobileElement> driver;

	public HomePageObject(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
}
