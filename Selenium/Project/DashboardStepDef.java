package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testMethods.BaseMethods;
import testMethods.DashboardMethods;
import testMethods.LoginMethods;

public class DashboardStepDef extends BaseMethods{
	
	LoginMethods loginM = new LoginMethods();
	DashboardMethods dashM = new DashboardMethods();

	@Then("User verifies homepage opens")
	public void user_verifies_homepage_opens() throws InterruptedException {
	    dashM.verifyHomePage();
	}

	@Then("User fetches the color of navigation menu")
	public void user_fetches_the_color_of_navigation_menu() {
	    dashM.fetchNavMenuColor();
	}
	
	@When("User navigates to CRM application and logs in")
	public void user_navigates_to_crm_application_and_logs_in() {
		loginM.launchApplication();
	    loginM.enterLoginCreds();
	    loginM.clickLoginBtn();
	    dashM.verifyHomePage();
	}
	
	@Then("User ensures that Activities menu exists")
	public void user_ensures_that_activities_menu_exists() {
	    dashM.verifyTabExists();
	    
	}
	
	@When("User navigates to Sales->Leads")
	public void user_navigates_to_sales_leads() {
	    dashM.navSalesLeads();
	}
	
	@When("User clicks on Additional information icon at the end of the row of the lead information")
	public void user_clicks_on_additional_information_icon_at_the_end_of_the_row_of_the_lead_information() throws InterruptedException {
	    dashM.clickAddtnlInfoIcon();
	}
	
	@Then("User fetches the popup information")
	public void user_fetches_the_popup_information() {
	    dashM.getPopUpInfo();
	}
	
	@When("User navigates to Sales->Accounts")
	public void user_navigates_to_sales_accounts() {
	    dashM.navSalesAccounts();
	}
	
	@Then("User fetches the names of the first five odd-numbered rows of the table")
	public void user_fetches_the_names_of_the_first_five_odd_numbered_rows_of_the_table() {
		dashM.fetchNameFromTable();
	}

	@Then("User fetches the  first ten values in the Name column and the User column of the table")
	public void user_fetches_the_first_ten_values_in_the_name_column_and_the_user_column_of_the_table() {
		dashM.fetchNameUserFromTable();
	}

	
}
