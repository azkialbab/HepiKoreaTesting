package stepdefinitions;

import io.cucumber.java.en.*;
<<<<<<< HEAD
import org.example.HomePage;
import org.example.ProductPage;
=======
import org.example.*;
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class ProductFilterSteps {

    WebDriver driver = BaseSteps.driver;
    HomePage homePage;
    ProductPage productPage;

<<<<<<< HEAD
    @Given("pengguna membuka platform HepiKorea")
    public void pengguna_membuka_platform_hepi_korea() {
        BaseSteps.driver = new org.openqa.selenium.chrome.ChromeDriver();
        BaseSteps.driver.get("https://hepikorea.pad19.me");
        driver = BaseSteps.driver;
    }

    @When("pengguna memilih tab Product pada navigation bar")
    public void pengguna_memilih_tab_product_pada_navigation_bar() {
=======
    @When("user membuka halaman filter produk")
    public void pengguna_memilih_tab_product_filter() {
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
        homePage = new HomePage(driver);
        homePage.clickProductTab();
        productPage = new ProductPage(driver);
    }

    @And("user memilih kategori {string}")
    public void user_memilih_kategori(String category) {
<<<<<<< HEAD
        if (category != null && !category.trim().isEmpty()) {
            productPage.selectCategory(category);
        }
=======
        productPage.selectCategory(category);
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
    }

    @And("user memasukan minimum price {string}")
    public void user_memasukan_minimum_price(String minPrice) {
<<<<<<< HEAD
        if (minPrice != null && !minPrice.trim().isEmpty()) {
            productPage.setMinPrice(minPrice);
        }
=======
        productPage.setMinPrice(minPrice);
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
    }

    @And("user memasukan maximum price {string}")
    public void user_memasukan_maximum_price(String maxPrice) {
<<<<<<< HEAD
        if (maxPrice != null && !maxPrice.trim().isEmpty()) {
            productPage.setMaxPrice(maxPrice);
        }
=======
        productPage.setMaxPrice(maxPrice);
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
    }

    @And("user memilih sort by {string}")
    public void user_memilih_sort_by(String sortBy) {
<<<<<<< HEAD
        if (sortBy != null && !sortBy.trim().isEmpty()) {
            productPage.selectSortBy(sortBy);
        }
        productPage.applyFilter();
    }

    @Then("sistem mengirimkan respon {string}")
    public void sistem_mengirimkan_respon(String expectedResult) {
        boolean isFound = productPage.isProductFound();
        String expected = expectedResult.toLowerCase();

        if (expected.contains("not found") || expected.contains("tidak")) {
=======
        productPage.selectSortBy(sortBy);
        productPage.applyFilter();
    }

    @Then("sistem mengirimkan respon filter {string}")
    public void sistem_mengirimkan_respon_filter(String expectedResult) {
        boolean isFound = productPage.isProductFound();
        if (expectedResult.toLowerCase().contains("not found")) {
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
            assertFalse("Produk seharusnya tidak ditemukan", isFound);
        } else {
            assertTrue("Produk seharusnya ditampilkan", isFound);
        }
<<<<<<< HEAD

=======
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
        driver.quit();
    }
}
