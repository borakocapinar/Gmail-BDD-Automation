Feature: Gmail Logout
  As a logged-in Gmail user
  I want to log out of my account
  So that I can ensure my account is secure

  Scenario: Successfully log out
    Given I am logged into Gmail
    When I click on the profile icon
    And I click the Sign Out button
    Then I should be logged out and see the login page
