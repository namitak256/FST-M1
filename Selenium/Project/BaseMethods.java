package testMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;

public class BaseMethods {

	public static WebDriver driver;
	public static WebDriverWait w;
	
	public void openBrowser() {
		driver= new ChromeDriver();
	}
	
	public void launchApplication() {
		driver.get("https://alchemy.hguy.co/crm/");
		driver.manage().window().maximize();
		
		w = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public boolean isElementVisible(String locator) {
		//WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(locator))));
		
		if(driver.findElement(By.xpath(locator)).isDisplayed() == true) 
			return true;
		
		else
			return false;
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	
}
