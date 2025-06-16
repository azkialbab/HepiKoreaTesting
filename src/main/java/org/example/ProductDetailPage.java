package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
<<<<<<< HEAD
import org.openqa.selenium.WebElement;

public class ProductDetailPage {
    WebDriver driver;

    // Constructor
    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
=======

public class ProductDetailPage {
    WebDriver driver;
    public ProductDetailPage(WebDriver driver) { this.driver = driver; }

>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
    By quantityInput = By.name("quantity");
    By addToCartButton = By.id("btn-add-to-cart");
    By buyNowButton = By.id("btn-buy-now");

<<<<<<< HEAD
    // Actions
    public void selectQuantity(String qty) {
        WebElement quantityField = driver.findElement(quantityInput);
        quantityField.clear(); // Bersihkan dulu isian sebelumnya
        quantityField.sendKeys(qty);
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void clickBuyNow() {
        driver.findElement(buyNowButton).click();
    }

    // Optional: Validasi halaman
    public boolean isAtDetailPage() {
        return driver.getCurrentUrl().contains("/product/detail");
        // Atau bisa gunakan element spesifik jika URL tidak konsisten:
        // return driver.findElement(buyNowButton).isDisplayed();
    }
=======
    public void selectQuantity(String qty) { driver.findElement(quantityInput).sendKeys(qty); }
    public void clickAddToCart() { driver.findElement(addToCartButton).click(); }
    public void clickBuyNow() { driver.findElement(buyNowButton).click(); }
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
}
