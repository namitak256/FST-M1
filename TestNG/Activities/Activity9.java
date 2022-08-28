package activityTestNG;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

class Activity9 {
	
	WebDriver driver;
	
	@BeforeTest
	public void start() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		Reporter.log("Launched the URL");
	}
	
	@AfterTest
	public void end() {
		driver.quit();
		Reporter.log("Browser closed successfully");
	}
	
	@BeforeMethod
	public void s() {
		driver.switchTo().defaultContent();
		Reporter.log("Switched to default content");
	}
	
	@Test
	public void simpleAlertTestCase() {
		WebElement simple = driver.findElement(By.xpath("//button[@id='simple']"));
		simple.click();
		Reporter.log("Opened simple alert");
		String alerttext = driver.switchTo().alert().getText();
		Assert.assertTrue(alerttext.contains("This is a JavaScript Alert!"));
		Reporter.log("Asserted simple alert text");
		System.out.println(alerttext);
	}
	
	@Test
	public void confirmAlertTestCase() {
		WebElement simple = driver.findElement(By.xpath("//button[@id='confirm']"));
		simple.click();
		Reporter.log("Opened confirm alert");
		String alerttext = driver.switchTo().alert().getText();
		System.out.println(alerttext);
		Assert.assertTrue(alerttext.contains("This is a JavaScript Confirmation!"));
		Reporter.log("Asserted confirm alert text");
		driver.switchTo().alert().accept();
		Reporter.log("Dismissed confirm alert text");
		
	}
	
	@Test
	public void promptAlertTestCase() {
		WebElement simple = driver.findElement(By.xpath("//button[@id='prompt']"));
		simple.click();
		Reporter.log("Opened prompt alert");
		String alerttext = driver.switchTo().alert().getText();
		System.out.println(alerttext);
		Assert.assertTrue(alerttext.contains("This is a JavaScript Prompt!"));
		driver.switchTo().alert().sendKeys("test");
		Reporter.log("Asserted prompt alert text");
		driver.switchTo().alert().dismiss();
		Reporter.log("Dismissed prompt alert text");
	}
}
