package activityTestNG;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity5 {
	
	WebDriver driver;

	@BeforeTest(alwaysRun = true)
	public void one() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
	}
	
	@AfterTest(alwaysRun = true)
	public void two() {
		//driver.close();
		driver.quit();
	}
	
	@Test(groups = {"HeaderTests", "ButtonTests"})
	public void three() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("Target Practice"));
	}
	
	@Test(groups = "HeaderTests")
	public void four() {
		WebElement thirdheader = driver.findElement(By.tagName("h3"));
		WebElement fifthheader = driver.findElement(By.tagName("h5"));
		
		Assert.assertTrue(thirdheader.getText().equals("Third header"));
		System.out.println(fifthheader.getCssValue("color"));
		Assert.assertTrue(fifthheader.getCssValue("color").equals("rgb(33, 186, 69)"));
	}
	@Test(groups = "ButtonTests")
	public void five() {
		WebElement olivebutton = driver.findElement(By.xpath("//button[contains(@class, 'olive')]"));
		System.out.println("Text: "+olivebutton.getText());
		Assert.assertTrue(olivebutton.getText().equals("Olive"));
		
		WebElement brownBtn = driver.findElement(By.xpath("//div[@class='row']/div[2]/div[3]/button[1]"));
		String color = brownBtn.getCssValue("background-color");
		System.out.println(color);
		Assert.assertTrue(color.equals("rgb(165, 103, 63)"));
	}
	
}
