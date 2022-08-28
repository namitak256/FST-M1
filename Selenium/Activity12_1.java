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

public class Activity12_1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/iframes");
		System.out.println(driver.getTitle());
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.switchTo().frame(0);
		System.out.println(driver.findElement(By.xpath("//div[@class='content']")).getText());
		WebElement clickMe= driver.findElement(By.xpath("//button[@id='actionButton']"));
		System.out.println(clickMe.getText());
		System.out.println(clickMe.getCssValue("color"));
		clickMe.click();
		w.until(ExpectedConditions.textToBe(By.xpath("//button[@id='actionButton']"), "Button Pressed"));
		System.out.println(driver.findElement(By.xpath("//button[@id='actionButton']")).getText());
		System.out.println(driver.findElement(By.xpath("//button[@id='actionButton']")).getCssValue("background-color"));
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame(1);
		
		System.out.println(driver.findElement(By.xpath("//div[@class='content']")).getText());
		WebElement clickMe2= driver.findElement(By.xpath("//button[@id='actionButton']"));
		System.out.println(clickMe2.getText());
		System.out.println(clickMe2.getCssValue("color"));
		clickMe2.click();
		//Thread.sleep(1000);
		w.until(ExpectedConditions.textToBe(By.xpath("//button[@id='actionButton']"), "Button Pressed"));
		System.out.println(driver.findElement(By.xpath("//button[@id='actionButton']")).getText());
		System.out.println(driver.findElement(By.xpath("//button[@id='actionButton']")).getCssValue("background-color"));
		
		Thread.sleep(3000);
		driver.quit();
		

	}

}
