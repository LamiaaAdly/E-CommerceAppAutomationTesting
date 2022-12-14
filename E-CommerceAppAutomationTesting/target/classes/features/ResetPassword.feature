#SC3- User could reset his/her password successfully
@resetPassword
Feature: User could reset his/her password successfully

  Background:user go to login page and press forget password?
    Given user press forget password link

  #test Scenario 1
  Scenario: User could reset his/her password
    When user enters "lamiaa.adly09@gmail.com"
    And user click on recover button
    Then user read successful message