package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.HistoryPage;
import org.example.HomePage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class ReviewSteps {

    WebDriver driver = CommonSteps.driver;
    HomePage homePage = new HomePage(driver);
    HistoryPage historyPage = new HistoryPage(driver);

    @And("user memilih tab History pada dropdown Profile")
    public void user_memilih_tab_history() {
        homePage.clickHistoryTab();
    }

    @Then("user akan diarahkan ke dalam halaman Riwayat Pemesanan")
    public void user_diarahkan_ke_halaman_riwayat() {
        assertTrue(historyPage.isOnHistoryPage());
    }

    @And("user memilih section Finish")
    public void user_memilih_section_finish() {
        historyPage.clickFinishSection();
    }

    @And("user mengklik tombol Finish")
    public void user_mengklik_tombol_finish() {
        historyPage.clickFinishButton();
    }

    @And("user memilih rating produk")
    public void user_memilih_rating_produk() {
        historyPage.selectRating(5); // default bintang 5
    }

    @And("user menulis review produk")
    public void user_menulis_review_produk() {
        historyPage.enterReviewText("Produk sangat bagus dan memuaskan");
    }

    @And("user mengklik tombol Submit")
    public void user_mengklik_tombol_submit() {
        historyPage.clickSubmitReview();
    }

    @Then("rating dan review akan ditampilkan dalam produk detail produk tersebut")
    public void rating_dan_review_ditampilkan() {
        assertTrue(historyPage.isReviewDisplayed());
    }

    @Then("tidak ada pesanan yang ditampilkan")
    public void tidak_ada_pesanan_yang_ditampilkan() {
        assertTrue(historyPage.isEmptyOrderDisplayed());
    }

    @Then("user akan mendapatkan pesan error {string}")
    public void user_mendapatkan_pesan_error(String expectedMessage) {
        String actualMessage = historyPage.getErrorMessage();
        assertTrue("Expected: " + expectedMessage + ", but got: " + actualMessage,
                actualMessage.contains(expectedMessage));
    }
}
