package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.AdminDashboardPage;
import org.example.HomePage;
import org.example.LoginPage;
import org.example.ProductPageAdmin;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

public class LogoutAdminSteps {

    WebDriver driver = BaseSteps.driver;
    LoginPage loginPage;
    AdminDashboardPage adminDashboardPage;
    HomePage homePage;

    @Given("user telah login sebagai admin")
    public void user_telah_login_sebagai_admin() {
        driver = BaseSteps.driver;

        loginPage = new LoginPage(driver);
        adminDashboardPage = new AdminDashboardPage(driver);

        // Akses halaman login dan login sebagai admin
        loginPage.navigateToLoginPage();
        loginPage.loginAsAdmin("admin@example.com", "passwordAdmin");

        // Validasi admin sudah masuk dashboard
        assertTrue("Dashboard admin tidak terlihat", adminDashboardPage.isDashboardVisible());
    }
    @Given("user berada di dashboard admin")
    public void user_berada_di_dashboard_admin() {
        adminDashboardPage = new AdminDashboardPage(driver);
        assertTrue("Dashboard admin tidak terlihat", adminDashboardPage.isDashboardVisible());
    }


    @When("user memilih tombol logout")
    public void user_memilih_tombol_logout() {
        adminDashboardPage.clickProfileIcon();
        adminDashboardPage.clickLogoutButton();
    }

//    @And("user mengkonfirmasi logout")
//    public void user_mengkonfirmasi_logout() {
//        adminDashboardPage.confirmLogout();
//    }

    @Then("user diarahkan ke homepage dan tombol login terlihat")
    public void user_diarahkan_ke_homepage_dan_tombol_login_terlihat() {
        homePage = new HomePage(driver);
        assertTrue("Tombol login tidak terlihat setelah logout", homePage.isNavbarVisible());
    }

//    @Then("user akan tetap berada di halaman dashboard admin")
//    public void user_akan_tetap_berada_di_halaman_dashboard_admin() {
//        assertTrue("Dashboard admin tidak terlihat (ikon profil tidak muncul)", adminDashboardPage.isProfileIconVisible());
//    }


}
