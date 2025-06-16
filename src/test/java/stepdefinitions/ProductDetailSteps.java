package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.HomePage;
import org.example.ProductPage;
import org.example.ProductDetailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.junit.Assert.*;

public class ProductDetailSteps {

    WebDriver driver = BaseSteps.driver;
    HomePage homePage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;

    WebDriverWait wait;

    @Given("user berada di halaman homepage")
    public void user_berada_di_halaman_homepage() {
        if (driver == null) {
            CommonSteps commonSteps = new CommonSteps();
            commonSteps.user_ada_di_halaman_login();
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        emailField.sendKeys("testuser@example.com");

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys("testpassword");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/form/button"));
        loginButton.click();
        wait.until(ExpectedConditions.urlContains("/home"));
        assertTrue(driver.getCurrentUrl().contains("/home"));
    }

    @When("user memilih produk bernama {string} dari homepage")
    public void user_memilih_produk_dari_homepage(String namaProduk) {
        WebElement produk = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='" + namaProduk + "']")));
        produk.click();
    }

    @When("user membuka tab Product dari navbar")
    public void user_membuka_tab_product_dari_navbar() {
        WebElement productTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav//a[normalize-space()='Product']")));
        productTab.click();
    }

    @Then("user diarahkan ke halaman daftar produk")
    public void user_diarahkan_ke_halaman_daftar_produk() {
        assertTrue(driver.getCurrentUrl().contains("/products"));
    }

    @When("user mengklik tombol Buy Produk")
    public void user_mengklik_tombol_buy_produk() {
        WebElement buyButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Buy')]")));
        buyButton.click();
    }

    @Then("user diarahkan ke halaman Detail Produk")
    public void user_diarahkan_ke_halaman_detail_produk() {
        wait.until(ExpectedConditions.urlContains("/product-detail"));
        assertTrue(driver.getCurrentUrl().contains("/product-detail"));
    }

    @And("user memilih jumlah produk yang valid")
    public void user_memilih_jumlah_produk_yang_valid() {
        WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='number']")));
        quantityField.clear();
        quantityField.sendKeys("1"); // jumlah valid
    }

    @And("user memilih jumlah produk melebihi kapasitas keranjang")
    public void user_memilih_jumlah_produk_berlebihan() {
        WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='number']")));
        quantityField.clear();
        quantityField.sendKeys("999"); // jumlah tidak valid
    }

    @And("user mengklik tombol Add to Cart")
    public void user_mengklik_tombol_add_to_cart() {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add to Cart')]")));
        addToCartButton.click();
    }

    @Then("produk disimpan dan ditampilkan di halaman Cart")
    public void produk_disimpan_dan_ditampilkan_di_cart() {
        WebElement cartTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'/cart')]")));
        cartTab.click();
        assertTrue(driver.getCurrentUrl().contains("/cart"));

        WebElement productInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Uniqlo')]")));
        assertTrue(productInCart.isDisplayed());
    }

    @Then("sistem menampilkan pesan error {string}")
    public void sistem_menampilkan_pesan_error(String pesan) {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + pesan + "')]")));
        assertTrue(error.isDisplayed());
    }
}
