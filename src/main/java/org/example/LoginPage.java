package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) { this.driver = driver; }

    By emailField = By.name("email");
    By passwordField = By.name("password");
    By loginButton = By.id("btn-login-submit");
    By registerLink = By.id("btn-register");

    public void enterEmail(String email) { driver.findElement(emailField).sendKeys(email); }
    public void enterPassword(String password) { driver.findElement(passwordField).sendKeys(password); }
    public void clickLogin() { driver.findElement(loginButton).click(); }
    public void clickRegisterLink() { driver.findElement(registerLink).click(); }
    By loginWithGoogleButton = By.id("btn-login-google");

    public void clickLoginWithGoogle() {
        driver.findElement(loginWithGoogleButton).click();
    }

}
