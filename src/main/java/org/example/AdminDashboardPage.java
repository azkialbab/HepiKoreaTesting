package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class AdminDashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    public AdminDashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    By profileIcon = By.xpath("//*[@id=\"app\"]/nav/div/div/div[2]/div/div[1]/button/img");
    By logoutButton = By.xpath("//*[@id=\"default-sidebar\"]/div/ul[2]/li/a");
    By confirmButton = By.id("btn-confirm-logout");
    By cancelButton = By.id("btn-cancel-logout");
    By orderTab = By.id("sidebar-order");
    By prodductTab = By.xpath("//*[@id=\"default-sidebar\"]/div/ul[1]/li[2]/a");

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    public void confirmLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();
    }

    public void cancelLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
    }
    public void clickProfileIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(profileIcon)).click();
    }
    public boolean isProfileIconVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(profileIcon)).isDisplayed();
    }

    public void clickOrderSidebar() {
        wait.until(ExpectedConditions.elementToBeClickable(orderTab)).click();
    }

    public boolean isDashboardVisible() {
        return driver.getCurrentUrl().contains("/admin") ||
                driver.findElements(orderTab).size() > 0;
    }
}
