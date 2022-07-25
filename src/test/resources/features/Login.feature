Feature: Login tests

  @successful_login
  Scenario: successful login
    Given User logins as "standard_user" with "password"
    Then User validates I am in inventory page

  @wrong_password
  Scenario: wrong password login
    Given  User logins as "standard_user" with "wrong_password"
    Then  User validates error message for "wrong_password"