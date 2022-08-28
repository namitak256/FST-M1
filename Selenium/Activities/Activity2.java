package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/");
		System.out.println("Page title is: "+driver.getTitle());
		WebElement btn= driver.findElement(By.id("about-link"));
		driver.findElement(By.className("green"));
		driver.findElement(By.linkText("About Us"));
		driver.findElement(By.cssSelector(".ui.inverted.huge.green.button"));
		driver.findElement(By.cssSelector(".green"));
		
		System.out.println(btn.getText());
		driver.quit();

	}

}
