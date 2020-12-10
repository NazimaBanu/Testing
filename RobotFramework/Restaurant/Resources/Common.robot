*** Settings ***
Library    SeleniumLibrary 
Variables    ../Resources/TestConfig/TestConfig.py

#***Variables***
#${ENV_URL}    http://www.just-eat.co.uk/
#${ENV_BROWSER}    chrome    

***Keywords***
Open Application
    [Documentation]    Setup to open the browser
    #Open Browser    ${ENV_URL}    browser=chrome  
    Open Browser    ${ENV_URL}    ${ENV_BROWSER}  
    Maximize Browser Window
    
Close Application
    [Documentation]    KW to close the browser
    Capture Page Screenshot    
    Close All Browsers   