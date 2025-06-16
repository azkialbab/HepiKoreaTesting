package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
<<<<<<< HEAD
import org.openqa.selenium.WebElement;
=======
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
<<<<<<< HEAD
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
=======
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
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
    private final By confirmLogoutButton = By.id("btn-logout-confirm");
    private final By cancelLogoutButton = By.id("btn-logout-cancel");
    private final By profileDropdown = By.id("dropdown-profile");
    private final By historyTab = By.id("dropdown-history");

<<<<<<< HEAD
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickLogin() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        btn.click();
=======
    // ===== Actions with Waits =====
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
    }

    public void clickProductTab() {
        wait.until(ExpectedConditions.elementToBeClickable(productTab)).click();
    }

    public void enterSearch(String keyword) {
<<<<<<< HEAD
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        input.clear();
        input.sendKeys(keyword);
=======
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar)).sendKeys(keyword);
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
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
