package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By navbar = By.xpath("//*[@id=\"app\"]/div/nav/div"); // Navbar
    private final By loginButton = By.xpath("//a[normalize-space()='Login']"); // Tombol Login
    private final By productTab = By.xpath("//nav//a[normalize-space()='Product']");
    private final By searchBar = By.cssSelector("#searchbar-container input[type='text']");
    private final By searchButton = By.id("btn-search");
    private final By cartTab = By.xpath("//a[contains(@href,'/cart')]");
    private final By historyTab = By.xpath("//a[normalize-space()='History']");

    // Profile navigation
    private final By profilePicTab = By.cssSelector("#user-profile-container button");
    private final By logoutButton = By.xpath("//a[normalize-space()='Logout']");

    // Logout modal
    private final By confirmLogoutButton = By.xpath("//button[normalize-space()='Yes, Logout']");
    private final By cancelLogoutButton = By.xpath("//button[normalize-space()='Cancel']");

    // Search results
    private final By productCard = By.cssSelector(".product-card");
    private final By notFoundMessage = By.xpath("//*[contains(text(),'not found') or contains(text(),'tidak ditemukan')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Navigation
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void clickProductTab() {
        wait.until(ExpectedConditions.elementToBeClickable(productTab)).click();
    }

    public void clickCartTab() {
        wait.until(ExpectedConditions.elementToBeClickable(cartTab)).click();
    }

    public void clickHistoryTab() {
        wait.until(ExpectedConditions.elementToBeClickable(historyTab)).click();
    }

    // Search
    public void enterSearchKeyword(String keyword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar)).clear();
        driver.findElement(searchBar).sendKeys(keyword);
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
    public boolean isNavbarVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(navbar)).isDisplayed();
    }

    public boolean isLoginButtonVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isDisplayed();
    }

    public boolean isProfilePictureVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(profilePicTab)).isDisplayed();
    }
}
