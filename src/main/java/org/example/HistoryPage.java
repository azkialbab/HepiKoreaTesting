package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HistoryPage {
    WebDriver driver;

    public HistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFinishSection() {
        driver.findElement(By.id("tab-finish")).click();
    }

    public void clickFinishButton() {
        driver.findElement(By.cssSelector(".btn-finish"))
                .click();
    }

    public void selectRating(String stars) {
        int rating = Integer.parseInt(stars);
        driver.findElement(By.cssSelector(".star-rating input[value='" + rating + "']")).click();
    }

    public void enterReview(String review) {
        driver.findElement(By.id("review-input")).sendKeys(review);
    }

    public void submitReview() {
        driver.findElement(By.id("submit-review")).click();
    }

    public boolean isReviewDisplayed() {
        return driver.getPageSource().contains("Produk sangat bagus dan memuaskan");
    }

    public boolean noOrderMessageDisplayed() {
        return driver.getPageSource().contains("Tidak ada pesanan");
    }
}