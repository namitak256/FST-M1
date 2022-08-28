package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-controls");
		System.out.println(driver.getTitle());
		
		WebElement chkbox= driver.findElement(By.xpath("//input[@class='willDisappear']"));
		
		System.out.println(chkbox.isDisplayed());
		
		WebElement rmChkbox = driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));
		rmChkbox.click();
		
		System.out.println(chkbox.isDisplayed());
		Thread.sleep(3000);
		driver.quit();
		

	}

}
