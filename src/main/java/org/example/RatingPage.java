package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RatingPage {
    WebDriver driver;
    public RatingPage(WebDriver driver) { this.driver = driver; }

    By finishTab = By.id("tab-finish");
    By finishButton = By.id("btn-finish");
    By ratingStars = By.name("rating");
    By reviewTextArea = By.name("review");
    By submitButton = By.id("btn-submit-review");

    public void clickFinishTab() { driver.findElement(finishTab).click(); }
    public void clickFinishButton() { driver.findElement(finishButton).click(); }
    public void giveRating() { driver.findElement(ratingStars).click(); }
    public void writeReview(String review) { driver.findElement(reviewTextArea).sendKeys(review); }
    public void clickSubmit() { driver.findElement(submitButton).click(); }
}