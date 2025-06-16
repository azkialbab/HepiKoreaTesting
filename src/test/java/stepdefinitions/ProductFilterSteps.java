package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.HomePage;
import org.example.ProductPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class ProductFilterSteps {

    WebDriver driver = BaseSteps.driver;
    HomePage homePage;
    ProductPage productPage;

    @Given("pengguna membuka platform HepiKorea")
    public void pengguna_membuka_platform_hepi_korea() {
        BaseSteps.driver = new org.openqa.selenium.chrome.ChromeDriver();
        BaseSteps.driver.get("https://hepikorea.pad19.me");
        driver = BaseSteps.driver;
    }

    @When("pengguna memilih tab Product pada navigation bar")
    public void pengguna_memilih_tab_product_pada_navigation_bar() {
        homePage = new HomePage(driver);
        homePage.clickProductTab();
        productPage = new ProductPage(driver);
    }

    @And("user memilih kategori {string}")
    public void user_memilih_kategori(String category) {
        if (category != null && !category.trim().isEmpty()) {
            productPage.selectCategory(category);
        }
    }

    @And("user memasukan minimum price {string}")
    public void user_memasukan_minimum_price(String minPrice) {
        if (minPrice != null && !minPrice.trim().isEmpty()) {
            productPage.setMinPrice(minPrice);
        }
    }

    @And("user memasukan maximum price {string}")
    public void user_memasukan_maximum_price(String maxPrice) {
        if (maxPrice != null && !maxPrice.trim().isEmpty()) {
            productPage.setMaxPrice(maxPrice);
        }
    }

    @And("user memilih sort by {string}")
    public void user_memilih_sort_by(String sortBy) {
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
            assertFalse("Produk seharusnya tidak ditemukan", isFound);
        } else {
            assertTrue("Produk seharusnya ditampilkan", isFound);
        }

        driver.quit();
    }
}
