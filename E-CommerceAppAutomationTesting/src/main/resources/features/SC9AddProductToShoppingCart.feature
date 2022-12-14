#SC9- Logged user could add different products to Shopping cart.

Feature: Logged user could add different products to Shopping cart
  Background:user login successfully

  #test Scenario 1 login
  Scenario: User could log in with valid email and password
    Given user open browser
    And user navigates to login page
    When user enter "lamiaa.adly09@gmail.com" and "MyP@ssword"
    And user click on login button
    Then user go to home page

  #test Scenario 2 add products to Shopping cart
  Scenario: User could add products to Shopping cart
#    Given user go to any page have product even home page
    When user select Add to cart button
    Then user success to add selected product to Shopping cart