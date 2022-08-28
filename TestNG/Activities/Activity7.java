package activityTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
	
	WebDriver driver;

	@BeforeTest
	public void start() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
	}
	
	@AfterTest
	public void end() {
		driver.quit();
	}
	
	@DataProvider(name= "Authentication")
	public static Object[][] credentials(){
		return new Object[][] {
			{"admin","password"}
		};
	}
	
	@Test(dataProvider = "Authentication")
	public void method(String username, String password) {
		WebElement user = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		
		user.sendKeys(username);
		pass.sendKeys(password);
		login.click();
	}
}
