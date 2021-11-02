package commons;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {

	protected final Log log;
	protected AndroidDriver<MobileElement> driver;

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	protected AndroidDriver<MobileElement> getAppiumDriver() {

		try {

			// setup desiredCapabilities to send to Appium Server
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			desiredCapabilities.setCapability("appPackage", "com.wdiodemoapp");
			desiredCapabilities.setCapability("appActivity", "com.wdiodemoapp.MainActivity");
			desiredCapabilities.setCapability(MobileCapabilityType.UDID, "192.168.66.106:5555");

			// setup server URL to connect
			URL appiumServer = new URL("http://localhost:4723/wd/hub");

			driver = new AndroidDriver<MobileElement>(appiumServer, desiredCapabilities);
			driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return driver;
	}

	protected void closeApp(AndroidDriver<MobileElement> driver) {
		if (driver != null) {
			driver.closeApp();
		}
	}
}
