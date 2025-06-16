package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.AdminDashboardPage;
import org.example.HomePage;
import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class LogoutAdminSteps {
    WebDriver driver = BaseSteps.driver;
    HomePage homePage;
    LoginPage loginPage;
    AdminDashboardPage adminDashboardPage;

    @And("admin sudah login ke dashboard dari homepage")
    public void admin_login_dari_homepage() {
        homePage = new HomePage(driver);
        homePage.clickLogin();
        loginPage = new LoginPage(driver);
        loginPage.enterEmail("admin@admin.com");
        loginPage.enterPassword("123");
        loginPage.clickLogin();
    }

    @Given("admin berada di halaman dashboard")
    public void admin_di_dashboard() {
        adminDashboardPage = new AdminDashboardPage(driver);
        assertTrue(driver.getCurrentUrl().contains("/dashboard"));
    }

    @When("admin mengklik tombol Logout")
    public void admin_klik_logout() {
        adminDashboardPage.clickLogoutButton();
    }

    @And("admin mengkonfirmasi logout")
    public void admin_konfirmasi_logout() {
        adminDashboardPage.confirmLogout();
    }

    @Then("admin kembali ke homepage dan melihat tombol login")
    public void admin_kembali_ke_homepage() {
        assertTrue(driver.getCurrentUrl().contains("/home"));
        assertTrue(driver.findElement(By.id("btn-login")).isDisplayed());
        driver.quit();
    }

    @And("admin membatalkan logout")
    public void admin_cancel_logout() {
        adminDashboardPage.cancelLogout();
    }

    @Then("admin tetap berada di dashboard")
    public void admin_tetap_di_dashboard() {
        assertTrue(driver.getCurrentUrl().contains("/dashboard"));
        driver.quit();
    }
}
