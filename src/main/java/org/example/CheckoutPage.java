package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;
    public CheckoutPage(WebDriver driver) { this.driver = driver; }

    By addressDropdown = By.id("address");
    By productQty = By.name("qty");
    By checkoutButton = By.id("btn-checkout-final");
    By paymentMethod = By.name("paymentMethod");
    By payButton = By.id("btn-pay");

    public void selectAddress() { driver.findElement(addressDropdown).click(); }
    public void enterQuantity(String qty) { driver.findElement(productQty).sendKeys(qty); }
    public void clickFinalCheckout() { driver.findElement(checkoutButton).click(); }
    public void selectPaymentMethod() { driver.findElement(paymentMethod).click(); }
    public void clickPay() { driver.findElement(payButton).click(); }
}
