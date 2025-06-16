package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.HomePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static stepdefinitions.BaseSteps.driver;

public class LogoutCustomerSteps {

    HomePage homePage;

    @And("user telah berhasil login sebagai customer")
    public void user_telah_login_sebagai_customer() {
        // Misal langsung redirect ke halaman home yang sudah login, atau login manual
        driver.get("https://hepikorea.pad19.me/auth/login");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("testuser@example.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("testpassword");
        driver.findElement(By.xpath("//button")).click();
    }

    @And("user memilih tab Logout pada dropdown Profile")
    public void user_memilih_tab_logout() {
        homePage.clickLogout();
    }

    @And("user memilih tombol confirm")
    public void user_memilih_tombol_confirm() {
        homePage.confirmLogout();
    }

    @Then("user akan kembali ke homepage dan menampilkan tombol login pada navigation bar")
    public void user_kembali_ke_homepage() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://hepikorea.pad19.me/"));
        Assert.assertTrue(driver.findElement(By.cssSelector("#login-container")).isDisplayed());
    }

    @And("user memilih tombol cancel")
    public void user_memilih_tombol_cancel() {
        homePage.cancelLogout();
    }

    @Then("user tetap berada di homepage dan menampilkan profile picture pada navigation bar")
    public void user_tetap_di_homepage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/home") || driver.getCurrentUrl().equals("https://hepikorea.pad19.me/"));
        Assert.assertTrue(driver.findElement(By.cssSelector("#user-profile-container button")).isDisplayed());
    }
}
