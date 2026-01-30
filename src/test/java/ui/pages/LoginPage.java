package ui.pages;

import config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.utils.Waiter;

public class LoginPage {

  private final WebDriver driver;
  private final Waiter waiter;

  private final By username = By.id("user-name");
  private final By password = By.id("password");
  private final By loginButton = By.id("login-button");
  private final By errorMessage = By.cssSelector("[data-test='error']");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    this.waiter = new Waiter(driver);
  }

  public LoginPage open() {
    driver.get(TestConfig.baseUrl());
    waiter.visible(username);
    return this;
  }

  public LoginPage typeUsername(String value) {
    waiter.visible(username).clear();
    waiter.visible(username).sendKeys(value);
    return this;
  }

  public LoginPage typePassword(String value) {
    waiter.visible(password).clear();
    waiter.visible(password).sendKeys(value);
    return this;
  }

  public void submit() {
    waiter.clickable(loginButton).click();
  }

  public String readError() {
    return waiter.visible(errorMessage).getText();
  }
}
