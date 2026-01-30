package ui.tests;

import config.DriverFactory;
import config.TestConfig;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public abstract class BaseUiTest {

  protected WebDriver driver;

  @BeforeEach
  void setUp() {
    driver = DriverFactory.create();
  }

  @AfterEach
  void tearDown(TestInfo testInfo) {
    // If the test failed, JUnit will call tearDown anyway, but we don't get the status directly here.
    // So we store evidence on demand from the test when catching assertions/exceptions.
    if (driver != null) {
      driver.quit();
    }
  }

  protected void saveEvidenceOnFailure(String testName, Exception e) {
    try {
      String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
      String safeName = testName.replaceAll("[^a-zA-Z0-9\\-_.]", "_");

      Path screenshotsDir = Path.of(TestConfig.artifactsDir());
      Path htmlDir = Path.of(TestConfig.htmlSourceDir());
      Files.createDirectories(screenshotsDir);
      Files.createDirectories(htmlDir);

      // Screenshot
      if (driver instanceof TakesScreenshot tsDriver) {
        byte[] png = tsDriver.getScreenshotAs(OutputType.BYTES);
        Files.write(screenshotsDir.resolve(safeName + "-" + ts + ".png"), png);
      }

      // HTML source
      String html = driver.getPageSource();
      Files.writeString(htmlDir.resolve(safeName + "-" + ts + ".html"), html, StandardCharsets.UTF_8);

    } catch (IOException io) {
      // If evidence fails, we still want the original test failure to be visible.
      System.err.println("Failed to save evidence: " + io.getMessage());
    } finally {
      if (e != null) {
        throw new RuntimeException(e);
      }
    }
  }
}
