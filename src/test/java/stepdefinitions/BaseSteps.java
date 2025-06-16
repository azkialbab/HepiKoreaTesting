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
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();

            // Nonaktifkan popup penyimpanan password
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            // Inisialisasi driver
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        // Selalu buka URL meskipun driver sudah ada (biar tidak stuck di halaman lain)
        driver.get("https://hepikorea.pad19.me/");
    }
}
