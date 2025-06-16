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
<<<<<<< HEAD
    public boolean isAtCartPage() {
        return driver.findElement(By.id("cart-title")).isDisplayed();
    }

=======
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
}
