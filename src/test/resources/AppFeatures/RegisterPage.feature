Feature: RegisterPage Feature

Background:
user is already on Register page
|minalDew@gmail.com| 

Scenario: Register Page Heading
Given User is on Register page
When user gets heading of page
Then page heading should be "CREATE AN ACCOUNT"

Scenario: Register the User
Given User is on Register page
When user enter the personal information
|title|custfirstname|custlastname|email|password|firstname|lastname|address|city|state|zipcode|country|mobilenumber|address|
And user clicks on Register button
Then user is on Account Page
And user gets the title of page
And page title should be "My account - My Store"