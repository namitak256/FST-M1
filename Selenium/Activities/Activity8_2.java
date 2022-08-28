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

public class Activity8_2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/tables");
		
		List<WebElement> liRow= driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
		System.out.println("Number of rows: "+liRow.size());
		
		List<WebElement> liCols= driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
		System.out.println("Number of columns: "+liCols.size());
		
		System.out.println("Cell at 2nd row 2nd col: "+driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]")).getText());
		
		driver.findElement(By.xpath("//table[@id='sortableTable']//th[text()='Name']")).click();
		
		System.out.println("Cell at 2nd row 2nd col: "+driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]")).getText());
		
		List<WebElement> liFooter = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot//th"));
		
		for (WebElement i: liFooter) {
			System.out.println("Footer cell value: "+i.getText());
		}
		
		
		driver.quit();
		

	}

}
