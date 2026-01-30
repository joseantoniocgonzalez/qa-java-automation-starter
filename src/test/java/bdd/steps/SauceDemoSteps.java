package bdd.steps;

import config.DriverFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import ui.pages.InventoryPage;
import ui.pages.LoginPage;

public class SauceDemoSteps {

  private WebDriver driver;
  private LoginPage loginPage;
  private InventoryPage inventoryPage;

  @Before
  public void setUp() {
    driver = DriverFactory.create();
    loginPage = new LoginPage(driver);
    inventoryPage = new InventoryPage(driver);
  }

  @After
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Given("I open the SauceDemo login page")
  public void i_open_the_login_page() {
    loginPage.open();
  }

  @When("I login with username {string} and password {string}")
  public void i_login_with_username_and_password(String username, String password) {
    loginPage.typeUsername(username).typePassword(password).submit();
  }

  @Then("I should see the inventory page with title {string}")
  public void i_should_see_inventory_page_with_title(String expectedTitle) {
    Assertions.assertTrue(inventoryPage.isLoaded(), "Inventory page should be loaded");
    Assertions.assertEquals(expectedTitle, inventoryPage.title());
  }

  @Then("I should see a login error message")
  public void i_should_see_a_login_error_message() {
    String error = loginPage.readError();
    Assertions.assertNotNull(error);
    Assertions.assertFalse(error.trim().isEmpty(), "Error message should not be empty");
  }

  @Given("I am logged in as {string} with password {string}")
  public void i_am_logged_in_as_with_password(String username, String password) {
    loginPage.open();
    loginPage.typeUsername(username).typePassword(password).submit();
    Assertions.assertTrue(inventoryPage.isLoaded(), "Inventory page should be loaded");
  }

  @When("I add the first item to the cart")
  public void i_add_the_first_item_to_the_cart() {
    inventoryPage.addFirstItemToCart();
  }

  @Then("the cart badge should show {string}")
  public void the_cart_badge_should_show(String expected) {
    Assertions.assertEquals(expected, inventoryPage.cartCount());
  }
}
