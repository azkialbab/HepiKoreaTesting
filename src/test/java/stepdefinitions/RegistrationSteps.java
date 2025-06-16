package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class RegistrationSteps {
    WebDriver driver = BaseSteps.driver;
    RegisterPage registerPage;

    @When("user mengklik tombol login untuk register di homepage")
    public void user_mengklik_tombol_login_register_di_homepage() {
        driver.findElement(By.id("btn-login")).click();
    }

    @Then("user diarahkan ke halaman login sebelum register")
    public void user_diarahkan_ke_halaman_login_register() {
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @And("user mengklik tombol Register pada halaman login")
    public void user_mengklik_tombol_register_dari_login() {
        driver.findElement(By.id("btn-register")).click();
    }

    @Then("user diarahkan ke halaman registrasi")
    public void user_diarahkan_ke_halaman_registrasi() {
        assertTrue(driver.getCurrentUrl().contains("register"));
        registerPage = new RegisterPage(driver);
    }

    @Given("user sudah berada di halaman registrasi")
    public void user_sudah_di_halaman_registrasi() {
        assertTrue(driver.getCurrentUrl().contains("register"));
        registerPage = new RegisterPage(driver);
    }

    @When("user mengisi fullname dengan {string}")
    public void user_mengisi_fullname(String fullname) {
        registerPage.enterFullname(fullname);
    }

    @And("user mengisi email dengan {string}")
    public void user_mengisi_email(String email) {
        registerPage.enterEmail(email);
    }

    @And("user mengisi password dengan {string}")
    public void user_mengisi_password(String password) {
        registerPage.enterPassword(password);
    }

    @And("user mengisi confirmed password dengan {string}")
    public void user_mengisi_confirmed_password(String confirmPassword) {
        registerPage.enterConfirmPassword(confirmPassword);
    }

    @And("user mengklik tombol Register pada halaman registrasi")
    public void user_mengklik_register_di_form() {
        registerPage.clickRegisterButton();
    }

    @And("user memasukkan OTP yang dikirim ke email")
    public void user_masukkan_otp_email() {
        registerPage.enterOTP("123456");
    }

    @Then("user mendapatkan respon registrasi {string}")
    public void user_mendapatkan_respon_registrasi(String expectedResult) {
        boolean isSuccess = registerPage.isOnHomepage();
        if (expectedResult.contains("homepage")) {
            assertTrue("User harus diarahkan ke homepage", isSuccess);
        } else {
            assertTrue(driver.getPageSource().contains(expectedResult));
        }
        driver.quit();
    }
}
