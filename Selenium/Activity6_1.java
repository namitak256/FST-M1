package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.util.Timeout;

public class Activity6_1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-controls");
		System.out.println(driver.getTitle());
		
		WebElement chkboxtoggle= driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));
		WebElement chkbox = driver.findElement(By.xpath("//input[@class='willDisappear']"));
		
		chkboxtoggle.click();
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		w.until(ExpectedConditions.invisibilityOf(chkbox));
		
		chkboxtoggle.click();
		
		w.until(ExpectedConditions.visibilityOf(chkbox));
		
		chkbox.click();
		
		
		driver.quit();
		

	}

}
