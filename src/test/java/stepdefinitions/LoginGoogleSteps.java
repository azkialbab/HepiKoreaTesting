package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.HomePage;
import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class LoginGoogleSteps {
    WebDriver driver = BaseSteps.driver;
    HomePage homePage;
    LoginPage loginPage;

    @When("user klik tombol login dari homepage untuk Google")
    public void user_klik_login_google_homepage() {
        homePage = new HomePage(driver);
        homePage.clickLogin();
    }

    @Then("user masuk ke halaman login Google")
    public void user_masuk_ke_login_google() {
        loginPage = new LoginPage(driver);
        // Optionally, add assertion here if needed
    }

    @Given("user berada di halaman login Google")
    public void user_berada_di_login_google() {
        // Sudah berada di halaman login
    }

    @When("user klik tombol Google Sign-In")
    public void user_klik_tombol_google_signin() {
        loginPage.clickLoginWithGoogle();
    }

    @And("user pilih akun Google {string}")
    public void user_pilih_akun_google(String email) {
        try {
            driver.findElement(By.xpath("//div[contains(text(),'" + email + "')]"))
                    .click();
        } catch (Exception e) {
            System.out.println("Gagal memilih akun Google: " + email);
        }
    }

    @And("user konfirmasi login Google")
    public void user_konfirmasi_login_google() {
        // Sudah diklik di langkah sebelumnya atau langsung redirect
    }

    @Then("user mendapatkan respon login Google {string}")
    public void user_dapatkan_respon_login_google(String expectedResult) {
        String currentUrl = driver.getCurrentUrl();
        boolean isHome = currentUrl.contains("/home");
        boolean isLoginPage = currentUrl.contains("/login");

        if (expectedResult.toLowerCase().contains("halaman homepage")) {
            assertTrue("Seharusnya diarahkan ke halaman homepage", isHome);
        } else {
            assertTrue("Seharusnya tetap di halaman login", isLoginPage);
        }

        driver.quit();
    }
}
