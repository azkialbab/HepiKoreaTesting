package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.HomePage;
import org.example.LoginPage;
import org.example.AdminDashboardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class LoginAdminSteps {

    WebDriver driver = BaseSteps.driver;
    LoginPage loginPage;
    HomePage homePage;
    AdminDashboardPage adminDashboardPage;

    @Given("user berada di halaman login untuk admin")
    public void user_berada_di_halaman_login_untuk_admin() {
        driver.get("https://hepikorea.pad19.me/auth/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
    }

    @When("user memasukan email admin {string}")
    public void user_memasukan_email(String email) {
        loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
    }

    @And("user memasukan password admin {string}")
    public void user_memasukan_password_admin(String password) {
        loginPage = new LoginPage(driver);
        loginPage.enterPassword(password);
    }

    @And("user mengklik tombol login untuk login admin")
    public void user_mengklik_tombol_login_untuk_login_admin() {
        loginPage = new LoginPage(driver);
        loginPage.clickLogin();
    }

    @Then("user mendapatkan respon login admin {string}")
    public void user_mendapatkan_respon_login_admin(String expectedResult) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        adminDashboardPage = new AdminDashboardPage(driver);

        String expectedLower = expectedResult.trim().toLowerCase();
        boolean isStillOnLoginPage = driver.getCurrentUrl().contains("/auth/login");

        boolean isAlertPresent = false;
        String alertText = "";

        try {
            WebElement alertElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("alert-1")));
            alertText = alertElement.getText().toLowerCase().trim();
            isAlertPresent = alertElement.isDisplayed();
            System.out.println("Isi alertText dari UI: " + alertText);
        } catch (TimeoutException e) {
            System.out.println("Tidak ada alert ditemukan.");
        }

        if (expectedLower.contains("dashboard admin")) {
            try {
                WebElement profileIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id=\"app\"]/nav/div/div/div[2]/div/div[1]/button/img")));
                assertTrue("Admin tidak diarahkan ke dashboard", profileIcon.isDisplayed());
            } catch (TimeoutException e) {
                fail("Elemen dashboard admin tidak ditemukan, kemungkinan login gagal.");
            }
        } else if (expectedLower.contains("email is not registered")) {
            assertTrue("Pesan error 'Email not found' tidak muncul",
                    isAlertPresent && (alertText.contains("email not found") || alertText.contains("email is not registered")));
        } else if (expectedLower.contains("please fill out this field")) {
            assertTrue("Validasi field kosong tidak bekerja", isStillOnLoginPage);
        } else {
            fail("Respon tidak dikenali: " + expectedResult + " | Isi alert: " + alertText);
        }
    }
}
