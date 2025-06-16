package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FAQPage {

    WebDriver driver;

    public FAQPage(WebDriver driver) {
        this.driver = driver;
    }

    // === Locators ===
    private By tabFAQ = By.xpath("//*[@id='default-sidebar']/div/ul[1]/li[6]/a");
    private By addFAQButton = By.xpath("//*[@id='app']/div/div/div/div[1]/button");
    private By inputFAQTitle = By.xpath("//*[@id='app']/div/div/div/div[3]/div/div/div/div/form/input");
    private By inputFAQContent = By.xpath("//*[@id='app']/div/div/div/div[3]/div/div/div/div/form/textarea");
    private By saveButton = By.xpath("//*[@id='app']/div/div/div/div[3]/div/div/div/div/form/button");
    private By errorMessageTitle = By.xpath("//*[@id='app']/div/div/div/div[3]/div/div/div/div/form/p[1]");
    private By errorMessageContent = By.xpath("//*[@id='app']/div/div/div/div[3]/div/div/div/div/form/p[2]");

    // === Actions ===
    public void clickTabFAQ() {
        driver.findElement(tabFAQ).click();
    }

    public void clickAddFAQ() {
        driver.findElement(addFAQButton).click();
    }

    public void enterFAQTitle(String title) {
        WebElement titleField = driver.findElement(inputFAQTitle);
        titleField.clear();
        titleField.sendKeys(title);
    }

    public void enterFAQContent(String content) {
        WebElement contentField = driver.findElement(inputFAQContent);
        contentField.clear();
        contentField.sendKeys(content);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public boolean isFAQDisplayed(String faqTitle) {
        String xpath = String.format("//td[contains(text(),'%s')]", faqTitle);
        return driver.findElements(By.xpath(xpath)).size() > 0;
    }

    public boolean isErrorMessageTitleDisplayed(String message) {
        WebElement error = driver.findElement(errorMessageTitle);
        return error.isDisplayed() && error.getText().equalsIgnoreCase(message);
    }

    public boolean isErrorMessageContentDisplayed(String message) {
        WebElement error = driver.findElement(errorMessageContent);
        return error.isDisplayed() && error.getText().equalsIgnoreCase(message);
    }
}
