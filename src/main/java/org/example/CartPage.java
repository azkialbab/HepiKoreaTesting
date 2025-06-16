package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver) { this.driver = driver; }

    By checkoutButton = By.id("btn-checkout");

    public void selectProductToPay() {
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
    }

    public void clickCheckout() { driver.findElement(checkoutButton).click(); }
    public boolean isAtCartPage() {
        return driver.findElement(By.id("cart-title")).isDisplayed();
    }

}
