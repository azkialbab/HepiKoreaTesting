package stepdefinitions;

import io.cucumber.java.en.*;
<<<<<<< HEAD
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
=======
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
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
    }

    @When("user klik tombol Google Sign-In")
    public void user_klik_tombol_google_signin() {
        loginPage.clickLoginWithGoogle();
    }

    @And("user pilih akun Google {string}")
    public void user_pilih_akun_google(String email) {
        try {
<<<<<<< HEAD
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

=======
            driver.findElement(By.xpath("//div[contains(text(),'" + email + "')]"))
                    .click();
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
        } catch (Exception e) {
            System.out.println("Gagal memilih akun Google: " + email);
        }
    }

    @And("user konfirmasi login Google")
    public void user_konfirmasi_login_google() {
<<<<<<< HEAD
        // Biasanya redirect otomatis
=======
        // Sudah diklik di langkah sebelumnya atau langsung redirect
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
    }

    @Then("user mendapatkan respon login Google {string}")
    public void user_dapatkan_respon_login_google(String expectedResult) {
<<<<<<< HEAD
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
=======
        String currentUrl = driver.getCurrentUrl();
        boolean isHome = currentUrl.contains("/home");
        boolean isLoginPage = currentUrl.contains("/login");
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066

        if (expectedResult.toLowerCase().contains("halaman homepage")) {
            assertTrue("Seharusnya diarahkan ke halaman homepage", isHome);
        } else {
<<<<<<< HEAD
            assertTrue("Seharusnya tetap di halaman login karena akun tidak ditemukan", isLoginPage);
=======
            assertTrue("Seharusnya tetap di halaman login", isLoginPage);
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
        }

        driver.quit();
    }
}
