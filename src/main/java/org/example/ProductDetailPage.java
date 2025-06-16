package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
import org.openqa.selenium.WebElement;

public class ProductDetailPage {
    WebDriver driver;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

<<<<<<< HEAD
=======
    // Locators
=======

public class ProductDetailPage {
    WebDriver driver;
    public ProductDetailPage(WebDriver driver) { this.driver = driver; }

>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
>>>>>>> origin/master
    By quantityInput = By.name("quantity");
    By addToCartButton = By.id("btn-add-to-cart");
    By buyNowButton = By.id("btn-buy-now");

<<<<<<< HEAD

=======
<<<<<<< HEAD
>>>>>>> origin/master
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
<<<<<<< HEAD
=======
=======
    public void selectQuantity(String qty) { driver.findElement(quantityInput).sendKeys(qty); }
    public void clickAddToCart() { driver.findElement(addToCartButton).click(); }
    public void clickBuyNow() { driver.findElement(buyNowButton).click(); }
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
>>>>>>> origin/master
}
