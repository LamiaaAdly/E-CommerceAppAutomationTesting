#SC1- User could register with valid data
@register
Feature: User could register with valid data

  Background:user open browser and go to register page
    Given user open browser
    And user navigates to register page

  #test Scenario 1
  Scenario: User could register with valid data
    When user enter data "Lamiaa" , "Adly" , "lamiaa.adly09@gmail.com" , "MyP@ssword" and "MyP@ssword"
    And user click on register button
    Then user go to register result page
    When press continue button
    Then user return to home page
