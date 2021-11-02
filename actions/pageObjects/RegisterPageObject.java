package pageObjects;

import UIs.RegisterPageUI;
import commons.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class RegisterPageObject extends BasePage {

	private AndroidDriver<MobileElement> driver;

	public RegisterPageObject(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisibleByAccessibilityId(driver, RegisterPageUI.EMAIL_TEXTBOX_BY_ACCESSIBILITY_ID);
		sendKeysToElementByAccessibilityId(driver, RegisterPageUI.EMAIL_TEXTBOX_BY_ACCESSIBILITY_ID, email);
	}

	public void enterToPasswordTextbox(String pwd) {
		waitForElementVisibleByAccessibilityId(driver, RegisterPageUI.PASSWORD_TEXTBOX_BY_ACCESSIBILITY_ID);
		sendKeysToElementByAccessibilityId(driver, RegisterPageUI.PASSWORD_TEXTBOX_BY_ACCESSIBILITY_ID, pwd);
	}

	public void enterToConfirmPasswordTextbox(String pwd) {
		waitForElementVisibleByAccessibilityId(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX_BY_ACCESSIBILITY_ID);
		sendKeysToElementByAccessibilityId(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX_BY_ACCESSIBILITY_ID, pwd);
	}

	public void clickToSignUpButton() {
		waitForElementClickableByXpath(driver, RegisterPageUI.REGISTER_BUTTON_BY_XPATH);
		clickToElementByXpath(driver, RegisterPageUI.REGISTER_BUTTON_BY_XPATH);
	}

}
