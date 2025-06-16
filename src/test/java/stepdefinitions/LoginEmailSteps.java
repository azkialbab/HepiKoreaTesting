package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.HomePage;
import org.example.LoginPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class LoginEmailSteps {
    WebDriver driver = BaseSteps.driver;
    HomePage homePage;
    LoginPage loginPage;

    @When("user mengklik tombol login email di halaman homepage")
    public void user_klik_login_email_di_homepage() {
        homePage = new HomePage(driver);
        homePage.clickLogin();
    }

    @Then("user diarahkan ke halaman login email")
    public void user_diarahkan_ke_halaman_login_email() {
        loginPage = new LoginPage(driver);
        // Validasi URL login jika perlu
    }

    @Given("user berada di halaman login email")
    public void user_berada_di_halaman_login_email() {
        // Sudah ada di halaman login
    }

    @When("user memasukan email {string}")
    public void user_memasukkan_email(String email) {
        loginPage.enterEmail(email);
    }

    @And("user memasukan password {string}")
    public void user_memasukkan_password(String password) {
        loginPage.enterPassword(password);
    }

    @And("user mengklik tombol login email")
    public void user_klik_login_dalam_halaman_login_email() {
        loginPage.clickLogin();
    }

    @Then("user mendapatkan respon login email {string}")
    public void user_mendapatkan_respon_email(String expectedResult) {
        String currentUrl = driver.getCurrentUrl();
        boolean isHomePage = currentUrl.contains("/home");
        boolean isError = driver.getPageSource().toLowerCase().contains("error") ||
                driver.getPageSource().toLowerCase().contains("not found") ||
                driver.getPageSource().toLowerCase().contains("tidak boleh kosong");

        if (expectedResult.toLowerCase().contains("halaman homepage")) {
            assertTrue("User seharusnya berhasil login dan masuk ke halaman homepage", isHomePage);
        } else {
            assertTrue("User seharusnya mendapatkan pesan error", isError);
        }

        driver.quit();
    }
}
