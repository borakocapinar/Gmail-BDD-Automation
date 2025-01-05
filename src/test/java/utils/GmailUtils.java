package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GmailUtils {

    WebDriver driver;
    WebDriverWait wait;

    public GmailUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void loginToGmail(String email, String password)  {
        // Navigate to Gmail
        driver.get("https://mail.google.com/");

        // Enter email
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("identifierId")))
                .sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("identifierNext")))
                .click();

        // Enter password

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type=password]"))).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordNext")))
                .click();

        // Wait for the inbox to load
        wait.until(ExpectedConditions.titleContains("Gelen Kutusu"));
        System.out.println("Gelen Kutusu");
    }
}
