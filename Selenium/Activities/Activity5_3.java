package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-controls");
		System.out.println(driver.getTitle());
		
		WebElement inputbox= driver.findElement(By.xpath("//input[@id='input-text']"));
		System.out.println(inputbox.isEnabled());
		
		WebElement enableInput= driver.findElement(By.xpath("//button[@id='toggleInput']"));
		
		enableInput.click();
		
		System.out.println(inputbox.isEnabled());
		
		driver.quit();
		

	}

}
