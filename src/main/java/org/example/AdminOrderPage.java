package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminOrderPage {
    WebDriver driver;
    public AdminOrderPage(WebDriver driver) { this.driver = driver; }

    By orderTab = By.id("tab-order");
    By processButton = By.id("btn-process");
    By sentButton = By.id("btn-sent");
    By estArrivalID = By.name("arrivalIndonesia");
    By estArrivalCust = By.name("arrivalCustomer");
    By shippingPrice = By.name("shippingPrice");
    By expeditionCompany = By.name("expedition");
    By trackingCode = By.name("resi");

    public void clickOrderTab() { driver.findElement(orderTab).click(); }
    public void clickProcess() { driver.findElement(processButton).click(); }
    public void fillShippingDetails(String expedition, String price, String resi, String etaID, String etaCust) {
        driver.findElement(expeditionCompany).sendKeys(expedition);
        driver.findElement(shippingPrice).sendKeys(price);
        driver.findElement(trackingCode).sendKeys(resi);
        driver.findElement(estArrivalID).sendKeys(etaID);
        driver.findElement(estArrivalCust).sendKeys(etaCust);
    }
    public void clickSent() { driver.findElement(sentButton).click(); }
}
