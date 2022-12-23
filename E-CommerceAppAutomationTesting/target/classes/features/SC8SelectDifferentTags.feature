#SC8- Logged user could select different tags
@selectDifferentTags
Feature: Logged user could select different tags

  Background:user login successfully

  #test Scenario 1 login
  Scenario: User could log in with valid email and password
    Given user open browser
    And user navigates to login page
    When user enter "lamiaa.adly09@gmail.com" and "MyP@ssword"
    And user click on login button
    Then user go to home page

  #test Scenario 2 select different tags
  Scenario: User could select different tags
    Given user go to product tags page
    When user select awesome product tag
    Then user go to selected product tag page