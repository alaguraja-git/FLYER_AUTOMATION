Feature: Home Page Feature

@HomePage
Scenario: Home Page 
Given user is on ELIS login page
When user enters username
And user click on next button
When user enters password
And user clicks on Login button
When user gets the title of the page
Then page title should be "345Home Page"