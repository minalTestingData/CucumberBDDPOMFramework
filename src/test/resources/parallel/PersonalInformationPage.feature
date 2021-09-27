Feature: Personal Information Feature

Scenario Outline: Update personal information with required field

Given User is on Personal information page
When User fill form from given "<sheetname>" and rownumber <rownum>
And click on save button
Then user should get message "Your personal information has been successfully updated." 

Examples:
|sheetname|rownum|
|PersonalInfo|0|
|PersonalInfo|1|

Scenario: User entered password

Given User is on Personal information page
When User enter password from given "PersonalInfo" and rownumber 2
Then User entered password


