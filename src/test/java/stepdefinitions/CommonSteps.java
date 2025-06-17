package stepdefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class CommonSteps {

    public static WebDriver driver = BaseSteps.driver;
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("user berada di homepage")
    public void user_berada_di_homepage() {
        driver.get(BaseSteps.baseUrl);
    }

    @Given("user berada di halaman login")
    public void user_berada_di_halaman_login() {
        driver = BaseSteps.driver;

        driver.get(BaseSteps.baseUrl + "/auth/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement emailInput = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']"))
            );
            assertTrue(emailInput.isDisplayed()); // Validasi bahwa elemen muncul
        } catch (Exception e) {
            throw new RuntimeException("Gagal membuka halaman login: " + e.getMessage(), e);
        }
    }

    @Given("pengguna membuka platform HepiKorea")
    public void pengguna_membuka_platform_hepi_korea() {
        // Inisialisasi browser jika belum ada
        if (driver == null) {
            driver = new ChromeDriver(); // atau sesuai setup project-mu
        }

        driver.manage().window().maximize();
        driver.get(BaseSteps.baseUrl); // ganti dengan URL sebenarnya
    }

    @Given("user login sebagai admin")
    public void user_login_sebagai_admin() {
        driver = BaseSteps.driver;

        driver.get(BaseSteps.baseUrl + "/auth/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement emailInput = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']"))
            );
            WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
            WebElement loginButton = driver.findElement(By.xpath("//*[@id='app']/main/div/form/button"));

            emailInput.clear();
            emailInput.sendKeys("admin@admin.com");

            passwordInput.clear();
            passwordInput.sendKeys("123");

            loginButton.click();

            // Tunggu hingga diarahkan ke dashboard admin
            wait.until(ExpectedConditions.urlContains("/admin"));
            assertTrue("Login admin gagal: tidak diarahkan ke halaman admin", driver.getCurrentUrl().contains("/admin"));

        } catch (Exception e) {
            throw new RuntimeException("Gagal login sebagai admin: " + e.getMessage(), e);
        }
    }

    @Given("user telah melakukan login sebagai customers")
    public void user_login_customers() {
        driver.get(BaseSteps.baseUrl + "/auth/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email']"))).sendKeys("testuser@example.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("testpassword");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        wait.until(ExpectedConditions.urlToBe(BaseSteps.baseUrl + "/"));
    }

}
