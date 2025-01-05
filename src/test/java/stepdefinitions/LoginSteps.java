package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utility.DriverFactory;
import utils.DotenvUtils;

import java.sql.DriverManager;
import java.time.Duration;

public class LoginSteps {

    WebDriver driver;
    WebDriverWait wait;



    @Before
    public void setUp() {
        this.driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    @Given("I am on the Gmail login page")
    public void i_am_on_the_gmail_login_page() {
        driver.get("https://mail.google.com/");
    }



    @When("I enter an invalid email")
    public void i_enter_an_invalid_email() {
        enterEmail(DotenvUtils.get("INVALID_EMAIL"));

    }

    @When("I enter a valid email")
    public void i_enter_a_valid_email() {
        enterEmail(DotenvUtils.get("VALID_EMAIL"));
    }

    @And("I enter an invalid password")
    public void i_enter_an_invalid_password() {
        enterPassword(DotenvUtils.get("INVALID_PASSWORD"));
    }

    private void enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type=password]"))).sendKeys(password);
    }

    private void enterEmail(String email) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("identifierId")))
                .sendKeys(email);

    }

    @And("I enter a valid password")
    public void i_enter_a_valid_password() {
       enterPassword(DotenvUtils.get("VALID_PASSWORD"));

    }

    @And("I click the {string} button")
    public void i_click_the_button(String buttonName) {
        if (buttonName.equalsIgnoreCase("email next")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("identifierNext")))
                    .click();
        }
        else if (buttonName.equalsIgnoreCase("password next")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordNext")))
                    .click();
        }
    }

    @Then("I should see my inbox")
    public void i_should_see_my_inbox() {
        wait.until(ExpectedConditions.titleContains("Gelen Kutusu"));
        assert driver.getTitle().toLowerCase().contains("gelen kutusu");

    }

    @Then("I should see an error message indicating the email is incorrect")
    public void i_should_see_an_error_message_indicating_the_email_is_incorrect() {
        By errorLocator = By.xpath("//div[contains(text(),'Google Hesabınız bulunamadı')]");
        String errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(errorLocator)).getText();
        System.out.println("Error message for invalid email: " + errorMessage);

    }

    @Then("I should see an error message indicating the password is incorrect")
    public void i_should_see_an_error_message_indicating_the_password_is_incorrect() {
        By errorLocator = By.xpath("//span[contains(text(),'Şifre yanlış')]");
        String errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(errorLocator)).getText();
        System.out.println("Error message for invalid password: " + errorMessage);

    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }


}