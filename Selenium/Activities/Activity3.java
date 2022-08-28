package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/simple-form");
		System.out.println(driver.getTitle());
		WebElement FName= driver.findElement(By.xpath("//input[@id='firstName']"));
		
		WebElement LName= driver.findElement(By.xpath("//input[@id='lastName']"));
		
		FName.sendKeys("Namita");
		LName.sendKeys("Shukla");
		
		WebElement Email= driver.findElement(By.xpath("//input[@id='email']"));
		WebElement Contact= driver.findElement(By.xpath("//input[@id='number']"));
		
		Email.sendKeys("abc@abc.com");
		Contact.sendKeys("5495898322");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		driver.quit();
		
	}

}
