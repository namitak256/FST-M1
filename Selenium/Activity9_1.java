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

public class Activity9_1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/selects");
		
		WebElement selectdropdown= driver.findElement(By.xpath("//select[@id='single-select']"));
		
		Select s = new Select(selectdropdown);
		
		s.selectByVisibleText("Option 2");
		s.selectByIndex(4);
		s.selectByValue("4");
		
		List<WebElement> liOptions = s.getOptions();
		
		for(WebElement i : liOptions)
			System.out.println(i.getText());
				
		driver.quit();
		

	}

}
