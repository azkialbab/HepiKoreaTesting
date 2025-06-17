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

    // Inisialisasi WebDriverWait jika belum
    public void initWait() {
        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        }
    }

    @Given("user berada di halaman homepage")
    public void user_berada_di_halaman_homepage() {
        driver.get("https://hepikorea.pad19.me/auth/login");
        initWait();

        // Login
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@type='email']")
        ));
        emailField.sendKeys("testuser@example.com");

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys("testpassword");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/form/button"));
        loginButton.click();

        // Verifikasi logo HepiKorea muncul
        WebElement spanLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"app\"]/div/nav/div/div/div[1]/a/span")
        ));
        assertTrue(spanLogo.isDisplayed());
        System.out.println("✅ Login berhasil dan berada di homepage.");
    }

    @When("user memilih produk dari best seller")
    public void user_memilih_produk_dari_best_seller() {
        initWait();

        // Klik tombol "Buy Produk" dari produk pertama di Best Seller
        WebElement buyButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"bestSellerContainer\"]/div/div[1]/div[2]/a/button")
        ));
        buyButton.click();
    }

    @When("user membuka tab Product dari navbar")
    public void user_membuka_tab_product_dari_navbar() {
        initWait();
        WebElement productTab = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//nav//a[normalize-space()='Product']")
        ));
        productTab.click();
    }

    @Then("user diarahkan ke halaman daftar produk")
    public void user_diarahkan_ke_halaman_daftar_produk() {
        initWait();
        assertTrue(driver.getCurrentUrl().contains("/products"));
    }

    @When("user mengklik tombol Buy Produk")
    public void user_mengklik_tombol_buy_produk() {
        initWait();
        WebElement buyButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Buy')]")
        ));
        buyButton.click();
    }

    @Then("user diarahkan ke halaman Detail Produk")
    public void user_diarahkan_ke_halaman_detail_produk() {
        initWait();
        wait.until(ExpectedConditions.urlContains("/product-detail"));
        assertTrue(driver.getCurrentUrl().contains("/product-detail"));
    }

    @And("user memilih jumlah produk yang valid")
    public void user_memilih_jumlah_produk_yang_valid() {
        initWait();
        WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@type='number']")
        ));
        quantityField.clear();
        quantityField.sendKeys("1");
    }

    @And("user memilih jumlah produk melebihi kapasitas keranjang")
    public void user_memilih_jumlah_produk_berlebihan() {
        initWait();
        WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@type='number']")
        ));
        quantityField.clear();
        quantityField.sendKeys("999");
    }

    @And("user mengklik tombol Add to Cart")
    public void user_mengklik_tombol_add_to_cart() {
        initWait();
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Add to Cart')]")
        ));
        addToCartButton.click();
    }

    @Then("produk disimpan dan ditampilkan di halaman Cart")
    public void produk_disimpan_dan_ditampilkan_di_cart() {
        initWait();
        WebElement cartTab = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'/cart')]")
        ));
        cartTab.click();

        assertTrue(driver.getCurrentUrl().contains("/cart"));

        WebElement productInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td")
        ));
        assertTrue(productInCart.isDisplayed());
    }

    @Then("sistem menampilkan pesan error {string}")
    public void sistem_menampilkan_pesan_error(String pesan) {
        initWait();
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'" + pesan + "')]")
        ));
        assertTrue(error.isDisplayed());
    }
}
