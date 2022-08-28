package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {

	public static WebDriver driver;
	@Given("User is on Google Home Page")
	public void user_is_on_google_home_page() {
	    driver = new FirefoxDriver();
	    driver.get("https://www.google.com/");
	}

	@When("User types in Cheese and hits ENTER")
	public void user_types_in_cheese_and_hits_enter() {
		
		WebElement searchBtn= driver.findElement(By.xpath("//input[@title='Search']"));
	    searchBtn.sendKeys("Cheese");
	    searchBtn.sendKeys(Keys.ENTER);
	}

	@Then("Show how many search results were shown")
	public void show_how_many_search_results_were_shown() throws InterruptedException {
	    Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@id='result-stats']")).getText());
	}

	@Then("Close the browser")
	public void close_the_browser() {
	   driver.quit();
	}
}
