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

    @Given("user berada di halaman login")
    public void user_berada_di_halaman_login() {
        driver.get("https://hepikorea.pad19.me/auth/login");
        loginPage = new LoginPage(driver);
    }

    @When("user memasukan email {string}")
    public void user_memasukan_email(String email) {
        if (!email.isEmpty()) {
            loginPage.enterEmail(email);
        }
    }

    @And("user memasukan password {string}")
    public void user_memasukan_password(String password) {
        if (!password.isEmpty()) {
            loginPage.enterPassword(password);
        }
    }

    @And("user mengklik tombol login di dalam halaman login")
    public void user_mengklik_tombol_login_di_dalam_halaman_login() {
        loginPage.clickLogin();
    }

    @Then("user mendapatkan respon {string}")
    public void user_mendapatkan_respon(String expectedResult) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String currentUrl = driver.getCurrentUrl();
        boolean isStillOnLoginPage = currentUrl.contains("/auth/login");

        System.out.println("Current URL: " + currentUrl);
        System.out.println("Expected Result: " + expectedResult);

        boolean isHomePage = currentUrl.equals("https://hepikorea.pad19.me/") ||
                currentUrl.equals("https://hepikorea.pad19.me") ||
                currentUrl.startsWith("https://hepikorea.pad19.me/#");

        boolean isAlertPresent = false;
        String alertText = "";
        try {
            WebElement alertElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("alert-1")));
            alertText = alertElement.getText().toLowerCase().trim();
            System.out.println("Alert Text: " + alertText);
            isAlertPresent = alertElement.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("Alert not found.");
        }

        String expectedLower = expectedResult.toLowerCase();

        if (expectedLower.contains("halaman homepage")) {
            assertTrue("User seharusnya diarahkan ke halaman homepage. Tetapi URL saat ini: " + currentUrl, isHomePage);
        } else if (expectedLower.contains("email is not registered")) {
            assertTrue("Pesan error 'Email is not registered' tidak muncul. Alert: " + alertText,
                    isAlertPresent && alertText.contains("email is not registered"));
        } else if (expectedLower.contains("please fill out this field")) {
            assertTrue("Form kosong seharusnya tidak pindah halaman. Masih di halaman login?", isStillOnLoginPage);
        } else {
            fail("Respon login tidak sesuai ekspektasi: " + expectedResult);
        }

        driver.quit();
    }
}
