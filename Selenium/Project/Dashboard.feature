#Author: Namita Shukla
#Email: namitak256@gmail.com

@DashBoard
Feature: SuiteCRM application Dashboard

@activity5
Scenario: Getting colors
 		Given User launches the browser
 		And User navigates to CRM application
    When User enters login credentials
    And User clicks on Login button
    And User verifies homepage opens
    Then User fetches the color of navigation menu
    And User closes the browser
    
@activity6
Scenario: Menu checking
 		Given User launches the browser
 		When User navigates to CRM application and logs in
    Then User ensures that Activities menu exists
    And User closes the browser
    
@activity7
Scenario: Reading additional information
 		Given User launches the browser
 		And User navigates to CRM application and logs in
    When User navigates to Sales->Leads
    And User clicks on Additional information icon at the end of the row of the lead information
    Then User fetches the popup information
    And User closes the browser
    
@activity8
Scenario: Traversing tables
 		Given User launches the browser
 		And User navigates to CRM application and logs in
    When User navigates to Sales->Accounts
    Then User fetches the names of the first five odd-numbered rows of the table
    And User closes the browser
    
@activity9
Scenario: Traversing tables two
 		Given User launches the browser
 		And User navigates to CRM application and logs in
    When User navigates to Sales->Leads
    Then User fetches the  first ten values in the Name column and the User column of the table
    And User closes the browser