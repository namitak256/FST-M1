package activityTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void first() {
        // Check the title of the page
        String title = driver.getTitle();
            
        //Print the title of the page
        System.out.println("Page title is: " + title);
            
        //Assertion for page title
        Assert.assertEquals("Target Practice", title);
                    
    }
    
    @Test
    public void second() {
        
    	WebElement blackBtn= driver.findElement(By.xpath("//button[@class='ui black button']"));
    	String s= blackBtn.getText();
    	Assert.assertEquals("Blac", s);
                    
    }
    
    @Test(enabled= false)
    public void third() {
        
    	WebElement blackBtn= driver.findElement(By.xpath("//button[@class='ui black button']"));
    	String s= blackBtn.getText();
    	Assert.assertEquals("Blac", s);
                    
    }
    
    @Test
    public void fourth() {
    	
    	throw new SkipException("Skipping this test");
    	
                    
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}