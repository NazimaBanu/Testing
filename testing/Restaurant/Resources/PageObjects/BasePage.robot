*** Settings ***
Library    SeleniumLibrary 
   
*** Keywords ***
I want food in       
    [Documentation]    Keyword to enter postal code to display with restaurants
    [Arguments]    ${postal_code}
    #Wait Until Element Is Visible    xpath=//*[contains(text(),"Tuck into a takeway today")]    1m
    ${we_locator}=    Set Variable    xpath=//input[@name="postcode"]
    Wait Until Element Is Visible    ${we_locator}    1m
    Input Text    ${we_locator}    ${postal_code}
    
Click Search button
    [Documentation]    Keyword to click the Search button
    Click Element    xpath=//*[@data-test-id="find-restaurants-button"]    
   