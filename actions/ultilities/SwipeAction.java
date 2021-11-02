package ultilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class SwipeAction {

	private AppiumDriver<MobileElement> appiumDriver;
	private TouchAction touchAction;
	private PointOption startPoint;
	private PointOption endPoint;

	public SwipeAction(AppiumDriver<MobileElement> driver) {
		this.appiumDriver = driver;
		this.touchAction = new TouchAction(this.appiumDriver);

		// Get the mobile screen sizes
		Dimension windowSize = this.appiumDriver.manage().window().getSize();
		int screenHeight = windowSize.getHeight();
		int screenWidth = windowSize.getWidth();

		// init start point and end point to launch and release
		int xStartPoint = 50 * screenWidth / 100;
		int xEndPoint = 10 * screenWidth / 100;
		int yStartPoint = 50 * screenHeight / 100;
		int yEndPoint = yStartPoint;

		// perform the touch action
		this.startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
		this.endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

	}

	public void swipeLeftToRight() {
		// Swipe from left to right direction
		touchAction.press(endPoint).waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1))).moveTo(startPoint)
				.release().perform();
	}

	public void swipeLeftToRight(int times) {
		for (int initTime = 0; initTime < times; initTime++) {
			this.swipeLeftToRight();
		}

	}

	public void swipeRightToLeft() {
		// Swipe from right to left direction
		touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1))).moveTo(endPoint)
				.release().perform();
	}

	public void swipeRightToLeft(int times) {
		for (int i = 0; i < times; i++) {
			this.swipeRightToLeft();
		}
	}

}
