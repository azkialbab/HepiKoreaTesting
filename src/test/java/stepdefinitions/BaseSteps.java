package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseSteps {
    public static WebDriver driver;
//    public static String baseUrl = "https://hepikorea.pad19.me";
    public static String baseUrl = "https://hk.crazyz.biz.id";

    @Given("user membuka platform HepiKorea")
    public void user_membuka_platform_hepi_korea() {
        driver.get(baseUrl+"/auth/login");

        // Tambahan: pastikan field email muncul
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
    }


    @Before
    public void setUp() {
        if (driver == null) {
            // Jika kamu sudah pakai Selenium 4.6+, tidak perlu lagi setProperty
            // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

            // Tambahkan preferensi untuk mengurangi keamanan saat testing
            var options = new org.openqa.selenium.chrome.ChromeOptions();
            options.addArguments("--disable-web-security");
            options.addArguments("--allow-running-insecure-content");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset agar scenario berikutnya bisa bikin instance baru
        }
    }
}
