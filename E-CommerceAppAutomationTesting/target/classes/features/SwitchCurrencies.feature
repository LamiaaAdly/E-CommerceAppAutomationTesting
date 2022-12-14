#SC5- Logged User could switch between currencies US-Euro
@switchCurrencies
Feature: Logged User could switch between currencies US-Euro

  Background:user login successfully
    Given user go to home page with successfully login

  #test Scenario 1
  Scenario: Logged user can search
    When user change customer currency
    Then product price change