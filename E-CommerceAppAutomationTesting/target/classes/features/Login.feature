#SC2- User could log in with valid email and password
@login
Feature: User could log in with valid email and password

  Background:user open browser and go to login page
    Given user open browser
    And user navigates to login page

  #test Scenario 1
  Scenario: User could log in with valid email and password
    When user enter "lamiaa.adly09@gmail.com" and "MyP@ssword"
    And user click on login button
    Then user go to home page

#  #test Scenario 2
#  Scenario: user login with invalid email and password
#    When user enter "hi@gmail.com" and "Super"
#    And user click on login button
#    Then user could not login
