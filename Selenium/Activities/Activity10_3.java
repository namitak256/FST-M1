package activities;

import static org.testng.Assert.assertTrue;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.util.Timeout;
import javafx.scene.input.Clipboard;

public class Activity10_3 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/drag-drop");
		System.out.println(driver.getTitle());
		
		WebElement ball= driver.findElement(By.xpath("//img[@id='draggable']"));
		WebElement drop1= driver.findElement(By.xpath("//div[text()='Dropzone 1']"));
		WebElement drop2= driver.findElement(By.xpath("//div[text()='Dropzone 2']"));
		
		Actions a= new Actions(driver);
		
		System.out.println(drop1.getCssValue("color"));
		
		a.click(ball).dragAndDrop(ball, drop1).perform();
		
		
		System.out.println(drop1.getCssValue("background-color"));
		
		assertTrue(drop1.getCssValue("background-color").equals("rgb(33, 186, 69)"), "Ball hasn't entered the drop zone 1");
		
		a.click(ball).dragAndDrop(ball, drop2).perform();
		
		assertTrue(drop2.getCssValue("background-color").equals("rgb(33, 186, 69)"), "Ball hasn't entered the drop zone 2");
		
		Thread.sleep(3000);
		driver.quit();
		

	}

}
