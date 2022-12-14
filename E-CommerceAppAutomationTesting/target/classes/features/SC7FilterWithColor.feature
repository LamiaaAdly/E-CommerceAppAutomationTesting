#SC7- Logged user could filter with color

Feature: Logged user could filter with color

  Background:user login successfully

  #test Scenario 1 login
  Scenario: User could log in with valid email and password
    Given user open browser
    And user navigates to login page
    When user enter "lamiaa.adly09@gmail.com" and "MyP@ssword"
    And user click on login button
    Then user go to home page

  #test Scenario 2 select categories
  Scenario: Logged user can select categories
    When user hover to "Apparel"
    And user select "Shoes"
    Then user go to this category page

  #test Scenario 2 filter with color
  Scenario: Logged user can filter with color
    When user select colors
    Then user see products with selected colors