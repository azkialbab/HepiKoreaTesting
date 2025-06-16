package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminDashboardPage {
    WebDriver driver;

    public AdminDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    By logoutButton = By.id("btn-logout");
    By confirmButton = By.id("btn-confirm-logout");
    By cancelButton = By.id("btn-cancel-logout");
    By orderTab = By.id("sidebar-order");

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public void confirmLogout() {
        driver.findElement(confirmButton).click();
    }

    public void cancelLogout() {
        driver.findElement(cancelButton).click();
    }

    public void clickOrderSidebar() {
        driver.findElement(orderTab).click();
    }

    public void loginAsAdmin(String email, String password) {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("btn-login")).click();
    }
}