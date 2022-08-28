package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.util.Timeout;

public class Activity7_1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-attributes");
		System.out.println(driver.getTitle());
		
		WebElement username= driver.findElement(By.xpath("//input[@placeholder='Username']"));
		
		username.sendKeys("admin");
		
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		
		password.sendKeys("password");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement msg= driver.findElement(By.xpath("//div[@id='action-confirmation']"));
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		w.until(ExpectedConditions.visibilityOf(msg));
		
		System.out.println(msg.getText());
		
		driver.quit();
		

	}

}
