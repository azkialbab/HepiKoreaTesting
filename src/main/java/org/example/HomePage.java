package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // ===== Locators (disesuaikan dengan struktur HTML) =====
    private final By loginButton = By.cssSelector("#login-container");
    private final By productTab = By.xpath("//nav//a[normalize-space()='Product']");
    private final By searchBar = By.cssSelector("#searchbar-container input[type='text']");
    private final By searchButton = By.id("btn-search");
    private final By cartTab = By.xpath("//a[contains(@href,'/cart')]");
    private final By profilePicTab = By.cssSelector("#user-profile-container button");
    private final By logoutButton = By.xpath("//a[normalize-space()='Logout']");
    private final By confirmLogoutButton = By.id("btn-logout-confirm");
    private final By cancelLogoutButton = By.id("btn-logout-cancel");
    private final By profileDropdown = By.id("dropdown-profile");
    private final By historyTab = By.id("dropdown-history");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickLogin() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        btn.click();
    }

    public void clickProductTab() {
        wait.until(ExpectedConditions.elementToBeClickable(productTab)).click();
    }

    public void enterSearch(String keyword) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        input.clear();
        input.sendKeys(keyword);
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public void clickCartTab() {
        wait.until(ExpectedConditions.elementToBeClickable(cartTab)).click();
    }

    public void clickProfileTab() {
        wait.until(ExpectedConditions.elementToBeClickable(profilePicTab)).click();
    }

    public void clickProfileDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(profileDropdown)).click();
    }

    public void clickHistoryTab() {
        wait.until(ExpectedConditions.elementToBeClickable(historyTab)).click();
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    public void confirmLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmLogoutButton)).click();
    }

    public void cancelLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelLogoutButton)).click();
    }
}
