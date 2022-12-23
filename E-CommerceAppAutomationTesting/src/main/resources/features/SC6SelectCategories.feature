#SC6- Logged user could select different Categories
@selectCategories
Feature: Logged user could select different Categories
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
    When user hover to Computers
    And user select Notebooks
    Then user go to Notebooks category page