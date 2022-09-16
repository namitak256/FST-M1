package activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {
AndroidDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.contacts");
        options.setAppActivity(".activities.PeopleActivity");
        options.noReset();

		// Server Address
		URL serverURL = new URL("http://localhost:4723/wd/hub");
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		
	}
	
	@Test
	public void addContact() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Create new contact")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@text='First name']")));
		
		//Syntax of text is different
		driver.navigate().back();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys("abc");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("def");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("8899724899");
		Thread.sleep(5000);
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Email']")).sendKeys("abc@gmail.com");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='SAVE']")).click();
		
		w.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("title_gradient")));
		
		Assert.assertEquals(driver.findElement(AppiumBy.id("large_title")).getText(), "abc def");
		
		Thread.sleep(3000);
		
		
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
