package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.AdminDashboardPage;
import org.example.HomePage;
import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

public class LogoutAdminSteps {
    WebDriver driver = BaseSteps.driver;
    LoginPage loginPage;
    AdminDashboardPage adminDashboardPage;
    HomePage homePage;

    @Given("user telah melakukan login sebagai admin")
    public void user_telah_melakukan_login_sebagai_admin() {
        driver = BaseSteps.driver;
        loginPage = new LoginPage(driver);
        adminDashboardPage = new AdminDashboardPage(driver);

        loginPage.navigateToLoginPage(); // Pindahkan dari static ke instance
        loginPage.loginAsAdmin("admin@example.com", "passwordAdmin");
    }

    @Given("user berada di dashboard admin")
    public void user_berada_di_dashboard_admin() {
        assertTrue(adminDashboardPage.isDashboardVisible());
    }

    @When("user memilih tombol Logout")
    public void user_memilih_tombol_logout() {
        adminDashboardPage.clickLogoutButton();
    }

    @When("user memilih tombol confirm logout")
    public void user_memilih_tombol_confirm_logout() {
        adminDashboardPage.confirmLogout();
    }

    @Then("user akan kembali ke halaman homepage dan menampilkan tombol login pada navigation bar")
    public void user_akan_kembali_ke_halaman_homepage_dan_menampilkan_tombol_login_pada_navigation_bar() {
        homePage = new HomePage(driver);
        assertTrue(homePage.isLoginButtonVisible());
    }
}
