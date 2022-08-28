package activityTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity10 {

WebDriver driver;
Actions builder;

	
	@BeforeTest
	public void start() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/sliders");
		Reporter.log("Launched the URL");
		builder = new Actions(driver);
	}
	
	@AfterTest
	public void end() {
		driver.quit();
		Reporter.log("Browser closed successfully");
	}
	
	@Test(priority = 1)
	public void atestMiddleVal() {
		WebElement slider = driver.findElement(By.xpath("//input[@id='slider']"));
		slider.click();
		System.out.println("Val middle: "+driver.findElement(By.xpath("//span[@id='value']")).getText());
		
	}
	
	@Test(priority = 2)
	public void btestMaxVal() {
		WebElement slider = driver.findElement(By.xpath("//input[@id='slider']"));
		builder.clickAndHold(slider).moveByOffset(100, 0).release().build().perform();
		System.out.println("Val max: "+driver.findElement(By.xpath("//span[@id='value']")).getText());
	}
	
	@Test(priority = 3)
	public void ctestMinVal() {
		WebElement slider = driver.findElement(By.xpath("//input[@id='slider']"));
		builder.clickAndHold(slider).moveByOffset(-100, 0).release().build().perform();
		System.out.println("Val min: "+driver.findElement(By.xpath("//span[@id='value']")).getText());
	}
	
	@Test(priority = 4)
	public void dtest30Val() {
		WebElement slider = driver.findElement(By.xpath("//input[@id='slider']"));
		builder.clickAndHold(slider).moveByOffset(-30, 0).release().build().perform();
		System.out.println("Val 30: "+driver.findElement(By.xpath("//span[@id='value']")).getText());
	}
	
	@Test(priority = 5)
	public void etest80Val() {
		WebElement slider = driver.findElement(By.xpath("//input[@id='slider']"));
		builder.clickAndHold(slider).moveByOffset(44, 0).release().build().perform();
		System.out.println("Val 80: "+driver.findElement(By.xpath("//span[@id='value']")).getText());
	}
}
