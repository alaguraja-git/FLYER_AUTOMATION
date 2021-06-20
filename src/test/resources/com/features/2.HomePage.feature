Feature: Home Page Feature

Background:
Given user has already logged in to application
|username|password|
|morrishari@mailinator.com|000000|

@home
Scenario: Home page title
Given user is on Home page
When user gets the title of the page
Then page title should be "Flyer School: add"

@home
Scenario: Home Page Headers section count
Given user is on Home page
Then user gets home page headers section
|Messages|
|Users|
|Analytics|
|App Setup|
And home page headers section count should be 4