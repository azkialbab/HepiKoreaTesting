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
    @Given("user membuka halaman login dengan URL langsung")
    public void user_membuka_halaman_login_dengan_url_langsung() {
        if (BaseSteps.driver == null) {
            BaseSteps base = new BaseSteps();
            base.user_membuka_platform_hepikorea();
        }

        driver = BaseSteps.driver;
        loginPage = new LoginPage(driver);

        driver.get("https://hepikorea.pad19.me/auth/login");
    }



    @When("user memasukan email login {string}")
    public void user_memasukan_email_login(String email) {
        loginPage.enterEmail(email);
    }

    @And("user memasukan password login {string}")
    public void user_memasukan_password_login(String password) {
        loginPage.enterPassword(password);
    }

    @And("user mengklik tombol login di dalam halaman login")
    public void user_mengklik_tombol_login_di_dalam_halaman_login() {
        loginPage.clickLogin();
    }

    @Then("user mendapatkan respon login {string}")
    public void user_mendapatkan_respon(String expectedResult) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String currentUrl = driver.getCurrentUrl();
        boolean isStillOnLoginPage = currentUrl.contains("/auth/login");

        System.out.println("Current URL: " + currentUrl);
        System.out.println("Expected Result: " + expectedResult);

        boolean isHomePage = currentUrl.equals("https://hepikorea.pad19.me/") ||
                currentUrl.contains("/home") ||
                currentUrl.contains("/dashboard");

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
            assertTrue("User seharusnya diarahkan ke halaman homepage", isHomePage);
        } else if (expectedLower.contains("Email is not registered.")) {
            assertTrue("Pesan error 'Email is not registered.' tidak muncul", isAlertPresent && alertText.contains("email is not registered"));
        } else if (expectedLower.contains("" +
                "Please fill out this field.")) {
            assertTrue("Form kosong seharusnya tidak pindah halaman (masih di login)", isStillOnLoginPage);
        } else {
            fail("Respon login tidak sesuai ekspektasi: " + expectedResult);
        }

        driver.quit();
    }
}
