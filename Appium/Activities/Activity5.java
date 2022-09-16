package activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Keys;
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

public class Activity5 {
	
	AppiumDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity(".ui.ConversationListActivity");
        options.noReset();

		// Server Address
		URL serverURL = new URL("http://localhost:4723/wd/hub");
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		
	}
	
	@Test
	public void addContact() throws InterruptedException {
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions action=new Actions(driver);
		
		driver.findElement(AppiumBy.accessibilityId("Start new conversation")).click();
		
		w.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("recipient_text_view")));
		driver.findElement(AppiumBy.id("recipient_text_view")).click();
		action.sendKeys("9168268956").sendKeys(Keys.ENTER).build().perform();
		
		//w.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("contact_picker_create_group")));
		//driver.findElement(AppiumBy.id("contact_picker_create_group")).click();
		
		w.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("compose_message_text")));
		driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from Appium");
		
		
		driver.findElement(AppiumBy.id("send_message_button_icon")).click();
		
		w.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("message_text")));
		String text = driver.findElement(AppiumBy.id("message_text")).getText();
		System.out.println("Message: "+text);
		Assert.assertTrue(text.contains("Hello from Appium"));
		
		
		
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
