#Author: Namita Shukla
#Email: namitak256@gmail.com

@Login
Feature: SuiteCRM application Login

@activity1
Scenario: Verify the website title
    Given User launches the browser
    When User navigates to CRM application
    Then Page title should be
    And User closes the browser

@activity2
Scenario: Get the url of the header image
   	Given User launches the browser
    When User navigates to CRM application
    Then User gets the URL of header image
    And User closes the browser
    
@activity3
Scenario: Get the copyright text
 		Given User launches the browser
    When User navigates to CRM application 
    Then User fetches the first copyright text in the footer
    And User closes the browser
    
@activity4
Scenario: Logging into the site
 		Given User launches the browser
 		And User navigates to CRM application
    When User enters login credentials
    And User clicks on Login button 
    Then User verifies homepage opens
    And User closes the browser
