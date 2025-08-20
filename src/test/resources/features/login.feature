Feature: SpiceJet Login

  @smoke
  Scenario: Login with valid credentials
    Given user is on SpiceJet homepage
    When user opens login form
    And user enters email "test@example.com" and password "Password@123"
    And user clicks login
    Then user should be logged in successfully
