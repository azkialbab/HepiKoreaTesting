package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPageAdmin {
    WebDriver driver;
    WebDriverWait wait;

    public ProductPageAdmin(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===== Locators =====
    By tabProduct = By.xpath("//*[@id='default-sidebar']/div/ul[1]/li[2]/a");
    By addButton = By.xpath("//*[@id=\"list_product\"]/div[1]/div[1]/button/img");
    By inputName = By.id("nama-produk");
    By inputHarga = By.id("harga-produk");
    By addCategory = By.xpath("//*[@id=\"dropdown_add_category\"]");
    By description = By.id("product-description");
    By buttonSave = By.xpath("//*[@id='add_product']//form//button[contains(., 'Simpan')]");

    // ===== Methods =====

    public void clickTabProduct() {
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(tabProduct));
        tab.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
    }

    public void clickAddButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addButton));
        button.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(inputName));
    }


    public void enterProductName(String name) {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(inputName));
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void enterProductPrice(String price) {
        WebElement priceField = wait.until(ExpectedConditions.visibilityOfElementLocated(inputHarga));
        priceField.clear();
        priceField.sendKeys(price);
    }


    public void selectCategory(String categoryName) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown_add_category")));
        Select select = new Select(dropdown);
        select.selectByVisibleText(categoryName);
    }





    public void enterDescription(String deskripsi) {
        WebElement descField = wait.until(ExpectedConditions.visibilityOfElementLocated(description));
        descField.clear();
        descField.sendKeys(deskripsi);
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_product")));
        WebElement saveButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id='add_product']/div/div/div[2]/div/form/div[5]/button")
        ));

        ((JavascriptExecutor) driver).executeScript(
                "let dbg = document.querySelector('.phpdebugbar'); if (dbg) dbg.style.display='none';"
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);

        System.out.println("Tombol Simpan berhasil diklik");
    }


    public void addNewProduct(String name, String price, String category, String description) {
        clickTabProduct();
        clickAddButton();
        enterProductName(name);
        enterProductPrice(price);
        selectCategory(category);
        enterDescription(description);
        clickSaveButton();
    }
}
