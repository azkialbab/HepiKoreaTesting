package stepdefinitions;

import io.cucumber.java.en.Given;
import org.example.LoginPage;
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
    LoginPage loginPage;

    @Given("user ada di halaman login")
    public void user_ada_di_halaman_login() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        driver.get("https://hepikorea.pad19.me/auth/login");
    }
}
