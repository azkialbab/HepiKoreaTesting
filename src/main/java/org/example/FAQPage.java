package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class FAQPage {

    WebDriver driver;
    WebDriverWait wait;

    public FAQPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // === Locators ===
    private By tabFAQ = By.xpath("//*[@id='default-sidebar']/div/ul[1]/li[6]/a");
    private By addFAQButton = By.xpath("//*[@id='app']/div/div/div/div[1]/button");
    private By inputFAQTitle = By.xpath("//*[@id=\"app\"]/div/div/div/div[3]/div/div/div/div/form/input");
    private By inputFAQContent = By.xpath("//*[@id=\"app\"]/div/div/div/div[3]/div/div/div/div/form/textarea");
    private By saveButton = By.xpath("//button[contains(text(),'Save')]");
    private By errorMessageTitle = By.xpath("//*[@id='app']/div/div/div/div[3]/div/div/div/div/form/p[1]");
    private By errorMessageContent = By.xpath("//*[@id='app']/div/div/div/div[3]/div/div/div/div/form/p[2]");

    // === Actions ===
    public void clickTabFAQ() {
        wait.until(ExpectedConditions.elementToBeClickable(tabFAQ)).click();
    }

    public void clickAddFAQ() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addFAQButton));
        wait.until(ExpectedConditions.elementToBeClickable(addFAQButton)).click();
    }

    public void enterFAQTitle(String title) {
        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(inputFAQTitle));
        titleField.clear();
        titleField.sendKeys(title);
    }

    public void enterFAQContent(String content) {
        WebElement contentField = wait.until(ExpectedConditions.visibilityOfElementLocated(inputFAQContent));
        contentField.clear();
        contentField.sendKeys(content);
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }


    public boolean isErrorMessageTitleDisplayed(String expectedMessage) {
        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageTitle));
            return error.getText().trim().equalsIgnoreCase(expectedMessage.trim());
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorMessageContentDisplayed(String expectedMessage) {
        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageContent));
            return error.getText().trim().equalsIgnoreCase(expectedMessage.trim());
        } catch (Exception e) {
            return false;
        }
    }
}
