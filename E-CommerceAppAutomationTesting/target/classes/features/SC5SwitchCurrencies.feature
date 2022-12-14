#SC5- Logged User could switch between currencies US-Euro
@switchCurrencies
Feature: Logged User could switch between currencies US-Euro

  Background:user login successfully

  #test Scenario 1 login
  Scenario: User could log in with valid email and password
    Given user open browser
    And user navigates to login page
    When user enter "lamiaa.adly09@gmail.com" and "MyP@ssword"
    And user click on login button
    Then user go to home page

  #test Scenario 2 switch currencies
  Scenario: Logged user can search
    When user change customer currency
    Then product price change