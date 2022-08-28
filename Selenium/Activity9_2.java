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

public class Activity9_2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/selects");
		
		WebElement multiselectdropdown= driver.findElement(By.xpath("//select[@id='multi-select']"));
		
		Select s = new Select(multiselectdropdown);
		
		if(s.isMultiple()) {
			s.selectByVisibleText("Javascript");
			
			s.selectByValue("node");
			
			for(int i=4; i<=6; i++) {
				s.selectByIndex(i);
			}
			
			s.deselectByValue("node");
			
			s.deselectByIndex(7);
			
			
			
			String chosen= driver.findElement(By.xpath("//h3[@id='multi-value']")).getText();
			
			System.out.println(chosen);
			
			System.out.println(chosen.substring(19));
			
			String[] strarr= chosen.substring(19).split(",");
			
			System.out.println("First option selected: "+ strarr[0]);
			
			for(String i: strarr) {
				System.out.println("Options selected: "+i.trim());
				s.deselectByVisibleText("Ember");
				s.deselectByVisibleText("HTML");
				s.deselectByVisibleText("Information Architecture");
			}
			
			
		}
		
		Thread.sleep(3000);
				
		driver.quit();
		

	}

}
