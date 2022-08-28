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

public class Activity12_3 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/popups");
		System.out.println("Page title: "+driver.getTitle());
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@onclick='openModal()']")));
		
		WebElement signin = driver.findElement(By.xpath("//button[@onclick='openModal()']"));
		
		Actions a = new Actions(driver);
		a.moveToElement(signin).perform();
		System.out.println("Text of the signin tooltip: "+signin.getAttribute("data-tooltip"));
		signin.click();
		
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='username']")));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
		driver.findElement(By.xpath("//button[@onclick='signIn()']")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText());
		
		Thread.sleep(3000);
		driver.quit();
		

	}

}
