Feature: Admin User Page feature

Scenario Outline: District Admin User  Page
Given user is on login page
When user enters username "<username>"
And user enters password "<password>"
And user clicks on Login button
Then user gets the title of the page
When select under district user drop down "<District_Message>"
And enter the "<Subject>" and "<Message>"
Then click on send button

Examples: 
        |username                 |password|District_Message     |Subject       |Message               |
        |morrishari@mailinator.com|000000  |Bulk district admin's|District Admin|District Admin Message|