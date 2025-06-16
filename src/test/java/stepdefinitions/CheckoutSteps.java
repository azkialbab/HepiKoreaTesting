package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class CheckoutSteps {
    WebDriver driver = BaseSteps.driver;
    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @And("user telah melakukan login sebagai customer")
    public void user_login_customer() {
        homePage = new HomePage(driver);
        homePage.clickLogin();
        loginPage = new LoginPage(driver);
        loginPage.enterEmail("customer@mail.com");
        loginPage.enterPassword("password");
        loginPage.clickLogin();
    }

    @Given("user berada di halaman utama setelah login")
    public void user_di_homepage_setelah_login() {
        homePage = new HomePage(driver);
    }

    @When("user memilih tab Cart pada navigation bar")
    public void user_pilih_cart_tab() {
        homePage.clickCartTab();
        cartPage = new CartPage(driver);
    }

    @Then("user akan diarahkan ke halaman keranjang")
    public void user_di_halaman_keranjang() {
        // Validasi bisa ditambahkan di sini
    }

    @And("user memilih produk yang ingin dibayar")
    public void user_pilih_produk_dibayar() {
        cartPage.selectProductToPay();
    }

    @And("user mengklik tombol Checkout pada keranjang")
    public void user_klik_checkout_cart() {
        cartPage.clickCheckout();
    }

    @Then("user akan diarahkan ke halaman checkout")
    public void user_di_halaman_checkout() {
        checkoutPage = new CheckoutPage(driver);
    }

    @And("user memilih alamat pengiriman checkout")
    public void user_pilih_alamat() {
        checkoutPage.selectAddress();
    }

    @And("user memilih jumlah produk checkout")
    public void user_pilih_jumlah_produk_checkout() {
        checkoutPage.enterQuantity("1");
    }

    @And("user memilih tombol checkout final")
    public void user_klik_final_checkout() {
        checkoutPage.clickFinalCheckout();
    }

    @And("user memilih metode pembayaran checkout")
    public void user_pilih_metode_pembayaran() {
        checkoutPage.selectPaymentMethod();
    }

    @And("user memilih tombol pay sekarang")
    public void user_klik_pay() {
        checkoutPage.clickPay();
    }

    @Then("user diarahkan ke halaman pembayaran")
    public void user_di_halaman_pembayaran() {
        // Validasi halaman pembayaran bisa ditambahkan
    }

    @When("user memilih produk di homepage untuk dibeli {string}")
    public void user_pilih_produk_dari_homepage(String productName) {
        productPage = new ProductPage(driver);
        productPage.clickBuy(productName);
    }

    @And("user mengklik tombol Buy di halaman produk")
    public void user_klik_buy_produk() {
        // Sudah dilakukan di langkah sebelumnya
    }

    @Then("user akan diarahkan ke halaman detail produk")
    public void user_di_halaman_detail_produk() {
        productDetailPage = new ProductDetailPage(driver);
    }

    @And("user memilih jumlah produk di halaman detail")
    public void user_pilih_jumlah_detail() {
        productDetailPage.selectQuantity("1");
    }

    @And("user mengklik tombol Buy Now produk")
    public void user_klik_buy_now() {
        productDetailPage.clickBuyNow();
    }

    @Then("sistem tidak mengarahkan user ke halaman checkout")
    public void user_gagal_checkout() {
        // Validasi negatif jika tidak diarahkan ke checkoutPage
    }
}
