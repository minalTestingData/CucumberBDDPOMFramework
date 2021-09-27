Feature:  My Store Login Page Feature

Background:
Given user is on Home page
When user clicks on Sign in button
Then user should be on login page

Scenario: Login Page Title
When user gets the title of page
Then page title should be "Login - My Store"

Scenario: Forgot your password link
Given user should be on login page
Then Forgot your password link should be displayed

Scenario: Login with registed credentials
Given user should be on login page
When user enters email address "minaldukare@gmail.com"
And user enters password "Riyansh@987"
And click on Sign in button
Then user gets the title of page
And page title should be "My account - My Store"

Scenario: Logout from application
Given User is on My account page
When user clicks on Sign out
Then user should be on login page 

Scenario: Create a new account
Given user should be on login page
When user enters email address "minalD@gmail.com"
And clicks on Create an account button
Then user gets the title of page
And page title should be "Login - My Store"
