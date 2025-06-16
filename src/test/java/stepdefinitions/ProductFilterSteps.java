package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class ProductFilterSteps {

    WebDriver driver = BaseSteps.driver;
    HomePage homePage;
    ProductPage productPage;

    @When("user membuka halaman filter produk")
    public void pengguna_memilih_tab_product_filter() {
        homePage = new HomePage(driver);
        homePage.clickProductTab();
        productPage = new ProductPage(driver);
    }

    @And("user memilih kategori {string}")
    public void user_memilih_kategori(String category) {
        productPage.selectCategory(category);
    }

    @And("user memasukan minimum price {string}")
    public void user_memasukan_minimum_price(String minPrice) {
        productPage.setMinPrice(minPrice);
    }

    @And("user memasukan maximum price {string}")
    public void user_memasukan_maximum_price(String maxPrice) {
        productPage.setMaxPrice(maxPrice);
    }

    @And("user memilih sort by {string}")
    public void user_memilih_sort_by(String sortBy) {
        productPage.selectSortBy(sortBy);
        productPage.applyFilter();
    }

    @Then("sistem mengirimkan respon filter {string}")
    public void sistem_mengirimkan_respon_filter(String expectedResult) {
        boolean isFound = productPage.isProductFound();
        if (expectedResult.toLowerCase().contains("not found")) {
            assertFalse("Produk seharusnya tidak ditemukan", isFound);
        } else {
            assertTrue("Produk seharusnya ditampilkan", isFound);
        }
        driver.quit();
    }
}
