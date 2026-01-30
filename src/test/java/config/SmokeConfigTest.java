package config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class SmokeConfigTest {

  private WebDriver driver;

  @Test
  void canOpenBaseUrl() {
    driver = DriverFactory.create();
    driver.get(TestConfig.baseUrl());

    String title = driver.getTitle();
    Assertions.assertNotNull(title, "Page title should not be null");
    Assertions.assertFalse(title.trim().isEmpty(), "Page title should not be empty");
  }

  @AfterEach
  void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
