package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By emailField = By.xpath("//*[@id=\"app\"]/main/div/form/div[1]/input");
    By passwordField = By.xpath("//*[@id=\"password\"]");
    By loginButton = By.xpath("//*[@id=\"app\"]/main/div/form/button");
    By registerLink = By.xpath("//*[@id=\"app\"]/main/div/p/a");
    By loginWithGoogleButton = By.xpath("//*[@id=\"app\"]/main/div/a");

    public void navigateToLoginPage() {
        driver.get("https://hepikorea.pad19.me/login"); // Sesuaikan dengan URL login sebenarnya
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void clickRegisterLink() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
    }

    public void clickLoginWithGoogle() {
        wait.until(ExpectedConditions.elementToBeClickable(loginWithGoogleButton)).click();
    }

    public void loginAsAdmin(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }
}
