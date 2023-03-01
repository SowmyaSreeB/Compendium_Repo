Feature: Compendium

  @Home
  Scenario:
    Given User launches URL
    When  User clicks on contact
    Then  User fills the form
    And  User verify the form is submitted successfully
    And  User closes the browser