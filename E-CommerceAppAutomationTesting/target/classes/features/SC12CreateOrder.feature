#SC12- Create successful Order
@createSuccessfulOrder
Feature: User create successful Order
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
    When user select Add to cart button
    Then user go to product page
    When user select Add to cart button in product page
    Then user success to add selected product to Shopping cart

  #test Scenario 3 create full order
  Scenario: User could create successful Order
    Given user go to shopping cart page
    When user check terms of service checkbox
    And user press checkout button
    Then user go to billing page

    When user fill data
    And user click continue button

#    Then user go to shipping address page
#    When press continue button in shipping address page

    Then user go to shipping page


    When press continue button in shipping page
    Then user go to payment method page

    When user click continue button in payment method
    Then user go to payment information page

    When user click continue button in payment information
    Then user go to confirm order page

    When user click on confirm button in confirm order
    Then user see complete successful order

    When user click continue button in complete successful order
    Then user go to home page again

