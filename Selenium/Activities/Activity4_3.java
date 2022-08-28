package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//h3[@id='third-header']"));
		System.out.println(driver.findElement(By.xpath("//h5[@class='ui green header']")).getCssValue("color"));
		
		System.out.println(driver.findElement(By.xpath("//button[@class='ui violet button']")).getAttribute("class"));
		
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]"));
		
		driver.quit();
		

	}

}
