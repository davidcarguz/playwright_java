Feature: Login tests

  @successful_login
  Scenario: successful login
    Given I login with "standard_user"
    Then I validate I am in inventory page