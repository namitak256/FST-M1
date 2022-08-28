package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testMethods.BaseMethods;
import testMethods.DashboardMethods;
import testMethods.LoginMethods;

public class LoginStepDef extends BaseMethods{
	
	LoginMethods loginM = new LoginMethods();
	DashboardMethods dashM = new DashboardMethods();

	@Given("User launches the browser")
	public void user_launches_the_browser() {
		openBrowser();
	}

	@When("User navigates to CRM application")
	public void user_navigates_to_crm_application() {
		launchApplication();
	}

	@Then("Page title should be")
	public void page_title_should_be() {
		loginM.verifyLoginPage();
	}

	@Then("User gets the URL of header image")
	public void user_gets_the_url_of_header_image() throws InterruptedException {
		loginM.getHeaderURL();
	}
	
	@Then("User fetches the first copyright text in the footer")
	public void user_fetches_the_first_copyright_text_in_the_footer() throws InterruptedException {
		loginM.fetchFirstCopyrightText();
	}
	
	@When("User enters login credentials")
	public void user_enters_login_credentials() {
	    loginM.enterLoginCreds();
	}
	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
	    loginM.clickLoginBtn();
	}
	
	
	@Then("User closes the browser")
	public void user_closes_the_browser() {
		driver.close();
	}
}
