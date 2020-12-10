***Settings***
Documentation    Test Suite for Restaurant website
Resource    ../Resources/Common.robot
#Resource    C:/Users/nazim/workspace1/Restaurant/Resources/PageObjects/BasePage.robot
Resource    ../Resources/PageObjects/BasePage.robot
Resource    ../Resources/Keywords/RestaurantSearch.robot  


*** Test Cases ***
Scenario-1_TC01_Verify restaurant search based on postal code
    [Documentation]    Scenario to Check Restaruants in Postal Code AR51 1AA
    [Setup]    Open Application    
    Given I want food in    AR51 1AA    
    When Click Search button
    Then Verify Displayed restaurants in that postal code    AR51 1AA 
    [Teardown]    Close Application 

Scenario-2_TC02_Verify Number of restaurants in Postal Code AR51 1AA   
    [Documentation]    Scenario to Check number of Restaruants in Postal Code AR51 1AA
    [Setup]    Open Application
    Given I want food in    AR51 1AA    
    When Click Search button
    Then Verify Displayed restaurants in that postal code    AR51 1AA
    And Verify Number of restaurants in AR51 1AA 
    [Teardown]    Close Application
    
Scenario-3_TC03_Verify the restaurant list based on filtered option   
    [Documentation]    Scenario to Check for Restaruants based on the filtered option eg American, African
    [Setup]    Open Application
    Given I want food in    AR51 1AA    
    When Click Search button
    Then Verify Displayed restaurants in that postal code    AR51 1AA
    And Click Filtered option     African 
    And Verify American Cuisine restaurants are displayed     African 
    [Teardown]    Close Application

    

    
    