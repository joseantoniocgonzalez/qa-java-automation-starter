package ui.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ui.pages.InventoryPage;
import ui.pages.LoginPage;

class UiSmokeE2ETest extends BaseUiTest {

  @Test
  void smoke_login_success_and_inventory_loaded() {
    try {
      LoginPage login = new LoginPage(driver).open();
      login.typeUsername("standard_user")
          .typePassword("secret_sauce")
          .submit();

      InventoryPage inventory = new InventoryPage(driver);
      Assertions.assertTrue(inventory.isLoaded(), "Inventory page should be loaded");
      Assertions.assertEquals("Products", inventory.title(), "Inventory title should be 'Products'");

    } catch (Exception e) {
      saveEvidenceOnFailure("smoke_login_success_and_inventory_loaded", e);
    }
  }

  @Test
  void secondary_add_one_item_updates_cart_badge() {
    try {
      LoginPage login = new LoginPage(driver).open();
      login.typeUsername("standard_user")
          .typePassword("secret_sauce")
          .submit();

      InventoryPage inventory = new InventoryPage(driver);
      inventory.addFirstItemToCart();

      Assertions.assertEquals("1", inventory.cartCount(), "Cart badge should show 1 item");

    } catch (Exception e) {
      saveEvidenceOnFailure("secondary_add_one_item_updates_cart_badge", e);
    }
  }
}
