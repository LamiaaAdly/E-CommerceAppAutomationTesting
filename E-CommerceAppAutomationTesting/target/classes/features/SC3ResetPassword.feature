#SC3- User could reset his/her password successfully
@resetPassword
Feature: User could reset his/her password successfully

  Background:user go to login page and press forget password?

  #test Scenario 1 register
#  @First
#  Scenario: User could register with valid data
#    Given user open browser
#    And user navigates to register page
#    When user enter data "Lamiaa" , "Adly" , "lamiaa.adly0911@gmail.com" , "MyP@ssword" and "MyP@ssword"
#    And user click on register button
#    Then user go to register result page
#    When press continue button
#    Then user return to home page

  #test Scenario 2 resetPassword
#  @Second
  Scenario: User could reset his/her password
    Given user press forget password link
    When user enters "lamiaa.adly09@gmail.com"
    And user click on recover button
    Then user read successful message