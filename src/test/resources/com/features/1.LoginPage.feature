Feature: Login Page Feature

@LoginPage
Scenario: Login Page
Given user is on ELIS login page
When user enters username
And user click on next button
When user enters password
And user clicks on Login button
Then user gets the title of the page
And page title should be "Home Page"