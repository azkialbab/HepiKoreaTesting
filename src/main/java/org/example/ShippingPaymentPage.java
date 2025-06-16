package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPaymentPage {
    WebDriver driver;
    public ShippingPaymentPage(WebDriver driver) { this.driver = driver; }

    By historyTab = By.id("tab-history");
    By sentSection = By.id("section-sent");
    By payShippingButton = By.id("btn-pay-shipping");
    By paymentMethod = By.name("paymentMethod");
    By payButton = By.id("btn-pay");

    public void clickHistoryTab() { driver.findElement(historyTab).click(); }
    public void clickSentSection() { driver.findElement(sentSection).click(); }
    public void clickPayShipping() { driver.findElement(payShippingButton).click(); }
    public void selectPaymentMethod() { driver.findElement(paymentMethod).click(); }
    public void clickPay() { driver.findElement(payButton).click(); }
}
