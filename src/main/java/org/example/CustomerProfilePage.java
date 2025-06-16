package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerProfilePage {
    WebDriver driver;

    public CustomerProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    By logoutOption = By.id("dropdown-logout");
    By confirmButton = By.id("btn-confirm-logout");
    By cancelButton = By.id("btn-cancel-logout");

    public void clickLogoutDropdown() {
        driver.findElement(logoutOption).click();
    }

    public void confirmLogout() {
        driver.findElement(confirmButton).click();
    }

    public void cancelLogout() {
        driver.findElement(cancelButton).click();
    }
}

