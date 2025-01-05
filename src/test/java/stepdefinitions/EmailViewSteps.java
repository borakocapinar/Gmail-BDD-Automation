package stepdefinitions;

import Utility.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DotenvUtils;

import java.time.Duration;
import java.util.List;

public class EmailViewSteps {


    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }





    @And("I am on the inbox page")
    public void i_am_on_the_inbox_page() {
        wait.until(ExpectedConditions.titleContains("Gelen Kutusu"));
        assert driver.getTitle().toLowerCase().contains("gelen kutusu");
        System.out.println(driver.getTitle().toLowerCase());
    }

    @When("I click on the first email in the list")
    public void i_click_on_the_first_email_in_the_list() {
        // Define the locator for the email list items
        By emailListLocator = By.cssSelector(".zA"); // Locator for individual email rows

        // Wait until at least one email is visible in the inbox
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> emailList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(emailListLocator));

        // Ensure the list is not empty
        if (emailList.isEmpty()) {
            throw new IllegalStateException("No emails found in the inbox.");
        }

        // Click the first email in the list
        WebElement firstEmail = emailList.getFirst();
        firstEmail.click();

        // Log for debugging
        System.out.println("Clicked on the first email in the list.");
    }


    @Then("I should see the content of the email")
    public void i_should_see_the_content_of_email() {
        // Locate the email content section
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailContent;


        try {
            // Wait for the email content to be visible and locate it
            emailContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".a3s.aiL")));
        } catch (TimeoutException e) {
            throw new AssertionError("Email content did not load within the expected time.", e);
        }

        // Extract the email content
        String content = emailContent.getText();

        // Define the expected content
        String expectedContent = DotenvUtils.get("INBOX_EMAIL_CONTENT");

        // Perform an assertion with a more descriptive message
        if (content.contains(expectedContent)) {
            System.out.println("The email content is correct: " + content);
        } else {
            throw new AssertionError("Expected email content was not found. \nExpected: "
                    + expectedContent + "\nActual: " + content);
        }
    }
}
