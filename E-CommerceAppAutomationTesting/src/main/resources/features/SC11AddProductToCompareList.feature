#SC11- Logged user could add different products to compare list
@addCompareList
Feature: Logged user could add different products to compare list
  Background:user login successfully

  #test Scenario 1 login
  Scenario: User could log in with valid email and password
    Given user open browser
    And user navigates to login page
    When user enter "lamiaa.adly09@gmail.com" and "MyP@ssword"
    And user click on login button
    Then user go to home page

  #test Scenario 2 add products to compare list
  Scenario: User could add products to compare list
    When user select Add to compare list button
    Then user success to add selected product to compare list