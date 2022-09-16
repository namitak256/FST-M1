package activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 {

AndroidDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();

		// Server Address
		URL serverURL = new URL("http://localhost:4723/wd/hub");
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		
	}
	
	@Test
	public void add() {
		
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.id("op_add")).click();
		driver.findElement(AppiumBy.id("digit_9")).click();
		driver.findElement(AppiumBy.id("eq")).click();
		String result= driver.findElement(AppiumBy.id("result")).getText();
		System.out.println("Add 5+9 = "+result);
		Assert.assertEquals(result, "14");
		
	}
	
	@Test
	public void substract() {
		
		driver.findElement(AppiumBy.id("digit_1")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.id("op_sub")).click();
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.id("eq")).click();
		String result= driver.findElement(AppiumBy.id("result")).getText();
		System.out.println("Add 10-5 = "+result);
		Assert.assertEquals(result, "5");
		
	}
	
	@Test
	public void multiply() {
		
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.id("op_mul")).click();
		driver.findElement(AppiumBy.id("digit_1")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.id("eq")).click();
		String result= driver.findElement(AppiumBy.id("result")).getText();
		System.out.println("Add 5*100 = "+result);
		Assert.assertEquals(result, "500");
		
	}
	
	@Test
	public void divide() {
		
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.id("op_div")).click();
		driver.findElement(AppiumBy.id("digit_2")).click();
		driver.findElement(AppiumBy.id("eq")).click();
		String result= driver.findElement(AppiumBy.id("result")).getText();
		System.out.println("Add 50/2 = "+result);
		Assert.assertEquals(result, "25");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
