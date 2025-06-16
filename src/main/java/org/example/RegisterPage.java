package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    By fullnameField = By.name("fullname");
    By emailField = By.name("email");
    By passwordField = By.name("password");
    By confirmPasswordField = By.name("confirmPassword");
    By registerButton = By.id("btn-register-submit");
    By otpField = By.name("otp");

    public void enterFullname(String name) {
        driver.findElement(fullnameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterConfirmPassword(String confirm) {
        driver.findElement(confirmPasswordField).sendKeys(confirm);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void enterOTP(String otp) {
        driver.findElement(otpField).sendKeys(otp);
    }

    public boolean isOnHomepage() {
        return driver.getCurrentUrl().contains("home");
    }
}

