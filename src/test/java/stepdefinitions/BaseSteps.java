package stepdefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BaseSteps {
    public static WebDriver driver;

    @Given("user membuka platform HepiKorea")
    public void user_membuka_platform_hepikorea() {
<<<<<<< HEAD
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
=======
        // Setup ChromeOptions
        ChromeOptions options = new ChromeOptions();
>>>>>>> origin/master

            // Nonaktifkan popup penyimpanan password
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

<<<<<<< HEAD
            // Inisialisasi driver
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        // Selalu buka URL meskipun driver sudah ada (biar tidak stuck di halaman lain)
        driver.get("https://hepikorea.pad19.me/");
=======
        // Inisialisasi WebDriver dengan opsi
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //
        driver.get("https://hepikorea.pad19.me");
>>>>>>> origin/master
    }
}
