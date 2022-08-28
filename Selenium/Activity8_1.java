package activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.util.Timeout;

public class Activity8_1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/tables");
		
		List<WebElement> liRow= driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr"));
		System.out.println("Number of rows: "+liRow.size());
		
		List<WebElement> liCols= driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[1]/td"));
		System.out.println(liCols.size());
		
		List<WebElement> thirdcol= driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr/td[3]"));
		
		for(WebElement w:thirdcol) {
			System.out.println(w.getText());
		}
		
		System.out.println(driver.findElement(By.xpath("//table[@class='ui celled striped table']/tbody/tr[2]/td[2]")).getText());
		driver.quit();
		

	}

}
