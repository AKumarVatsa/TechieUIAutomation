package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    // Initialize driver and return it
	/*
	 * public static WebDriver initDriver() { if (tlDriver.get() == null) {
	 * System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	 * 
	 * ChromeOptions options = new ChromeOptions();
	 * options.addArguments("--start-maximized"); // open browser maximized
	 * 
	 * WebDriver driver = new ChromeDriver(options); tlDriver.set(driver); } return
	 * tlDriver.get(); }
	 */
    

    public static WebDriver initDriver() {
        if (tlDriver.get() == null) {
            WebDriverManager.chromedriver().setup();  // ✅ auto-detects OS & Chrome version
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            //options.addArguments("--no-sandbox");
           // options.addArguments("--disable-dev-shm-usage");
            WebDriver driver = new ChromeDriver(options);
            tlDriver.set(driver);
        }
        return tlDriver.get();
    }
    // Get current driver
    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    // Quit and clean up
    public static void quitDriver() {
        WebDriver driver = tlDriver.get();
        if (driver != null) {
            driver.quit();
            tlDriver.remove();
        }
    }
}
