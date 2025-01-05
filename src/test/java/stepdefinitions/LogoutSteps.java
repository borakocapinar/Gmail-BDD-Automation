package stepdefinitions;

import Utility.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.cdimascio.dotenv.Dotenv;

import utils.DotenvUtils;

import java.sql.DriverManager;
import java.time.Duration;

public class LogoutSteps {

    WebDriver driver;

    WebDriverWait wait;


    @Before
    public void setUp() {
        this.driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @When("I click on the profile icon")
    public void i_click_on_the_profile_icon() {
        // Locate and click the profile icon
        By profileIconLocator = By.xpath("//a[contains(@aria-label, 'Google Hesabı')]");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(profileIconLocator))
                .click();
    }

    @And("I click the Sign Out button")
    public void i_click_the_sign_out_button() {
        driver.switchTo().frame("account");

        // Locate the Sign Out button within the iframe
        By signOutButtonLocator = By.xpath("//a[contains(@href, 'accounts.google.com/Logout')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(signOutButtonLocator));

        // Print the text of the Sign Out button
        System.out.println(driver.findElement(signOutButtonLocator).getText());

        // Click the Sign Out button
        driver.findElement(signOutButtonLocator).click();

        // Switch back to the default content
        driver.switchTo().defaultContent();

    }

    @Then("I should be logged out and see the login page")
    public void i_should_be_logged_out_and_see_the_login_page() {
        // Verify the user is redirected to the login page
        By logoutLocator = By.xpath("//div[contains(text(),'Oturum kapatıldı')]");

                new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(logoutLocator));
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Redirected to: " + currentUrl);
        assert currentUrl.contains("accounts.google.com");


    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();    }
}
