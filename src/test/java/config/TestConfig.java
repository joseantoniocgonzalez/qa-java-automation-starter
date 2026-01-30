package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class TestConfig {

  private static final String CONFIG_PATH = "config/test.properties";
  private static final Properties PROPS = load();

  private TestConfig() {}

  private static Properties load() {
    Properties p = new Properties();
    try (InputStream is = TestConfig.class.getClassLoader().getResourceAsStream(CONFIG_PATH)) {
      if (is == null) {
        throw new IllegalStateException("Config file not found on classpath: " + CONFIG_PATH);
      }
      p.load(is);
      return p;
    } catch (IOException e) {
      throw new IllegalStateException("Failed to load config: " + CONFIG_PATH, e);
    }
  }

  public static String baseUrl() {
    return getRequired("baseUrl");
  }

  public static String browser() {
    return getOrDefault("browser", "chrome").trim().toLowerCase();
  }

  public static boolean headless() {
    return Boolean.parseBoolean(getOrDefault("headless", "true"));
  }

  public static int pageLoadMs() {
    return getIntOrDefault("timeout.pageLoadMs", 30000);
  }

  public static int implicitWaitMs() {
    return getIntOrDefault("timeout.implicitWaitMs", 0);
  }

  public static int explicitWaitMs() {
    return getIntOrDefault("timeout.explicitWaitMs", 8000);
  }

  public static String artifactsDir() {
    return getOrDefault("artifacts.dir", "screenshots");
  }

  public static String htmlSourceDir() {
    return getOrDefault("htmlsource.dir", "html-source");
  }

  private static String getRequired(String key) {
    String v = PROPS.getProperty(key);
    if (v == null || v.trim().isEmpty()) {
      throw new IllegalStateException("Missing required config key: " + key);
    }
    return v.trim();
  }

  private static String getOrDefault(String key, String defaultValue) {
    String v = PROPS.getProperty(key);
    return (v == null) ? defaultValue : v;
  }

  private static int getIntOrDefault(String key, int defaultValue) {
    String v = PROPS.getProperty(key);
    if (v == null) return defaultValue;
    try {
      return Integer.parseInt(v.trim());
    } catch (NumberFormatException e) {
      throw new IllegalStateException("Invalid integer for key: " + key + " -> " + v);
    }
  }
}
