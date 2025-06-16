package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

// ProductPage
public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    By categoryDropdown = By.id("filter-category");
    By minPriceField = By.id("min-price");
    By maxPriceField = By.id("max-price");
    By sortByDropdown = By.id("sort-by");
    By applyFilterButton = By.id("apply-filter");
    By notFoundText = By.id("product-not-found");

    // Untuk fitur filter
    public void selectCategory(String category) {
        if (!category.isEmpty()) {
            driver.findElement(categoryDropdown).sendKeys(category);
        }
    }

    public void setMinPrice(String price) {
        if (!price.isEmpty()) {
            driver.findElement(minPriceField).clear();
            driver.findElement(minPriceField).sendKeys(price);
        }
    }

    public void setMaxPrice(String price) {
        if (!price.isEmpty()) {
            driver.findElement(maxPriceField).clear();
            driver.findElement(maxPriceField).sendKeys(price);
        }
    }

    public void selectSortBy(String sortBy) {
        if (!sortBy.isEmpty()) {
            driver.findElement(sortByDropdown).sendKeys(sortBy);
        }
    }

    public void applyFilter() {
        driver.findElement(applyFilterButton).click();
    }

    public boolean isProductFound() {
        // Jika elemen 'not found' tidak muncul, maka produk ditemukan
        return driver.findElements(notFoundText).isEmpty();
    }

    // Tambahan: untuk klik produk berdasarkan nama
    public void selectProductByName(String productName) {
        driver.findElement(By.xpath("//h5[text()='" + productName + "']")).click();
    }

    public void clickBuy(String productName) {
        driver.findElement(By.xpath("//h5[text()='" + productName + "']/../..//button[contains(text(),'Buy')]")).click();
    }
}
