package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.nio.file.Files;
import java.nio.file.Path;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver initDriver() {
        if (tlDriver.get() == null) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // Detect if running in CI (GitHub Actions sets HEADLESS=true)
            String headless = System.getenv("HEADLESS");
            if ("true".equalsIgnoreCase(headless)) {
                options.addArguments("--headless");   // ✅ compatible for Linux
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");

                // Fix for "user data dir already in use"
                try {
                    Path tmpProfile = Files.createTempDirectory("chrome-profile");
                    options.addArguments("--user-data-dir=" + tmpProfile.toString());
                } catch (Exception e) {
                    System.out.println("Failed to create temp user-data-dir: " + e.getMessage());
                }
            } else {
                // Local run (Windows/macOS) with full browser
                options.addArguments("--start-maximized");
            }

            WebDriver driver = new ChromeDriver(options);
            tlDriver.set(driver);
        }
        return tlDriver.get();
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
        WebDriver driver = tlDriver.get();
        if (driver != null) {
            driver.quit();
            tlDriver.remove();
        }
    }
}
