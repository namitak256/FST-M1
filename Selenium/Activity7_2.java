package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.util.Timeout;

public class Activity7_2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-attributes");
		System.out.println(driver.getTitle());
		
		WebElement username= driver.findElement(By.xpath("//input[contains(@class,'-username')]"));
		
		username.sendKeys("admin1");
		
		WebElement password = driver.findElement(By.xpath("//input[contains(@class,'-password')]"));
		
		password.sendKeys("password1");
		
		driver.findElement(By.xpath("//label[text()='Confirm Password']/following-sibling::input")).sendKeys("password1");
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("abc@xyz.com");
		
		driver.findElement(By.xpath("//button[@onclick='signUp()']")).click();
		
		
		WebElement msg= driver.findElement(By.xpath("//div[@id='action-confirmation']"));
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		w.until(ExpectedConditions.visibilityOf(msg));
		
		System.out.println(msg.getText());
		
		driver.quit();
		

	}

}
