package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertSteps {
	
	WebDriver driver;
	WebDriverWait w;

	@Given("User is on the page")
	public void user_is_on_the_page() {
		driver= new ChromeDriver();
		w = new WebDriverWait(driver, Duration.ofSeconds(20));
	    driver.get("https://www.training-support.net/selenium/javascript-alerts");
	}
	@When("User clicks the Simple Alert button")
	public void user_clicks_the_simple_alert_button() {
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@id='simple']")));
	    driver.findElement(By.xpath("//button[@id='simple']")).click();
	}
	
	@When("User clicks the Confirm Alert button")
	public void user_clicks_the_confirm_alert_button() {
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@id='simple']")));
	    driver.findElement(By.xpath("//button[@id='confirm']")).click();
	}
	
	@When("User clicks the Prompt Alert button")
	public void user_clicks_the_prompt_alert_button() {
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@id='simple']")));
	    driver.findElement(By.xpath("//button[@id='prompt']")).click();
	}
	
	@Then("Alert opens")
	public void alert_opens() {
	    w.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert();
	}
	
	@Then("Read the text from it and print it")
	public void read_the_text_from_it_and_print_it() {
	    System.out.println(driver.switchTo().alert().getText());
	}
	
	@Then("Close the alert")
	public void close_the_alert() {
	    driver.switchTo().alert().accept();
	}
	
	@Then("Close the alert with Cancel")
	public void close_the_alert_with_cancel() {
	    driver.switchTo().alert().dismiss();
	}
	
	@Then("Write a custom message in it")
	public void write_a_custom_message_in_it() {
	    driver.switchTo().alert().sendKeys("Hello");
	}
	@Then("Close Browser")
	public void close_browser() {
	    driver.close();
	}



}
