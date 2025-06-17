package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private final By confirmArrivalButton = By.xpath("//button[contains(text(),'Confirm Arrival')]");

    private final By payShipmentButton = By.xpath("//button[contains(text(),'Pay Shipment')]");
    private final By payShipmentModalButton = By.tagName("button");
    private final By shipmentModalHeader = By.xpath("//h1[contains(text(), 'Detail Shipment')]");

    private final By paymentMethodHeader = By.xpath("//h1[contains(text(), 'Bank')]");
    private final By mandiriPaymentMethod = By.cssSelector("input[value='mandiri']");

    private final By PaymentModalHeader = By.xpath("//h1[text()='Payment']");

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

    public void clickConfirmArrivalBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmArrivalButton)).click();
    }

    public void clickPayShipmentButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(payShipmentButton)).click();
    }

    public void clickPayShipmentModalButton() {
        WebElement shipmentModal = wait.until(ExpectedConditions.visibilityOfElementLocated(shipmentModalHeader))
                .findElement(By.xpath(".."));
        WebElement payBtn = shipmentModal.findElement(payShipmentModalButton);
        payBtn.click();
    }

    public void clickMandiriPaymentMethod() {
        WebElement paymentMethodModal = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentMethodHeader))
                .findElement(By.xpath(".."));
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodModal.findElement(mandiriPaymentMethod))).click();
        wait.until(ExpectedConditions.visibilityOf(paymentMethodModal.findElement(payShipmentModalButton))).click();
    }

    public boolean isPaymentModalDisplayed() {
        try {
            WebElement paymentModal = wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentModalHeader)).findElement(By.xpath(".."));
            System.out.println(paymentModal.getDomProperty("innerHTML"));
            return paymentModal.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
