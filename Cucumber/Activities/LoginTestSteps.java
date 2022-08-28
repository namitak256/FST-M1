package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestSteps {
	WebDriver driver;

	@Given("User is on Login page")
	public void user_is_on_login_page() {
	    driver= new ChromeDriver();
	    driver.get("https://www.training-support.net/selenium/login-form");
	}
	@When("User enters username and password")
	public void user_enters_username_and_password() {
	    WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
	    WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
	    WebElement login = driver.findElement(By.xpath("//button[@class='ui button']"));
	    
	    username.sendKeys("admin");
	    password.sendKeys("password");
	    login.click();
	    
	}
	
	@When("User enters {string} and {string}")
	public void user_enters_and(String user, String pass) {
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
	    WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
	    WebElement login = driver.findElement(By.xpath("//button[@class='ui button']"));
	    
	    username.sendKeys(user);
	    password.sendKeys(pass);
	    login.click();
	}
	
	@Then("Read the page title and confirmation message")
	public void read_the_page_title_and_confirmation_message() {
		String title = driver.getTitle();
		System.out.println("Page title : "+title);
		String loginMsg = driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText();
		System.out.println("Login message : "+loginMsg);
	    
	}
	
	@Then("Close the Browser")
	public void close_the_browser() {
	    driver.close();
	}



}
