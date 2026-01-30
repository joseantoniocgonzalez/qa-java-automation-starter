package ui.utils;

import config.TestConfig;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class Waiter {

  private final WebDriverWait wait;

  public Waiter(WebDriver driver) {
    this.wait = new WebDriverWait(driver, Duration.ofMillis(TestConfig.explicitWaitMs()));
  }

  public WebElement visible(By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public WebElement clickable(By locator) {
    return wait.until(ExpectedConditions.elementToBeClickable(locator));
  }

  public boolean urlContains(String fragment) {
    return wait.until(ExpectedConditions.urlContains(fragment));
  }
}
