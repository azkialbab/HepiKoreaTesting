package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;
import java.time.Duration;

public class LoginEmailSteps {
    WebDriver driver = BaseSteps.driver;
    LoginPage loginPage;

    @When("user memasukan email {string}")
    public void user_memasukan_email(String email) {
        loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
    }

    @And("user memasukan password {string}")
    public void user_memasukan_password(String password) {
        loginPage.enterPassword(password);
    }

    @And("user mengklik tombol login di dalam halaman login")
    public void user_mengklik_tombol_login_di_dalam_halaman_login() {
        loginPage.clickLogin();
    }

    @Then("user mendapatkan respon {string}")
    public void user_mendapatkan_respon(String expectedResult) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String expectedLower = expectedResult.toLowerCase();

        boolean isStillOnLoginPage = driver.getCurrentUrl().contains("/auth/login");
        boolean isAlertPresent = false;
        String alertText = "";

        try {
            WebElement alertElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("alert-1")));
            alertText = alertElement.getText().toLowerCase().trim();
            isAlertPresent = alertElement.isDisplayed();
            System.out.println("Alert text: " + alertText);
        } catch (TimeoutException e) {
            System.out.println("No alert element found.");
        }

        if (expectedLower.contains("halaman homepage")) {
            try {
                WebElement profileImage = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//*[@id=\"app\"]/div/nav/div/div/div[1]/a/span")
                        )
                );
                assertTrue("User tidak diarahkan ke halaman utama", profileImage.isDisplayed());
            } catch (TimeoutException e) {
                fail("Elemen profil tidak ditemukan, user mungkin belum berhasil login.");
            }
        } else if (expectedLower.contains("email is not registered")) {
            assertTrue("Pesan error 'Email is not registered' tidak muncul",
                    isAlertPresent && alertText.contains("email is not registered"));
        } else if (expectedLower.contains("please fill out this field")) {
            assertTrue("Form kosong seharusnya tidak pindah halaman (masih di login)", isStillOnLoginPage);
        } else {
            fail("Respon login tidak dikenali: " + expectedResult);
        }

        driver.quit();
    }
}