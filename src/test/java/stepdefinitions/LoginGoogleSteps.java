package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

import java.time.Duration;

public class LoginGoogleSteps {
    public static WebDriver driver = BaseSteps.driver;
    LoginPage loginPage;

    @Given("user berada di halaman login untuk Google")
    public void user_berada_di_halaman_login_untuk_google() {
        if (driver == null) {
            driver = new ChromeDriver();
            BaseSteps.driver = driver;
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://hepikorea.pad19.me/auth/login");
        loginPage = new LoginPage(driver);
    }

    @Given("user sudah berada di halaman login untuk Google")
    public void user_sudah_berada_di_halaman_login_untuk_google() {
        // Dibiarkan sama dengan langkah sebelumnya jika pakai Background
        if (driver == null) {
            driver = new ChromeDriver();
            BaseSteps.driver = driver;
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://hepikorea.pad19.me/auth/login");
        loginPage = new LoginPage(driver);
    }

    @When("user klik tombol Google Sign-In")
    public void user_klik_tombol_google_signin() {
        loginPage.clickLoginWithGoogle();
    }

    @And("user pilih akun Google {string}")
    public void user_pilih_akun_google(String email) {
        try {
            // Pindah ke window Google Sign-in
            String mainWindow = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(mainWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement accountElement = wait.until(ExpectedConditions
                    .presenceOfElementLocated(By.xpath("//div[contains(text(),'" + email + "')]")));
            accountElement.click();

            // Kembali ke window utama (jika perlu)
            driver.switchTo().window(mainWindow);

        } catch (Exception e) {
            System.out.println("Gagal memilih akun Google: " + email);
        }
    }

    @And("user konfirmasi login Google")
    public void user_konfirmasi_login_google() {
        // Biasanya redirect otomatis
    }

    @Then("user mendapatkan respon login Google {string}")
    public void user_dapatkan_respon_login_google(String expectedResult) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.urlContains("/home"),
                    ExpectedConditions.urlContains("/auth/login")
            ));
        } catch (TimeoutException ignored) {}

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL after login: " + currentUrl);

        boolean isHome = currentUrl.contains("/home") || currentUrl.equals("https://hepikorea.pad19.me/");
        boolean isLoginPage = currentUrl.contains("/auth/login");

        if (expectedResult.toLowerCase().contains("halaman homepage")) {
            assertTrue("Seharusnya diarahkan ke halaman homepage", isHome);
        } else {
            assertTrue("Seharusnya tetap di halaman login karena akun tidak ditemukan", isLoginPage);
        }

        driver.quit();
    }
}
