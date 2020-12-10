*** Settings ***
Library    SeleniumLibrary  
Library    String
Library    Collections   

*** Variable ***


*** Keywords ***
Verify search result page is loaded
    [Documentation]    KW to verify Search Result page is loaded or not
    Wait Until Element Is Visible    xpath=//*[@data-test-id="searchresults"]    1m 
     
Validate postal code matches with the search in home page
    [Documentation]    KW to validate the restaurants are displayed with the same postalcode searched
    [Arguments]    ${postal_code}
    Sleep    5s    
    ${actual}=    Get Text   xpath=//*[@class="c-locationHeader-title"]     
    ${str}=    Split String    ${actual}    ,     
    ${actual_value}=    Set Variable    ${str[0]}
    Log    ${actual_value}    
    #${actual_value}=    Get From List    ${str[0]}    0    
    Should Be Equal    ${actual_value}    ${postal_code}        PostalCode Not Matched 
    
 Verify open restaurants are displayed or not
    [Documentation]    KW to verify, the open restaurants are displayed or not
    ${locator}=    Set Variable    xpath=//*[@data-test-id="openrestaurants"]//a[@data-test-id="restaurant_info"]
    Page Should Contain Element    ${locator}    
    

Get Count
    [Documentation]    KW to get, the open restaurant's count
    ${locator}=    Set Variable    xpath=//*[@data-search-count="openrestaurants"]
    ${text}=    Get Text    ${locator}
    ${str}=    Get Regexp Matches    ${text}    \\d+  
    [return]    ${str[0]}
    Log    ${str[0]}    
    
Search Results should contain restaurants
    [Documentation]    KW to validate search result count of restaurants
    [Arguments]    ${value}
    ${locator}=    Set Variable    xpath=//*[@class="c-resultHeader-titleContainer"]//*[@data-test-id="openrestaurants-count-heading"]
    Element Should Contain    ${locator}    ${value}        
        
Click Filtered option  
    [Documentation]    KW to verify the number of restaurants from filtered option
    [Arguments]    ${cuisine}
   ${locator}=    Set Variable    xpath=//*[@data-test-id="all-cuisines-sidebar"]/span/label[@title="${cuisine}"]
   Wait Until Element Is Visible    ${locator}    20s 
   Click Element    ${locator} 
   Sleep    7s  
   
Search Results should contain American restaurants  
    [Documentation]    KW to verify the number of restaurants from filtered option
    [Arguments]    ${cuisine}    
    ${actual}=    Set Variable    xpath=//*[@class="c-listing-item-info"]/div/p[@data-test-id="restaurant-cuisines"]
    #xpath=//*[@class="c-listing"]//*[@class="c-listing-item-info"]/div/p[@data-cuisine-names="${cuisine}"] | xpath=//*[@class="c-listing-item-info"]/div/p//*[@class="c-badge-icon"]
    #${str}=    Get Text    ${actual}   
    #Should Be Equal    ${str}    ${cuisine}     
    Element Should Contain    ${actual}    ${cuisine}        
   
    
     
   
    
    