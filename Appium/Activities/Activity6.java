package activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 {

	AppiumDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

		// Server Address
		URL serverURL = new URL("http://localhost:4723/wd/hub");
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		
	}
	
	@Test
	public void addContact() throws InterruptedException {
		
		String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(100));
		
		driver.get("https://www.training-support.net/selenium/lazy-loading");
		
		w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(AppiumBy.className("android.widget.Image")));
		List<WebElement> li = driver.findElements(AppiumBy.className("android.widget.Image"));
		System.out.println("Number of images present: "+li.size());
		
		//driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"helen\")"));
		driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
		
		Thread.sleep(3000);
		List<WebElement> li2 = driver.findElements(AppiumBy.className("android.widget.Image"));
		System.out.println("Number of images present after scroll: "+li2.size());
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
