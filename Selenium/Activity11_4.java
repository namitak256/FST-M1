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

public class Activity11_4 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/tab-opener");
		System.out.println(driver.getTitle());
		
		String handle= driver.getWindowHandle();
		
		System.out.println(handle);
		
		String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window: " + parentWindow);
		
		WebElement newTabBtn= driver.findElement(By.xpath("//a[@id='launcher']"));
		
		newTabBtn.click();
		
		WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(30));
		
		w.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Set<String> handles = driver.getWindowHandles();
		
		System.out.println(handles);
		
		for(String i: handles) {
			driver.switchTo().window(i);
			
		}
		
		System.out.println(driver.getTitle());
		
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='content']")));
		
		WebElement nextTab = driver.findElement(By.xpath("//div[@class='content']"));
	
		String nextTabText = nextTab.getText();
		
        System.out.println("New tab heading is: " + nextTabText);
        
        WebElement openAnother = driver.findElement(By.xpath("//a[@id='actionButton']"));
        openAnother.click();
        
        w.until(ExpectedConditions.numberOfWindowsToBe(3));
		
		Set<String> handles2 = driver.getWindowHandles();
		
		System.out.println(handles2);
		
		for(String i: handles2) {
			driver.switchTo().window(i);
		}
		
		System.out.println(driver.getTitle());
		
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='content']")));
		String newTabText2 = driver.findElement(By.xpath("//div[@class='content']")).getText();
        System.out.println("New tab heading is: " + newTabText2);
        
		
		Thread.sleep(3000);
		driver.quit();
		

	}

}
