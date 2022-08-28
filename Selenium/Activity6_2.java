package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.util.Timeout;

public class Activity6_2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/ajax");
		System.out.println(driver.getTitle());
		
		WebElement btnchangecontent= driver.findElement(By.xpath("//button[@class='ui violet button']"));
		
		btnchangecontent.click();
		
		WebElement txt = driver.findElement(By.xpath("//div[@id='ajax-content']/h1"));
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		w.until(ExpectedConditions.textToBePresentInElement(txt, "HELLO!"));
		System.out.println(txt.getText());
		
		w.until(ExpectedConditions.textToBe(By.xpath("//div[@id='ajax-content']/h3"), "I'm late!"));
		
		System.out.println(driver.findElement(By.xpath("//div[@id='ajax-content']/h3")).getText());
		driver.quit();
		

	}

}
