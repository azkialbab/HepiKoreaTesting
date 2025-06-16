package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.ProductPage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static stepdefinitions.BaseSteps.driver;

public class ProductSearchSteps {

    ProductPage productPage = new ProductPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @When("user membuka halaman product dari navbar untuk pencarian")
    public void user_membuka_halaman_product_dari_navbar_untuk_pencarian() {
        productPage.clickProductTab();
    }

    @And("user memilih searchbar")
    public void user_memilih_searchbar() {
        productPage.focusSearchBar();
    }

    @And("user memasukan kata kunci produk {string}")
    public void user_memasukan_kata_kunci(String keyword) {
        productPage.enterSearchKeyword(keyword);
    }

    @And("user mengklik tombol Search")
    public void user_mengklik_tombol_search() {
        productPage.clickSearch();
    }

    @Then("sistem menampilkan hasil pencarian")
    public void sistem_menampilkan_hasil_pencarian() {
        boolean resultsVisible = productPage.isSearchResultVisible();
        Assert.assertTrue("Produk tidak ditemukan padahal seharusnya ada", resultsVisible);
    }

    @Then("sistem tidak menampilkan produk apapun")
    public void sistem_tidak_menampilkan_produk_apapun() {
        boolean noResults = productPage.isNoProductFoundMessageVisible();
        Assert.assertTrue("Seharusnya tidak ada produk yang ditampilkan", noResults);
    }
}
