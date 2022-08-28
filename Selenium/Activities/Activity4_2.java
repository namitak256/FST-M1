package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/simple-form");
		System.out.println(driver.getTitle());
		
		WebElement FName= driver.findElement(By.xpath("//input[@id='firstName']"));
		
		WebElement LName= driver.findElement(By.xpath("//input[@id='lastName']"));
		
		WebElement Email= driver.findElement(By.xpath("//input[@id='email']"));
		WebElement Contact= driver.findElement(By.xpath("//input[@id='number']"));
		
		FName.sendKeys("Namita");
		LName.sendKeys("Shukla");
		Email.sendKeys("abc@abc.com");
		Contact.sendKeys("5495898322");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.quit();
		

	}

}
