Feature: Customers

Background: Steps common for all scenarios
Given User Launch Chrome Browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and Password as "admin"
And click on Login
Then User can view Dashboard 

@Sanity
Scenario: Add New Customer
When User click on customers menu
And click on customers Menu Item
And click on Add New button
Then User can view Add new customer page
When User enter customer info
And click on Save button
Then User can view confirmation message "The new customer has been added successfully."
And close browser

@regression
Scenario: Search Customer by Email
When User click on customers menu
And click on customers Menu Item
And Enter customer Email
When click on search button
Then User should find Email in the Search table
And close browser

@regression
Scenario: Search Customer by Name
When User click on customers menu
And click on customers Menu Item
And Enter customer FirstName
And Enter customer LastName
When click on search button
Then User should find Name in the Search table
And close browser