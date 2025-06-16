package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.HomePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static stepdefinitions.BaseSteps.driver;

public class LogoutCustomerSteps {
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
    WebDriver driver = BaseSteps.driver;
>>>>>>> origin/master
    HomePage homePage;

<<<<<<< HEAD
    @And("user telah berhasil login sebagai customer")
    public void user_telah_login_sebagai_customer() {
        // Misal langsung redirect ke halaman home yang sudah login, atau login manual
        driver.get("https://hepikorea.pad19.me/auth/login");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("testuser@example.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("testpassword");
        driver.findElement(By.xpath("//button")).click();
=======
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
>>>>>>> origin/master
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
<<<<<<< HEAD
    public void user_kembali_ke_homepage() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://hepikorea.pad19.me/"));
        Assert.assertTrue(driver.findElement(By.cssSelector("#login-container")).isDisplayed());
=======
    public void user_kembali_ke_homepage_dan_lihat_tombol_login() {
        assertTrue(driver.getCurrentUrl().contains("/home"));
        assertTrue(driver.findElement(By.id("btn-login")).isDisplayed());
<<<<<<< HEAD
        // Jangan quit driver di sini, gunakan @After Hooks
=======
        driver.quit();
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
>>>>>>> origin/master
    }

    @And("user memilih tombol cancel")
    public void user_memilih_tombol_cancel() {
        homePage.cancelLogout();
    }

    @Then("user tetap berada di homepage dan menampilkan profile picture pada navigation bar")
<<<<<<< HEAD
    public void user_tetap_di_homepage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/home") || driver.getCurrentUrl().equals("https://hepikorea.pad19.me/"));
        Assert.assertTrue(driver.findElement(By.cssSelector("#user-profile-container button")).isDisplayed());
    }
}
=======
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
>>>>>>> origin/master
