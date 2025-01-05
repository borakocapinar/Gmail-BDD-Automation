package stepdefinitions;


import Utility.DriverFactory;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DotenvUtils;
import utils.GmailUtils;
import utils.GmailUtils;
import java.time.Duration;

public class CommonSteps   {
    GmailUtils gmailUtils;






    @Given("I am logged into Gmail")
    public void i_am_logged_into_gmail() {
        // Initialize WebDriver and GmailUtils
        gmailUtils = new GmailUtils(DriverFactory.getDriver());

        // Reuse login functionality from GmailUtils
        gmailUtils.loginToGmail(DotenvUtils.get("VALID_EMAIL"), DotenvUtils.get("VALID_PASSWORD"));
        System.out.println("Logged into Gmail");
    }

    }
