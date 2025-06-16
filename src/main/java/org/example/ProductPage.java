package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By productTab = By.xpath("//a[contains(@href, '/product')]");
    private final By searchBar = By.cssSelector("input[type='text']");
    private final By searchButton = By.id("btn-search");
    private final By searchResultCard = By.cssSelector(".product-card");
    private final By noProductText = By.xpath("//*[contains(text(),'Produk tidak ditemukan')]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickProductTab() {
        wait.until(ExpectedConditions.elementToBeClickable(productTab)).click();
    }

    public void focusSearchBar() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBar)).click();
    }

    public void enterSearchKeyword(String keyword) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        input.clear();
        input.sendKeys(keyword);
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public boolean isSearchResultVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultCard));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isNoProductFoundMessageVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(noProductText));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
