package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    By sectionOrder = By.id("order-section");
    By firstOrderCard = By.cssSelector(".order-card:first-of-type");
    By processButton = By.id("btn-process");
    By sentButton = By.id("btn-sent");
    By arrivalIndonesiaInput = By.id("arrival-indonesia-date");
    By expeditionCompanyInput = By.id("expedition-company");
    By shippingCostInput = By.id("shipping-cost");
    By trackingCodeInput = By.id("tracking-code");
    By arrivalCustomerInput = By.id("arrival-customer-date");
    By statusLabel = By.cssSelector(".order-status");

    public void clickOrderSection() {
        driver.findElement(sectionOrder).click();
    }

    public boolean isInOrderSection() {
        return driver.findElement(sectionOrder).isDisplayed();
    }

    public boolean isOrderAvailable() {
        return driver.findElements(firstOrderCard).size() > 0;
    }

    public void selectAnOrder() {
        driver.findElement(firstOrderCard).click();
    }

    public void clickProcess() {
        driver.findElement(processButton).click();
    }

    public void enterEstimatedArrivalInIndonesia(String date) {
        driver.findElement(arrivalIndonesiaInput).sendKeys(date);
    }

    public String getOrderStatus() {
        return driver.findElement(statusLabel).getText();
    }

    public void clickSent() {
        driver.findElement(sentButton).click();
    }

    public void enterShippingCompany(String company) {
        driver.findElement(expeditionCompanyInput).sendKeys(company);
    }

    public void enterShippingCost(String cost) {
        driver.findElement(shippingCostInput).sendKeys(cost);
    }

    public void enterTrackingCode(String code) {
        driver.findElement(trackingCodeInput).sendKeys(code);
    }

    public void enterEstimatedArrivalToCustomer(String date) {
        driver.findElement(arrivalCustomerInput).sendKeys(date);
    }

    public boolean noOrderDisplayed() {
        return driver.getPageSource().contains("Tidak ada pesanan");
    }
}

