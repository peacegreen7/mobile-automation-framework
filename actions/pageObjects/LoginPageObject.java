package pageObjects;

import UIs.LoginPageUI;
import commons.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LoginPageObject extends BasePage {

	private AndroidDriver<MobileElement> driver;

	public LoginPageObject(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisibleByAccessibilityId(driver, LoginPageUI.EMAIL_TEXTBOX_BY_ID);
		sendKeysToElementByAccessibilityId(driver, LoginPageUI.EMAIL_TEXTBOX_BY_ID, email);
	}

	public void enterToPasswordTextbox(String pwd) {
		waitForElementVisibleByAccessibilityId(driver, LoginPageUI.PASSWORD_TEXTBOX_BY_ID);
		sendKeysToElementByAccessibilityId(driver, LoginPageUI.PASSWORD_TEXTBOX_BY_ID, pwd);
	}

	public void clickOnLoginButton() {
		waitForElementClickableByXpath(driver, LoginPageUI.LOG_IN_BUTTON_BY_XPATH);
		clickToElementByXpath(driver, LoginPageUI.LOG_IN_BUTTON_BY_XPATH);
	}

//	public RegisterPageObject clickOnLabel(String itemText) {
//		waitForTextToBePresentInElementLocatedByXpath(driver, LoginPageUI.SIGNUP_LABEL_BY_XPATH, itemText);
//		clickToElementByXpath(driver, LoginPageUI.SIGNUP_LABEL_BY_XPATH);
//		return PageGenerator.getRegisterPage(driver);
//	}
	
	public RegisterPageObject clickOnLabel(String itemText) {
		waitForTextToBePresentInElementLocatedByXpath(driver, LoginPageUI.SIGNUP_LABEL_BY_TEXT, itemText);
		clickToElementByXpath(driver, LoginPageUI.SIGNUP_LABEL_BY_TEXT);
		return PageGenerator.getRegisterPage(driver);
	}
}
