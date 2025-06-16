package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Tunggu max 10 detik
    }

    // ===== Locators =====
    private final By loginButton = By.id("btn-login");
    private final By productTab = By.xpath("//a[contains(text(),'Product')]");
    private final By searchBar = By.name("search");
    private final By searchButton = By.id("btn-search");
    private final By cartTab = By.id("tab-cart");
    private final By profilePicTab = By.id("tab-profile");
    private final By logoutButton = By.id("btn-logout");
    private final By confirmLogoutButton = By.id("btn-logout-confirm");
    private final By cancelLogoutButton = By.id("btn-logout-cancel");
    private final By profileDropdown = By.id("dropdown-profile");
    private final By historyTab = By.id("dropdown-history");

    // ===== Actions with Waits =====
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void clickProductTab() {
        wait.until(ExpectedConditions.elementToBeClickable(productTab)).click();
    }

    public void enterSearch(String keyword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar)).sendKeys(keyword);
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
