@regression
Feature: SauceDemo regression

  Scenario: Invalid login shows an error message
    Given I open the SauceDemo login page
    When I login with username "standard_user" and password "wrong_password"
    Then I should see a login error message

  Scenario: Add one item updates the cart badge
    Given I am logged in as "standard_user" with password "secret_sauce"
    When I add the first item to the cart
    Then the cart badge should show "1"
