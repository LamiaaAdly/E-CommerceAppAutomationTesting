#SC4- Logged User could search for any product
@search
Feature: Logged user could search for any product

  Background:user login successfully

  #test Scenario 1 login
  Scenario: User could log in with valid email and password
    Given user open browser
    And user navigates to login page
    When user enter "lamiaa.adly09@gmail.com" and "MyP@ssword"
    And user click on login button
    Then user go to home page

  #test Scenario 2 search
  Scenario: Logged user can search
    When user write "Apple MacBook Pro 13-inch" in search field
    And press search button
    Then user find product
