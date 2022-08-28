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

public class Activity11_1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		System.out.println(driver.getTitle());
		
		WebElement simpleBtn = driver.findElement(By.xpath("//button[@id='simple']"));
		WebElement confirmBtn = driver.findElement(By.xpath("//button[@id='confirm']"));
		WebElement promptBtn = driver.findElement(By.xpath("//button[@id='prompt']"));
		
		simpleBtn.click();
		
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(3000);
		driver.quit();
		

	}

}
