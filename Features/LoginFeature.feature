Feature: LoginFeature

@Sanity @regression
Scenario: Successful login with valid Credentials
Given User Launch Chrome Browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and Password as "admin"
And click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on Log out link
Then Page Title should be "nopCommerce demo store. Login"
#And close browser

@regression
Scenario Outline: Successful Login with Valid Credentials DDT
Given User Launch Chrome Browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "<email>" and Password as "<admin>"
And click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on Log out link
Then Page Title should be "nopCommerce demo store. Login"
And close browser

Examples:
|email               | password |  
|admin@yourstore.com |  admin   |
#|test@yourstore.com  |  admin   |
 