package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage {
    WebDriver driver;
    public ProductDetailPage(WebDriver driver) { this.driver = driver; }

    By quantityInput = By.name("quantity");
    By addToCartButton = By.id("btn-add-to-cart");
    By buyNowButton = By.id("btn-buy-now");

    public void selectQuantity(String qty) { driver.findElement(quantityInput).sendKeys(qty); }
    public void clickAddToCart() { driver.findElement(addToCartButton).click(); }
    public void clickBuyNow() { driver.findElement(buyNowButton).click(); }
}
