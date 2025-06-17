package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.LoginPage;
import org.example.RegisterPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class RegistrationSteps {
    public static WebDriver driver = BaseSteps.driver;
    LoginPage loginPage;
    RegisterPage registerPage;


    @And("user mengklik tombol Register")
    public void user_mengklik_tombol_register() {
        loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();
    }

    @Then("user diarahkan ke dalam halaman registrasi")
    public void user_diarahkan_ke_dalam_halaman_registrasi() {
        String url = driver.getCurrentUrl();
        assertTrue("Tidak diarahkan ke halaman register", url.contains("/auth/register"));
    }

    @Given("user berada di halaman registrasi")
    public void user_berada_di_halaman_registrasi() {
        registerPage = new RegisterPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @When("user memasukan fullname {string}")
    public void user_memasukan_fullname(String fullname) {
        registerPage = new RegisterPage(driver);
        registerPage.enterFullname(fullname);
    }

    @And("user memasukan email register {string}")
    public void user_memasukan_email_register(String email) {
        registerPage = new RegisterPage(driver);
        registerPage.enterEmail(email);
    }

    @And("user memasukan password register {string}")
    public void user_memasukan_password_register(String password) {
        registerPage = new RegisterPage(driver);
        registerPage.enterPassword(password);
    }

    @And("user memasukan confirmed password {string}")
    public void user_memasukan_confirmed_password(String confirmPassword) {
        registerPage = new RegisterPage(driver);
        registerPage.enterConfirmPassword(confirmPassword);
    }

    @And("user mengklik tombol Register di dalam halaman Register")
    public void user_mengklik_tombol_register_di_dalam_halaman_register() {
        registerPage = new RegisterPage(driver);
        registerPage.clickRegisterButton();
    }

    @And("user memasukkan OTP yang dikirim via email")
    public void user_memasukkan_otp_yang_dikirim_via_email() {
        System.out.println("OTP dikirim via email (dummy step)");
    }

    @Then("user mendapatkan respon hasil registrasi {string}")
    public void user_mendapatkan_respon_hasil_registrasi(String expectedResult) {
        String currentUrl = driver.getCurrentUrl();
        if (expectedResult.contains("halaman homepage")) {
            assertTrue("User tidak diarahkan ke homepage", currentUrl.contains("/home") || currentUrl.equals("https://hepikorea.pad19.me/"));
        } else {
            String pageSource = driver.getPageSource();
            assertTrue("Pesan error tidak ditemukan", pageSource.toLowerCase().contains(expectedResult.toLowerCase()));
        }
        driver.quit();
    }
}
