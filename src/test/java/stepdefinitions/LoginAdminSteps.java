package stepdefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static stepdefinitions.BaseSteps.driver;

public class LoginAdminSteps {

    @Given("user login sebagai admin")
    public void user_login_sebagai_admin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@type='email']")));
        emailField.clear();
        emailField.sendKeys("admin@admin.com");

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.clear();
        passwordField.sendKeys("123");


        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        wait.until(ExpectedConditions.urlContains("/admin"));
        assertTrue(driver.getCurrentUrl().contains("/admin"));
    }
}
