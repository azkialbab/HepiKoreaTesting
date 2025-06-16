package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.ProductPage;
import org.example.ProductPageAdmin;
import org.junit.Assert;
import org.openqa.selenium.Alert;
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
        adminPage = new ProductPageAdmin(driver);
        adminPage.clickTabProduct();
    }

    @And("admin klik tombol add produk")
    public void admin_klik_tambah_produk(){
        adminPage = new ProductPageAdmin(driver);
        adminPage.clickAddButton();
    }

    @And("admin mengisi nama produk dengan {string}")
    public void admin_isi_nama_produk(String namaProduk) {
        adminPage = new ProductPageAdmin(driver);
        adminPage.enterProductName(namaProduk);
    }

    @And("admin mengisi harga produk dengan {string}")
    public void admin_isi_harga_produk(String harga) {
        adminPage = new ProductPageAdmin(driver);
        adminPage.enterProductPrice(harga);
    }

    @And("admin memilih kategori produk {string}")
    public void admin_pilih_kategori_produk(String categoryName) {
        if (categoryName != null && !categoryName.trim().isEmpty()) {
            adminPage = new ProductPageAdmin(driver);
            adminPage.selectCategory(categoryName);
        }
    }


    @And("admin mengisi deskripsi produk {string}")
    public void admin_isi_deskripsi_produk(String deskripsi) {
        adminPage = new ProductPageAdmin(driver);
        adminPage.enterDescription(deskripsi);
    }

    @And("admin mengklik tombol Simpan")
    public void admin_klik_simpan() {
        adminPage = new ProductPageAdmin(driver);
        adminPage.clickSaveButton();
    }

    @Then("muncul pesan {string}")
    public void muncul_pesan(String expectedMessage) {
        String expectedLower = expectedMessage.toLowerCase();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[contains(text(), '" + expectedMessage + "')]")
            ));
            Assert.assertTrue("Pesan ditemukan di halaman.", message.isDisplayed());
        } catch (Exception e) {
            if (expectedLower.contains("please fill out this field")) {
                try {
                    WebElement form = driver.findElement(By.xpath("//form"));
                    boolean invalidFieldFound = false;
                    for (WebElement field : form.findElements(By.xpath(".//input | .//textarea | .//select"))) {
                        String required = field.getAttribute("required");
                        String value = field.getAttribute("value");
                        if (required != null && (value == null || value.isBlank())) {
                            invalidFieldFound = true;
                            break;
                        }
                    }
                    Assert.assertTrue("Form memiliki field required yang kosong.", invalidFieldFound);
                } catch (Exception ex) {
                    Assert.fail("Gagal mendeteksi field required yang kosong.");
                }
            } else {
                try {
                    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                    String alertText = alert.getText();
                    Assert.assertTrue("Pesan alert tidak sesuai", alertText.contains(expectedMessage));
                    alert.accept();
                } catch (Exception ex) {
                    Assert.fail("Pesan '" + expectedMessage + "' tidak muncul baik sebagai elemen halaman, alert, maupun validasi form required.");
                }
            }
        }
    }

}
