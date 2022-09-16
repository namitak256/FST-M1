package activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import javax.lang.model.element.Element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {

	AndroidDriver driver;
	
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
		driver.get("https://www.training-support.net/");
	}
	
	@Test
	public void browserTest() throws InterruptedException {
		
		WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(100));
		
		w.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@text='Training Support']")));
		WebElement headerTrainingSupport=driver.findElement(AppiumBy.xpath("//android.view.View[@text='Training Support']"));
		System.out.println(headerTrainingSupport.getText());
		
		driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='about-link']")).click();
		//Why id doesn't work for about-link button
		w.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@text='About Us']")));
		
		System.out.println(driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']")).getText());
		
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
