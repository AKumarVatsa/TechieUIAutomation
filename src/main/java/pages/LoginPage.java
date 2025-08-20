package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators (may change as site updates)
    private By loginButton = By.xpath("//div[text()='Login']");
    private By emailField = By.xpath("//input[@type='email' or @data-testid='username-input']");
    private By passwordField = By.xpath("//input[@type='password' or @data-testid='password-input']");
    private By submitButton = By.xpath("//div[@data-testid='login-cta' or .//text()='LOGIN']");
    private By profileBadge = By.xpath("//*[contains(@class,'profile') or @data-testid='user-profile-icon']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void open(String url) {
        driver.get(url);
    }

    public void openLoginForm() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public boolean isLoggedIn() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(profileBadge));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
