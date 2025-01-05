Feature: Gmail Login
  As a Gmail user
  I want to log in successfully
  So that I can access my emails

  Scenario: Successful login
    Given I am on the Gmail login page
    When I enter a valid email
    And I click the "email Next" button
    When I enter a valid password
    And I click the "password Next" button
    Then I should see my inbox
