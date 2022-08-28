package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/");
		System.out.println(driver.getTitle());
		WebElement btn_AboutUs = driver.findElement(By.xpath("//a[@id='about-link']"));
		btn_AboutUs.click();
		System.out.println(driver.getTitle());
		driver.quit();
		

	}

}
