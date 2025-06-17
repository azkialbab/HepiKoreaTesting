package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class ProductPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // LOCATORS
    private final By productTab = By.xpath("//a[contains(@href, '/product')]");

    private final By homepageSearchBar = By.xpath("//input[@type='text' and contains(@placeholder,'Cari')]");
    private final By productSearchBar = By.xpath("//*[@id='searchbar-container']/form/div/input");

    private final By searchButton = By.id("btn-search");
    private final By searchResultCard = By.cssSelector(".product-card");
    private final By noProductText = By.xpath("//*[contains(text(),'Produk tidak ditemukan') or contains(text(),'Product Not Found')]");

    // Filter locators
    private final By categoryDropdown = By.id("categoryFilter");
    private final By minPriceInput = By.id("minPrice");
    private final By maxPriceInput = By.id("maxPrice");
    private final By sortByDropdown = By.id("sortBy");
    private final By applyFilterButton = By.id("btn-apply-filter");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Determine which search bar to use based on the current page
    private By getSearchBarLocator() {
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("/product")) {
            return productSearchBar;
        } else {
            return homepageSearchBar;
        }
    }

    // NAVIGATION
    public void clickProductTab() {
        wait.until(ExpectedConditions.elementToBeClickable(productTab)).click();
    }

    // SEARCH BAR INTERACTION
    public void focusSearchBar() {
        try {
            By locator = getSearchBarLocator();
            WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input);
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (Exception e) {
            throw new RuntimeException("Gagal menemukan atau mengklik search bar. Periksa locator atau load page-nya.", e);
        }
    }

    public void enterSearchKeyword(String keyword) {
        try {
            By locator = getSearchBarLocator();
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            input.clear();
            input.sendKeys(keyword);
        } catch (Exception e) {
            throw new RuntimeException("Gagal memasukkan kata kunci pencarian.", e);
        }
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    // FILTER
    public void selectCategory(String category) {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(categoryDropdown));
        new Select(dropdown).selectByVisibleText(category);
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
        new Select(dropdown).selectByVisibleText(sortBy);
    }

    public void applyFilter() {
        try {
            WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(applyFilterButton));
            applyButton.click();
        } catch (TimeoutException e) {
            // If auto filter (no apply button), do nothing
        }
    }

    // VERIFICATION
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
    public void focusProductSearchBar() {
        try {
            WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(productSearchBar));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input);
            wait.until(ExpectedConditions.elementToBeClickable(productSearchBar)).click();
        } catch (Exception e) {
            throw new RuntimeException("Gagal menemukan atau mengklik search bar di halaman produk.", e);
        }
    }

    public void enterProductSearchKeyword(String keyword) {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(productSearchBar));
            input.clear();
            input.sendKeys(keyword);
        } catch (Exception e) {
            throw new RuntimeException("Gagal memasukkan kata kunci pencarian di halaman produk.", e);
        }
    }

}
