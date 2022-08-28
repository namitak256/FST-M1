package activities;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.util.Timeout;

public class Activity10_1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/input-events");
		System.out.println(driver.getTitle());
		
		Actions a = new Actions(driver);
		
		WebElement cube = driver.findElement(By.id("wrapD3Cube"));
		
		a.click(cube).perform();
		
		System.out.println("Side shown after left click: "+driver.findElement(By.className("active")).getText());
		
		a.doubleClick(cube).perform();
		
		System.out.println("Side shown after double click: "+driver.findElement(By.className("active")).getText());
		
		a.contextClick(cube).perform();
		
		System.out.println("Side shown after right click: "+driver.findElement(By.className("active")).getText());
				
		Thread.sleep(3000);
		driver.quit();
		

	}

}
