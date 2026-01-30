@smoke
Feature: SauceDemo smoke

  Scenario: Successful login shows Products page
    Given I open the SauceDemo login page
    When I login with username "standard_user" and password "secret_sauce"
    Then I should see the inventory page with title "Products"
