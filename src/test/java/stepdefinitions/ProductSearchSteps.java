package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.ProductPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static stepdefinitions.BaseSteps.driver;

public class ProductSearchSteps {

    ProductPage productPage;
    WebDriverWait wait;

    @When("user membuka halaman product dari navbar untuk search")
    public void user_membuka_halaman_product_dari_navbar_untuk_search() {
        productPage = new ProductPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        productPage.clickProductTab();
    }

    @When("pengguna memilih tab Produk melalui homepage")
    public void pengguna_memilih_tab_Product_melalui_homepage() {
        productPage = new ProductPage(driver);
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
