package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("user is on SpiceJet homepage")
    public void user_is_on_spicejet_homepage() {
        driver = DriverFactory.initDriver();
        loginPage = new LoginPage(driver);
        loginPage.open("https://www.spicejet.com/");
    }

    @When("user opens login form")
    public void user_opens_login_form() {
        loginPage.openLoginForm();
    }

	/*
	 * @When("user enters email {string} and password {string}") public void
	 * user_enters_email_and_password(String email, String password) {
	 * loginPage.enterEmail(email); loginPage.enterPassword(password); }
	 * 
	 * @When("user clicks login") public void user_clicks_login() {
	 * loginPage.clickSubmit(); }
	 * 
	 * @Then("user should be logged in successfully") public void
	 * user_should_be_logged_in_successfully() {
	 * Assert.assertTrue(loginPage.isLoggedIn(),
	 * "Expected user to be logged in (profile badge visible)."); }
	 */
}
