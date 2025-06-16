package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.CustomerProfilePage;
import org.example.HomePage;
import org.example.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static stepdefinitions.BaseSteps.driver;

public class LogoutCustomerSteps {
    WebDriver webDriver = driver;
    HomePage homePage;
    LoginPage loginPage;
    CustomerProfilePage customerProfilePage;

    @And("user telah berhasil login sebagai customer")
    public void user_telah_berhasil_login_sebagai_customer() {
        webDriver.get("https://hepikorea.pad19.me/auth/login");
        webDriver.findElement(By.xpath("//input[@type='email']")).sendKeys("testuser@example.com");
        webDriver.findElement(By.xpath("//input[@type='password']")).sendKeys("testpassword");
        webDriver.findElement(By.xpath("//button")).click();
        // Tunggu halaman home tampil (opsional: gunakan wait)
    }

    @When("user memilih tab Profile Picture pada navigation bar")
    public void user_memilih_tab_profile_picture() {
        homePage = new HomePage(webDriver);
        homePage.clickProfileTab(); // pastikan method ini ada di HomePage POM
    }

    @And("user memilih tab Logout pada dropdown Profile")
    public void user_memilih_tab_logout() {
        homePage.clickLogout(); // pastikan method ini ada di HomePage POM
    }

    @And("user memilih tombol confirm")
    public void user_memilih_tombol_confirm() {
        homePage.confirmLogout(); // pastikan method ini ada di HomePage POM
    }

    @Then("user akan kembali ke homepage dan menampilkan tombol login pada navigation bar")
    public void user_kembali_ke_homepage_dan_lihat_tombol_login() {
        Assert.assertTrue(webDriver.getCurrentUrl().equals("https://hepikorea.pad19.me/"));
        Assert.assertTrue(webDriver.findElement(By.cssSelector("#login-container")).isDisplayed());
    }

    @And("user memilih tombol cancel")
    public void user_memilih_tombol_cancel() {
        homePage.cancelLogout();
    }

    @Then("user tetap berada di homepage dan menampilkan profile picture pada navigation bar")
    public void user_tetap_di_homepage_dan_lihat_profile_picture() {
        Assert.assertTrue(
                webDriver.getCurrentUrl().contains("/home") ||
                        webDriver.getCurrentUrl().equals("https://hepikorea.pad19.me/")
        );
        Assert.assertTrue(webDriver.findElement(By.cssSelector("#user-profile-container button")).isDisplayed());
    }
}
