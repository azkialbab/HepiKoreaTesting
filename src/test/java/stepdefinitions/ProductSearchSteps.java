package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.HomePage;
import org.example.ProductPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class ProductSearchSteps {

    WebDriver driver = BaseSteps.driver;
    HomePage homePage;
    ProductPage productPage;

    @Given("user berada di homepage untuk pencarian produk")
    public void user_berada_di_homepage_search() {
        homePage = new HomePage(driver);
    }

    @When("user membuka tab Product untuk pencarian")
    public void pengguna_memilih_tab_product_search() {
        homePage.clickProductTab();
        productPage = new ProductPage(driver);
    }

    @And("user memilih searchbar")
    public void user_memilih_searchbar() {
        // Optional step; can focus or clear the search bar if needed
    }

    @And("user memasukan kata kunci produk {string}")
    public void user_memasukan_kata_kunci_produk(String keyword) {
        homePage.enterSearch(keyword);
    }

    @And("user mengklik tombol Search")
    public void user_mengklik_tombol_search() {
        homePage.clickSearch();
    }

    @Then("sistem menampilkan hasil pencarian produk")
    public void sistem_menampilkan_hasil_pencarian() {
        assertTrue("Produk seharusnya ditampilkan", productPage.isProductFound());
    }

    @Then("sistem tidak menampilkan produk hasil pencarian")
    public void sistem_tidak_menampilkan_produk_apapun() {
        assertFalse("Produk tidak seharusnya ditemukan", productPage.isProductFound());
    }
}
