package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class DriverFactory {

  private DriverFactory() {}

  public static WebDriver create() {
    String browser = TestConfig.browser();

    WebDriver driver;
    switch (browser) {
      case "firefox" -> driver = createFirefox();
      case "chrome" -> driver = createChrome();
      default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
    }

    driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(TestConfig.pageLoadMs()));
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(TestConfig.implicitWaitMs()));
    return driver;
  }

  private static WebDriver createChrome() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    if (TestConfig.headless()) {
      options.addArguments("--headless=new");
    }
    options.addArguments("--window-size=1280,800");
    return new ChromeDriver(options);
  }

  private static WebDriver createFirefox() {
    WebDriverManager.firefoxdriver().setup();
    FirefoxOptions options = new FirefoxOptions();
    if (TestConfig.headless()) {
      options.addArguments("-headless");
    }
    return new FirefoxDriver(options);
  }
}
