package activities;

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

public class Activity10_2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/input-events");
		System.out.println(driver.getTitle());
		String pressedKeyText;
		
		WebElement pressedKey = driver.findElement(By.id("keyPressed"));
		
		Actions a = new Actions(driver);
		
		WebElement cube = driver.findElement(By.id("wrapD3Cube"));
		
		a.sendKeys("N").perform();
		
		pressedKeyText = pressedKey.getText();
        System.out.println("Pressed key is: " + pressedKeyText);
		
		a.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		a.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		
		pressedKeyText = pressedKey.getText();
        System.out.println("Pressed key is: " + pressedKeyText);
				
		Thread.sleep(3000);
		driver.quit();
		

	}

}
