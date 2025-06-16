package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.Assert.*;

public class ProductFilterSteps {

    WebDriver driver = BaseSteps.driver;
    WebDriverWait wait;

    @When("pengguna memilih tab Product pada navigation bar")
    public void pengguna_memilih_tab_product() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/product')]")));
        productTab.click();
        wait.until(ExpectedConditions.urlContains("/product"));
    }

    @And("user memilih kategori {string}")
    public void user_memilih_kategori(String category) {
        if (!category.isEmpty()) {
            WebElement categoryDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("categoryFilter")));
            Select select = new Select(categoryDropdown);
            select.selectByVisibleText(category);
        }
    }

    @And("user memasukan minimum price {string}")
    public void user_memasukan_minimum_price(String minPrice) {
        WebElement minPriceInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("minPrice")));
        minPriceInput.clear();
        if (!minPrice.isEmpty()) {
            minPriceInput.sendKeys(minPrice);
        }
    }

    @And("user memasukan maximum price {string}")
    public void user_memasukan_maximum_price(String maxPrice) {
        WebElement maxPriceInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("maxPrice")));
        maxPriceInput.clear();
        if (!maxPrice.isEmpty()) {
            maxPriceInput.sendKeys(maxPrice);
        }
    }

    @And("user memilih sort by {string}")
    public void user_memilih_sort_by(String sortBy) {
        if (!sortBy.isEmpty()) {
            WebElement sortByDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sortBy")));
            Select select = new Select(sortByDropdown);
            select.selectByVisibleText(sortBy);
        }
    }

    @Then("sistem mengirimkan respon {string}")
    public void sistem_mengirimkan_respon(String expectedResult) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (expectedResult.toLowerCase().contains("not found")) {
            WebElement notFoundText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(), 'Product Not Found') or contains(text(), 'Produk not Found')]")));
            assertTrue(notFoundText.isDisplayed());
        } else {
            WebElement productCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector(".product-card")));
            assertTrue(productCard.isDisplayed());
        }
    }
}
