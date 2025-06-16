package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class ProductPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By productTab = By.xpath("//a[contains(@href, '/product')]");
    private final By searchBar = By.cssSelector("input[type='text']");
    private final By searchButton = By.id("btn-search");
    private final By searchResultCard = By.cssSelector(".product-card");

    private final By noProductText = By.xpath("//*[contains(text(),'Produk tidak ditemukan') or contains(text(),'Product Not Found')]");

    // Filter locators
    private final By categoryDropdown = By.id("categoryFilter");
    private final By minPriceInput = By.id("minPrice");
    private final By maxPriceInput = By.id("maxPrice");
    private final By sortByDropdown = By.id("sortBy");
    private final By applyFilterButton = By.id("btn-apply-filter"); // optional, ganti ID sesuai real

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Navigation
    public void clickProductTab() {
        wait.until(ExpectedConditions.elementToBeClickable(productTab)).click();
    }

    // Search
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

    // Filter
    public void selectCategory(String category) {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(categoryDropdown));
        Select select = new Select(dropdown);
        select.selectByVisibleText(category);
    }

    public void setMinPrice(String minPrice) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(minPriceInput));
        input.clear();
        input.sendKeys(minPrice);
    }

    public void setMaxPrice(String maxPrice) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(maxPriceInput));
        input.clear();
        input.sendKeys(maxPrice);
    }

    public void selectSortBy(String sortBy) {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(sortByDropdown));
        Select select = new Select(dropdown);
        select.selectByVisibleText(sortBy);
    }

    public void applyFilter() {
        try {
            WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(applyFilterButton));
            applyButton.click();
        } catch (TimeoutException e) {
            // If no apply button (auto filter), do nothing
        }
    }

    // Verification
    public boolean isProductFound() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultCard));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
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
