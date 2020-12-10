*** Settings ***
Library    SeleniumLibrary  
Resource    ../../Resources/PageObjects/BasePage.robot 
Resource    ../../Resources/PageObjects/RestaurantSearchResultsPage.robot

*** Keywords ***
Verify Displayed restaurants in that postal code
    [Documentation]    Display list of all restaurants in that location
    [Arguments]    ${postal_code}
    Verify search result page is loaded
    Validate postal code matches with the search in home page    ${postal_code}            
    Verify open restaurants are displayed or not
    
Verify Number of restaurants in AR51 1AA
    [Documentation]    KW to verify number of restaurants open in AR51 1AA
    ${value}=    Get Count
    Search Results should contain restaurants    ${value}      
    
Verify American Cuisine restaurants are displayed
    [Documentation]    KW to verify American cuisine restaurants are displayed
    [Arguments]    ${cuisine}
    ${value}=    GetCount    
    Search Results should contain American restaurants    ${cuisine}    
