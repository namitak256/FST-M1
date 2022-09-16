package project;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.checkerframework.checker.units.qual.Length;
import org.openqa.selenium.WebElement;
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

public class GoogleTasksAndKeep {

	AppiumDriver driver;

	@Test
	public void Activity1() throws MalformedURLException {

		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.apps.tasks");
		options.setAppActivity(".ui.TaskListsActivity");
		options.noReset();

		// Server Address
		URL serverURL = new URL("http://localhost:4723/wd/hub");
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(60));

		List<String> li = new ArrayList<String>();
		li.add("Complete Activity with Google Tasks");
		li.add("Complete Activity with Google Keep");
		li.add("Complete the second Activity Google Keep");

		System.out.println(li.size());

		for (int i = 0; i < li.size(); i++) {
			w.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("tasks_fab")));
			driver.findElement(AppiumBy.id("tasks_fab")).click();
			w.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("add_task_title")));
			driver.findElement(AppiumBy.id("add_task_title")).sendKeys(li.get(i));
			w.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("add_task_done")));
			driver.findElement(AppiumBy.id("add_task_done")).click();

			Assert.assertTrue(driver.findElement(AppiumBy.xpath("//*[@text='" + li.get(i) + "']")).isDisplayed());
		}

	}

	@Test
	public void Activity2() throws MalformedURLException {

		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.keep");
		options.setAppActivity(".activities.BrowseActivity");
		options.noReset();

		// Server Address
		URL serverURL = new URL("http://localhost:4723/wd/hub");
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(60));

		w.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("new_note_button")));
		driver.findElement(AppiumBy.id("new_note_button")).click();
		
		w.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("editable_title")));
		driver.findElement(AppiumBy.id("editable_title")).sendKeys("FST Note");
		
		w.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("edit_note_text")));
		driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("FST Description");
		
		driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();

		
		w.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("index_note_title")));
		Assert.assertTrue(driver.findElement(AppiumBy.id("index_note_title")).getText().contains("FST Note"));
		Assert.assertTrue(driver.findElement(AppiumBy.id("index_note_text_description")).getText().contains("FST Description"));

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
