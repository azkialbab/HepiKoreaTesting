package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class ProductDetailSteps {
    WebDriver driver = BaseSteps.driver;
    HomePage homePage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Given("user berada di halaman homepage untuk produk")
    public void user_di_homepage_produk() {
        assertTrue(driver.getCurrentUrl().contains("/home"));
        homePage = new HomePage(driver);
    }

    @When("user memilih produk bernama {string}")
    public void pilih_produk(String productName) {
        homePage.enterSearch(productName);
        homePage.clickSearch();
    }

    @And("user mengklik tombol Buy Produk")
    public void click_buy() {
        driver.findElement(By.id("btn-buy-now")).click();
    }

    @Then("user akan diarahkan ke halaman product detail")
    public void diarahkan_ke_detail() {
        assertTrue(driver.getCurrentUrl().contains("/product/detail"));
        productDetailPage = new ProductDetailPage(driver);
    }

    @And("user memilih jumlah produk di halaman detail")
    public void pilih_jumlah() {
        productDetailPage.selectQuantity("1");
    }

    @And("user mengklik tombol Add to Cart")
    public void click_add_to_cart() {
        productDetailPage.clickAddToCart();
    }

    @Then("produk disimpan dan ditampilkan di cart")
    public void produk_masuk_keranjang() {
        homePage.clickCartTab();
        assertTrue(driver.getPageSource().contains("Uniqlo"));
        driver.quit();
    }

    @When("user membuka tab Product dari navbar")
    public void klik_tab_product() {
        homePage.clickProductTab();
        productPage = new ProductPage(driver);
    }

    @Then("user masuk ke halaman daftar produk")
    public void ke_halaman_product() {
        assertTrue(driver.getCurrentUrl().contains("/product"));
    }

    @Then("produk tidak ditemukan di halaman product detail")
    public void produk_tidak_ditemukan() {
        assertFalse(driver.getCurrentUrl().contains("/product/detail"));
        driver.quit();
    }

    @Then("produk gagal ditambahkan ke cart")
    public void produk_gagal_masuk_keranjang() {
        homePage.clickCartTab();
        assertFalse(driver.getPageSource().contains("Uniqlo"));
        driver.quit();
    }

    @And("pengguna klik tab Product dari navbar")
    public void pengguna_tab_product() {
        homePage.clickProductTab();
    }
}
