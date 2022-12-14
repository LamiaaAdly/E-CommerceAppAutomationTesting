#SC2- User could log in with valid email and password
@login
Feature: User could log in with valid email and password

  Background:user open browser and go to login page
    Given user open browser

  #test Scenario 1 register
  Scenario: User could register with valid data
    Given user navigates to register page
    When user enter data "Lamiaa" , "Adly" , "lamiaa.adly0911@gmail.com" , "MyP@ssword" and "MyP@ssword"
    And user click on register button
    Then user go to register result page
    When press continue button
    Then user return to home page

  #test Scenario 2 login
  Scenario: User could log in with valid email and password
    Given user navigates to login page
    When user enter "lamiaa.adly09@gmail.com" and "MyP@ssword"
    And user click on login button
    Then user go to home page
