Feature: Account Page Feature

Background:
Given: user has already logged in to application
|username|password|
|minaldukare@gmail.com|Riyansh@987| 

@accounts
Scenario: Account Page Title
Given user is on Account Page
When ser gets title of page
Then page title should be "My account - My Store"

@accounts
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