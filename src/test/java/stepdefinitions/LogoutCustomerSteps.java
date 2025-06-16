package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.CustomerProfilePage;
import org.example.HomePage;
import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class LogoutCustomerSteps {
<<<<<<< HEAD

=======
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
    WebDriver driver = BaseSteps.driver;
    HomePage homePage;
    LoginPage loginPage;
    CustomerProfilePage customerProfilePage;

<<<<<<< HEAD
    // STEP LOGIN ini sebaiknya tidak diduplikasi jika sudah ada di CommonSteps
    @And("user telah berhasil login sebagai customer")
    public void user_telah_berhasil_login_sebagai_customer() {
        homePage = new HomePage(driver);
        homePage.clickLogin();

=======
    @And("user telah berhasil login sebagai customer")
    public void user_telah_melakukan_login_sebagai_customer() {
        homePage = new HomePage(driver);
        homePage.clickLogin();
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
        loginPage = new LoginPage(driver);
        loginPage.enterEmail("customer@example.com");
        loginPage.enterPassword("test123");
        loginPage.clickLogin();
    }

<<<<<<< HEAD
    // Dihapus: @Given("user berada di homepage")
    // Sudah ada di CommonSteps.java, jadi tidak perlu ada duplikat di sini
=======
    @Given("user berada di homepage")
    public void user_berada_di_homepage() {
        assertTrue(driver.getCurrentUrl().contains("/home"));
    }
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066

    @When("user memilih tab Profile Picture pada navigation bar")
    public void user_memilih_tab_profile_picture() {
        homePage = new HomePage(driver);
        homePage.clickProfileTab();
        customerProfilePage = new CustomerProfilePage(driver);
    }

    @And("user memilih tab Logout pada dropdown Profile")
    public void user_memilih_tab_logout_dari_dropdown() {
        customerProfilePage.clickLogoutDropdown();
    }

    @And("user memilih tombol confirm")
    public void user_memilih_tombol_confirm() {
        customerProfilePage.confirmLogout();
    }

    @Then("user akan kembali ke homepage dan menampilkan tombol login pada navigation bar")
    public void user_kembali_ke_homepage_dan_lihat_tombol_login() {
        assertTrue(driver.getCurrentUrl().contains("/home"));
        assertTrue(driver.findElement(By.id("btn-login")).isDisplayed());
<<<<<<< HEAD
        // Jangan quit driver di sini, gunakan @After Hooks
=======
        driver.quit();
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
    }

    @And("user memilih tombol cancel")
    public void user_memilih_tombol_cancel() {
        customerProfilePage.cancelLogout();
    }

    @Then("user tetap berada di homepage dan menampilkan profile picture pada navigation bar")
    public void user_tetap_di_homepage_dan_lihat_profile_picture() {
        assertTrue(driver.getCurrentUrl().contains("/home"));
        assertTrue(driver.findElement(By.id("tab-profile")).isDisplayed());
<<<<<<< HEAD
        // Jangan quit driver di sini, gunakan @After Hooks
    }
}
=======
        driver.quit();
    }
}
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
