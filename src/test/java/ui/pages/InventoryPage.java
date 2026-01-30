package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.utils.Waiter;

public class InventoryPage {

  private final WebDriver driver;
  private final Waiter waiter;

  private final By pageTitle = By.cssSelector("[data-test='title']");
  private final By firstAddToCartButton = By.cssSelector("[data-test^='add-to-cart']");
  private final By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
  private final By cartLink = By.cssSelector("[data-test='shopping-cart-link']");

  public InventoryPage(WebDriver driver) {
    this.driver = driver;
    this.waiter = new Waiter(driver);
  }

  public String title() {
    return waiter.visible(pageTitle).getText();
  }

  public InventoryPage addFirstItemToCart() {
    waiter.clickable(firstAddToCartButton).click();
    return this;
  }

  public String cartCount() {
    return waiter.visible(cartBadge).getText();
  }

  public void openCart() {
    waiter.clickable(cartLink).click();
  }

  public boolean isLoaded() {
    return waiter.visible(pageTitle).isDisplayed();
  }
}
