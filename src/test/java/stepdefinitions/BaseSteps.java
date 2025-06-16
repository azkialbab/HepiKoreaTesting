package stepdefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseSteps {
    public static WebDriver driver;

    @Given("user membuka platform HepiKorea")
    public void user_membuka_platform_hepikorea() {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // ➕ Tambahkan ini agar Chrome muncul
        driver.get("https://hepikorea.pad19.me");
    }
}
