package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HistoryPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    private final By finishTab = By.id("tab-finish");
    private final By finishButton = By.cssSelector(".btn-finish");
    private final By reviewInput = By.id("review-input");
    private final By submitButton = By.id("submit-review");
    private final By reviewResult = By.cssSelector(".review-result"); // optional: update if needed
    private final By noOrderText = By.xpath("//*[contains(text(),'Tidak ada pesanan')]");
    private final By errorMessage = By.cssSelector(".error-message"); // optional: update if needed

    public HistoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickFinishSection() {
        wait.until(ExpectedConditions.elementToBeClickable(finishTab)).click();
    }

    public void clickFinishButton() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }

    public void selectRating(int stars) {
        // Pastikan input[type=radio][value=stars] tersedia
        By ratingSelector = By.cssSelector(".star-rating input[value='" + stars + "']");
        wait.until(ExpectedConditions.elementToBeClickable(ratingSelector)).click();
    }

    public void enterReviewText(String review) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(reviewInput)).sendKeys(review);
    }

    public void clickSubmitReview() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public boolean isReviewDisplayed() {
        return driver.getPageSource().contains("Produk sangat bagus dan memuaskan");
    }

    public boolean isEmptyOrderDisplayed() {
        return driver.findElements(noOrderText).size() > 0;
    }

    public String getErrorMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isOnHistoryPage() {
        return driver.getCurrentUrl().contains("/profile/history");
    }
}
