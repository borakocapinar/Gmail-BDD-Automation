Feature: Gmail Login with Invalid Credentials
  As a Gmail user
  I want to see an error message

  Scenario: Login with an invalid email
    Given I am on the Gmail login page
    When I enter an invalid email
    And I click the "email Next" button
    Then I should see an error message indicating the email is incorrect

  Scenario: Login with an invalid password
    Given I am on the Gmail login page
    When I enter a valid email
    And I click the "email Next" button
    And I enter an invalid password
    And I click the "password Next" button
    Then I should see an error message indicating the password is incorrect
