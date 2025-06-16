package stepdefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class CommonSteps {

    public static WebDriver driver = BaseSteps.driver;

    @Given("user ada di halaman login")
    public void user_ada_di_halaman_login() {
        if (driver == null) {
            // Jalankan langkah membuka platform untuk inisialisasi driver
            new BaseSteps().user_membuka_platform_hepikorea();
            driver = BaseSteps.driver;
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Cek apakah di halaman login, kalau iya lakukan login
        if (driver.getCurrentUrl().contains("/auth/login")) {
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
            emailInput.sendKeys("testuser@example.com");

            WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
            passwordInput.sendKeys("testpassword");

            WebElement loginButton = driver.findElement(By.xpath("//*[@id='app']/main/div/form/button"));
            loginButton.click();

            wait.until(ExpectedConditions.urlContains("/home"));
            assertTrue(driver.getCurrentUrl().contains("/home"));
        }
    }
}
