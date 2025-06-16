package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import org.openqa.selenium.WebElement;
=======
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
>>>>>>> origin/master
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
<<<<<<< HEAD
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By loginButton = By.cssSelector("#login-container"); // Tombol login saat user belum login
=======
<<<<<<< HEAD
    private final WebDriver driver;
    private final WebDriverWait wait;

    // ===== Locators (disesuaikan dengan struktur HTML) =====
    private final By loginButton = By.cssSelector("#login-container");
>>>>>>> origin/master
    private final By productTab = By.xpath("//nav//a[normalize-space()='Product']");
    private final By searchBar = By.cssSelector("#searchbar-container input[type='text']");
    private final By searchButton = By.id("btn-search");
    private final By cartTab = By.xpath("//a[contains(@href,'/cart')]");
<<<<<<< HEAD
    private final By historyTab = By.xpath("//a[normalize-space()='History']");


    // Profile navigation
    private final By profilePicTab = By.cssSelector("#user-profile-container button"); // Foto profil user
    private final By logoutButton = By.xpath("//a[normalize-space()='Logout']");

    // Logout modal
    private final By confirmLogoutButton = By.xpath("//button[normalize-space()='Yes, Logout']");
    private final By cancelLogoutButton = By.xpath("//button[normalize-space()='Cancel']");

    // Search results
    private final By productCard = By.cssSelector(".product-card"); // produk ditemukan
    private final By notFoundMessage = By.xpath("//*[contains(text(),'not found') or contains(text(),'tidak ditemukan')]");

=======
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
>>>>>>> origin/master
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Navigation
    public void clickLogin() {
<<<<<<< HEAD
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
=======
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        btn.click();
=======
    // ===== Actions with Waits =====
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
>>>>>>> origin/master
    }

    public void clickProductTab() {
        wait.until(ExpectedConditions.elementToBeClickable(productTab)).click();
    }

<<<<<<< HEAD
    public void clickCartTab() {
        wait.until(ExpectedConditions.elementToBeClickable(cartTab)).click();
    }

    // Search
    public void enterSearchKeyword(String keyword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar)).clear();
        driver.findElement(searchBar).sendKeys(keyword);
=======
    public void enterSearch(String keyword) {
<<<<<<< HEAD
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        input.clear();
        input.sendKeys(keyword);
=======
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar)).sendKeys(keyword);
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
>>>>>>> origin/master
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public boolean isSearchResultDisplayed() {
        return !driver.findElements(productCard).isEmpty();
    }

    public boolean isEmptySearchResultDisplayed() {
        return !driver.findElements(notFoundMessage).isEmpty();
    }

    // Profile & Logout
    public void clickProfileTab() {
        wait.until(ExpectedConditions.elementToBeClickable(profilePicTab)).click();
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

    // Verification
    public boolean isLoginButtonVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isDisplayed();
    }

    public boolean isProfilePictureVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(profilePicTab)).isDisplayed();
    }
    public void clickHistoryTab() {
        wait.until(ExpectedConditions.elementToBeClickable(historyTab)).click();
    }

}
