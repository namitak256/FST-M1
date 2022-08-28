package activityTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Activity6 {
	
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
	
	@Test
	@Parameters({"username", "password"})
	public void login(String username, String password) {
		WebElement user = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		
		user.sendKeys(username);
		pass.sendKeys(password);
		login.click();
	}
}
