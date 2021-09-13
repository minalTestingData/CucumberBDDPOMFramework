Feature: Account Page Feature

Background:
Given user has already logged in to application
|username|password|
|minaldukare@gmail.com|Riyansh@987| 


Scenario: Account Page Title
Given user is on Account Page
When user gets the title of page
Then page title should be "My account - My Store"


Scenario: Accounts section count
Given user is on Account Page
Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And accounts section count should be 6

Scenario: Account Page heading
Given user is on Account Page
When user gets heading of page
Then page heading should be "My Account"