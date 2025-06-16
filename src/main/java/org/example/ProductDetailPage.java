package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailPage {
    WebDriver driver;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    By quantityInput = By.name("quantity");
    By addToCartButton = By.id("btn-add-to-cart");
    By buyNowButton = By.id("btn-buy-now");


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

    public boolean isAtDetailPage() {
        return driver.getCurrentUrl().contains("/product/detail");
    }
}
