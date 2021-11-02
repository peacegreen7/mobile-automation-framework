package commons;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UIs.ConfirmPopupUI;
import UIs.NavigationMenuPageUI;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pageObjects.LoginPageObject;
import pageObjects.PageGenerator;
import ultilities.SwipeAction;

public class BasePage {

	public static BasePage getBasePage() {
		return new BasePage();
	}
	
	public MobileElement getElementByID(AndroidDriver<MobileElement> driver, String locator) {
		return driver.findElement(MobileBy.id(locator));
	}
	
	public MobileElement getElementByXpath(AndroidDriver<MobileElement> driver, String locator) {
		return driver.findElement(MobileBy.xpath(locator));
	}

	public MobileElement getElementByAccessibilityId(AndroidDriver<MobileElement> driver, String locator) {
		return driver.findElement(MobileBy.AccessibilityId(locator));
	}

	public void sendKeysToElementByXpath(AndroidDriver<MobileElement> driver, String locator, String textItem) {
		getElementByXpath(driver, locator).clear();
		getElementByXpath(driver, locator).sendKeys(textItem);
	}
	
	public void sendKeysToElementByID(AndroidDriver<MobileElement> driver, String locator, String textItem) {
		getElementByID(driver, locator).clear();
		getElementByID(driver, locator).sendKeys(textItem);
	}

	public void sendKeysToElementByAccessibilityId(AndroidDriver<MobileElement> driver, String locator, String textItem) {
		getElementByAccessibilityId(driver, locator).clear();
		getElementByAccessibilityId(driver, locator).sendKeys(textItem);
	}

	public void clickToElementByXpath(AndroidDriver<MobileElement> driver, String locator) {
		getElementByXpath(driver, locator).click();
	}

	public void clickToElementByID(AndroidDriver<MobileElement> driver, String locator) {
		getElementByID(driver, locator).click();
	}
	
	public void clickToElementByAccessibilityId(AndroidDriver<MobileElement> driver, String locator) {
		getElementByAccessibilityId(driver, locator).click();
	}

	public boolean isElementDisplayed(MobileElement element) {
		return element.isDisplayed();
	}

	public String getElementAttribute(MobileElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	public String getElementText(MobileElement element) {
		return element.getText();
	}

	public void waitForElementVisibleByXpath(AndroidDriver<MobileElement> driver, String locator) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath(locator)));

	}

	public void waitForElementClickableByXpath(AndroidDriver<MobileElement> driver, String locator) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath(locator)));
	}

	public void waitForElementInvisibleByXpath(AndroidDriver<MobileElement> driver, String locator) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.xpath(locator)));
	}

	public void waitForTextToBePresentInElementLocatedByXpath(AndroidDriver<MobileElement> driver, String locator,
			String text) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.textToBePresentInElementLocated(MobileBy.xpath(locator), text));
	}
	
	public void waitForElementVisibleByID(AndroidDriver<MobileElement> driver, String locator) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(locator)));
		
	}
	
	public void waitForElementClickableByID(AndroidDriver<MobileElement> driver, String locator) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(MobileBy.id(locator)));
	}
	
	public void waitForElementInvisibleByID(AndroidDriver<MobileElement> driver, String locator) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.id(locator)));
	}
	
	public void waitForTextToBePresentInElementLocatedByID(AndroidDriver<MobileElement> driver, String locator,
			String text) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.textToBePresentInElementLocated(MobileBy.id(locator), text));
	}

	public void waitForElementVisibleByAccessibilityId(AndroidDriver<MobileElement> driver, String locator) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(locator)));

	}

	public void waitForElementClickableByAccessibilityId(AndroidDriver<MobileElement> driver, String locator) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId(locator)));
	}

	public void waitForElementInvisibleByAccessibilityId(AndroidDriver<MobileElement> driver, String locator) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.AccessibilityId(locator)));
	}

	public void waitForTextToBePresentInElementLocatedByAccessibilityId(AndroidDriver<MobileElement> driver, String locator,
			String text) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.textToBePresentInElementLocated(MobileBy.AccessibilityId(locator), text));
	}

	public String getAlertTitle(AndroidDriver<MobileElement> driver, String locator) {
		MobileElement element = getElementByID(driver, ConfirmPopupUI.ALERT_TITLE_BY_ID);
		return getElementText(element);
	}

	public String getAlertMessage(AndroidDriver<MobileElement> driver, String locator) {
		MobileElement element = getElementByID(driver, ConfirmPopupUI.ALERT_MESSAGE_BY_ID);
		return getElementText(element);
	}

	public void acceptPopup(AndroidDriver<MobileElement> driver) {
		clickToElementByID(driver, ConfirmPopupUI.CONFRIM_BUTTON_BY_ID);
	}

	public boolean isSuccessMessageDisplayed(AndroidDriver<MobileElement> driver, String message) {
		MobileElement popup = getElementByID(driver, ConfirmPopupUI.ALERT_MESSAGE_BY_ID);
		if (popup.isDisplayed()) {
			if (popup.getText().equals(message)) {
				return true;
			}
		}
		return false;
	}

	public void clickToHomeMenu(AndroidDriver<MobileElement> driver) {
		clickToElementByXpath(driver, NavigationMenuPageUI.HOME_MENU_BY_XPATH);
	}

	public void clickToWebViewMenu(AndroidDriver<MobileElement> driver) {
		clickToElementByXpath(driver, NavigationMenuPageUI.WEB_VIEW_BY_XPATH);
	}

	public LoginPageObject clickToLoginMenu(AndroidDriver<MobileElement> driver) {
		clickToElementByXpath(driver, NavigationMenuPageUI.LOGIN_BY_PATH);
		return PageGenerator.getLoginPage(driver);
	}

	public void clickToFormMenu(AndroidDriver<MobileElement> driver) {
		clickToElementByXpath(driver, NavigationMenuPageUI.FORM_BY_XPATH);
	}

	public SwipeAction clickToSwipeMenu(AndroidDriver<MobileElement> driver) {
		clickToElementByXpath(driver, NavigationMenuPageUI.SWIPE_BY_XPATH);
		return new SwipeAction(driver);
	}

	private int shortTimeout = 5;
	private WebDriverWait explicitWait;
}
