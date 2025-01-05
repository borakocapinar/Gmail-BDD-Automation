Feature: Gmail Email Viewing
  As a Gmail user
  I want to open an email from my inbox
  So that I can read its content

  Scenario: Open an email from the inbox
    Given I am logged into Gmail
    And I am on the inbox page
    When I click on the first email in the list
    Then I should see the content of the email
