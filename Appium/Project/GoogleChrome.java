package project;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class GoogleChrome {
	
	AndroidDriver driver;
	
	@Test
	public void Activity1() throws MalformedURLException, InterruptedException {

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
		
		driver.get("https://www.training-support.net/selenium");
		
		//Thread.sleep(50000);

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(100));
		
		w.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Button[contains(@text,'Get Started!')]")));
		
		String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
		
		driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
		
		w.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@text,'To-Do List')]")));
		//w.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("")))
		driver.findElement(AppiumBy.xpath("//android.view.View[contains(@text,'To-Do List')]")).click();
		
		List<String> li = new ArrayList<String>();
		li.add("Add tasks to list");
		li.add("Get number of tasks");
		li.add("Clear the list");

		System.out.println(li.size());

		for (int i = 0; i < li.size(); i++) {
			w.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));
			driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys(li.get(i));
			driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
			w.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@text='"+li.get(i)+"']")));
			w.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@text='"+li.get(i)+"']")));
			driver.findElement(AppiumBy.xpath("//android.view.View[@text='"+li.get(i)+"']")).click();
		}
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.view.View[@text=' Clear List']")).click();
		
		Thread.sleep(2000);
		
		for(int i=0;i<li.size();i++) {
			List li2= driver.findElements(AppiumBy.xpath("//android.view.View[@text='"+li.get(i)+"']"));
			Assert.assertEquals(li2.size(),0);
			
		}
		
	}

}
