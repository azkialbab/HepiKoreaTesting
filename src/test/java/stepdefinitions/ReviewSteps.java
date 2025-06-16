package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class ReviewSteps {
    WebDriver driver = BaseSteps.driver;
    HomePage homePage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    HistoryPage historyPage;

    @Given("user berada di halaman homepage untuk review")
    public void user_di_homepage_review() {
        assertTrue(driver.getCurrentUrl().contains("/home"));
        homePage = new HomePage(driver);
    }

    @When("user mencari produk dengan nama {string}")
    public void user_mencari_produk_dengan_nama(String productName) {
        homePage.enterSearch(productName);
        homePage.clickSearch();
    }

    @And("user mengklik tombol Buy dari hasil pencarian")
    public void user_klik_buy_dari_pencarian() {
        driver.findElement(By.id("btn-buy-now")).click();
    }

    @Then("user diarahkan ke halaman detail produk untuk review")
    public void user_diarahkan_ke_detail_produk_review() {
        assertTrue(driver.getCurrentUrl().contains("/product/detail"));
        productDetailPage = new ProductDetailPage(driver);
    }

    @And("user memilih jumlah produk untuk review")
    public void user_pilih_jumlah_produk_review() {
        productDetailPage.selectQuantity("1");
    }

    @And("user mengklik tombol Add to Cart dari detail produk")
    public void user_click_add_to_cart_detail() {
        productDetailPage.clickAddToCart();
    }

    @Then("produk ditambahkan ke keranjang dari halaman review")
    public void produk_masuk_keranjang_dari_review() {
        homePage.clickCartTab();
        assertTrue(driver.getPageSource().contains("Uniqlo"));
        driver.quit();
    }

    @When("user memilih tab Produk dari navigasi")
    public void user_klik_tab_produk_navigasi() {
        homePage.clickProductTab();
        productPage = new ProductPage(driver);
    }

    @Then("user berada di halaman produk")
    public void user_di_halaman_produk() {
        assertTrue(driver.getCurrentUrl().contains("/product"));
    }

    @Then("halaman detail produk tidak ditampilkan untuk produk tidak tersedia")
    public void halaman_detail_tidak_ditampilkan() {
        assertFalse(driver.getCurrentUrl().contains("/product/detail"));
        driver.quit();
    }

    @Then("produk gagal dimasukkan ke keranjang dari halaman review")
    public void produk_gagal_ditambahkan_keranjang() {
        homePage.clickCartTab();
        assertFalse(driver.getPageSource().contains("Uniqlo"));
        driver.quit();
    }

    @And("pengguna membuka tab Produk dari navbar")
    public void pengguna_buka_tab_produk_navbar() {
        homePage.clickProductTab();
    }

    // Rating and Review Steps

    @When("user klik icon profil di navbar untuk review")
    public void user_klik_profil_review() {
        homePage.clickProfileDropdown();
    }

    @And("user klik tab History pada dropdown Profile")
    public void user_klik_history_dropdown() {
        homePage.clickHistoryTab();
        historyPage = new HistoryPage(driver);
    }

    @Then("user diarahkan ke halaman Riwayat Pesanan")
    public void user_diarahkan_ke_riwayat_pesanan() {
        assertTrue(driver.getCurrentUrl().contains("/history"));
    }

    @And("user memilih tab Finish untuk memberikan review")
    public void user_pilih_tab_finish_review() {
        historyPage.selectFinishSection();
    }

    @And("user mengklik tombol Finish untuk memberi review")
    public void user_klik_tombol_finish_review() {
        historyPage.clickFinishButton();
    }

    @And("user memberi rating produk")
    public void user_memberi_rating() {
        historyPage.selectRating("5");
    }

    @And("user menulis ulasan produk")
    public void user_menulis_review() {
        historyPage.enterReview("Produk sangat bagus dan memuaskan.");
    }

    @And("user klik tombol Submit untuk mengirim review")
    public void user_submit_review() {
        historyPage.submitReview();
    }

    @Then("rating dan review muncul di detail produk")
    public void rating_review_muncul() {
        assertTrue(historyPage.isReviewDisplayed());
        driver.quit();
    }

    @Then("tidak ada pesanan selesai yang ditampilkan")
    public void tidak_ada_pesanan_selesai() {
        assertTrue(historyPage.noOrderMessageDisplayed());
        driver.quit();
    }

    @Then("user melihat pesan error {string} saat review")
    public void error_review_ditampilkan(String message) {
        assertTrue(driver.getPageSource().contains(message));
        driver.quit();
    }
}
