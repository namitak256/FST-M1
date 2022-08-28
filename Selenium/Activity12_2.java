package activities;

import static org.testng.Assert.assertTrue;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.util.Timeout;
import javafx.scene.input.Clipboard;

public class Activity12_2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/nested-iframes");
		System.out.println("Page title: "+driver.getTitle());
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.switchTo().frame(0);
		//System.out.println(""+driver.findElement(By.tagName("title")).getText());
		
		driver.switchTo().frame(0);
		WebElement frameHeading1 = driver.findElement(By.cssSelector("div.content"));
	    System.out.println(frameHeading1.getText());
	    
	    driver.switchTo().parentFrame();
	    driver.switchTo().frame(1);
	    WebElement frameHeading2 = driver.findElement(By.cssSelector("div.content"));
	    System.out.println(frameHeading2.getText());
		
		Thread.sleep(3000);
		driver.quit();
		

	}

}
