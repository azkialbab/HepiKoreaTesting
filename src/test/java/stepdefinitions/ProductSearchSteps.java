package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.ProductPage;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static stepdefinitions.BaseSteps.driver;

public class ProductSearchSteps {

    ProductPage productPage;
    WebDriverWait wait;

    @Given("user berada di halaman produk")
    public void user_berada_di_halaman_produk() {
        driver.get("https://hepikorea.pad19.me/product");
        productPage = new ProductPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("user memilih searchbar di halaman produk")
    public void user_memilih_searchbar_di_halaman_produk() {
        productPage.focusProductSearchBar();
    }

    @And("user memasukan kata kunci produk {string} di halaman produk")
    public void user_memasukan_kata_kunci_di_halaman_produk(String keyword) {
        productPage.enterProductSearchKeyword(keyword);
    }

    @And("user mengklik tombol Search di halaman produk")
    public void user_mengklik_tombol_search_di_halaman_produk() {
        productPage.clickSearch();
    }

    @Then("sistem menampilkan hasil pencarian produk")
    public void sistem_menampilkan_hasil_pencarian_produk() {
        boolean resultsVisible = productPage.isSearchResultVisible();
        Assert.assertTrue("Produk tidak ditemukan padahal seharusnya ada", resultsVisible);
    }

    @Then("sistem tidak menampilkan produk apapun di halaman produk")
    public void sistem_tidak_menampilkan_produk_di_halaman_produk() {
        boolean noResults = productPage.isNoProductFoundMessageVisible();
        Assert.assertTrue("Seharusnya tidak ada produk yang ditampilkan", noResults);
    }
}
