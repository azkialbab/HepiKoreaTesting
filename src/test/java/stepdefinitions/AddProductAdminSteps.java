package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.ProductPageAdmin;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static stepdefinitions.BaseSteps.driver;

public class AddProductAdminSteps {

    ProductPageAdmin adminPage;


    @When("admin klik tab produk")
    public void admin_klik_tab_produk() {
        adminPage.clickTabProduct();
    }

    @And("admin klik tombol add produk")
    public void admin_klik_tambah_produk(){
        adminPage.clickAddButton();
    }

    @And("admin mengisi nama produk dengan {string}")
    public void admin_isi_nama_produk(String namaProduk) {
        adminPage.enterProductName(namaProduk);
    }

    @And("admin mengisi harga produk dengan {string}")
    public void admin_isi_harga_produk(String harga) {
        adminPage.enterProductPrice(harga);
    }

    @And("admin memilih kategori produk {string}")
    public void admin_pilih_kategori_produk(String categoryName) {
        adminPage.selectCategory(categoryName);
    }

    @And("admin mengisi deskripsi produk dengan {string}")
    public void admin_isi_deskripsi_produk(String deskripsi) {
        adminPage.enterDescription(deskripsi);
    }

    @And("admin mengklik tombol Simpan")
    public void admin_klik_simpan() {
        adminPage.clickSaveButton();
    }

    @Then("produk {string} muncul dalam daftar produk")
    public void produk_muncul(String namaProduk) {
        By produkBaru = By.xpath("//div[contains(@class, 'product-card')]//h5[text()='" + namaProduk + "']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(produkBaru));
        Assert.assertTrue(productElement.isDisplayed());
    }
}
