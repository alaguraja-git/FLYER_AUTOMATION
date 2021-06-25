Feature: District Admin User Page feature

Background:
Given user has already logged in to application
|username|password|
|morrishari@mailinator.com|000000|

@DistrictAdmin
Scenario Outline: District Admin User Page
When select under district user drop down "<District_Message>" dropdown
And enter the "<Subject>" and "<Message>"
And click on send button
Then sent message should be displayed "<Sent_Message>"

Examples: 
        |District_Message|Subject       |Message            |Sent_Message|
        |Bulk district|District Admin|District Admin Message|Message Sent|

@DistrictAdmin
Scenario Outline: School Admin User Page
When select under school user drop down "<school_dropdown>"
And enter the School "<Subject>" and "<Message>"
And click on send button
Then sent message should be displayed "<Sent_Message>"
Examples: 
        |school_dropdown|Subject       |Message            |Sent_Message|
        |Test|School Drop Down Message Message|Drop Down Message Message|Message Sent|
        
