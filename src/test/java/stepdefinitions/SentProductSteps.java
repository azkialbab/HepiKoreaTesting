package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.AdminDashboardPage;
import org.example.OrderPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class SentProductSteps {
    WebDriver driver = BaseSteps.driver;
    AdminDashboardPage adminDashboardPage;
    OrderPage orderPage;

    @Given("admin telah login dan berada di dashboard untuk proses pesanan")
    public void admin_login_di_dashboard_proses() {
        adminDashboardPage = new AdminDashboardPage(driver);
        adminDashboardPage.loginAsAdmin("admin@admin.com", "123");
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @When("admin memilih tab Order pada sidebar")
    public void admin_pilih_tab_order_sidebar() {
        adminDashboardPage.clickOrderSidebar();
    }

    @When("admin memilih section Order di halaman manajemen")
    public void admin_pilih_section_order() {
        orderPage = new OrderPage(driver);
        orderPage.clickOrderSection();
    }

    @Then("admin diarahkan ke section order")
    public void admin_diarahkan_ke_section_order() {
        assertTrue(orderPage.isInOrderSection());
    }

    @When("admin memilih salah satu pesanan yang tersedia")
    public void admin_memilih_pesanan() {
        orderPage.selectAnOrder();
    }

    @When("admin klik tombol Process")
    public void admin_klik_tombol_process() {
        orderPage.clickProcess();
    }

    @When("admin isi tanggal estimasi kedatangan di Indonesia")
    public void admin_isi_estimasi_indonesia() {
        orderPage.enterEstimatedArrivalInIndonesia("2025-06-30");
    }

    @Then("status pesanan berubah menjadi process")
    public void status_menjadi_process() {
        assertEquals("Process", orderPage.getOrderStatus());
    }

    @When("admin klik tombol sent")
    public void admin_klik_tombol_sent() {
        orderPage.clickSent();
    }

    @When("admin mengisi perusahaan ekspedisi")
    public void admin_isi_ekspedisi() {
        orderPage.enterShippingCompany("JNE");
    }

    @When("admin mengisi biaya pengiriman")
    public void admin_isi_biaya_pengiriman() {
        orderPage.enterShippingCost("150000");
    }

    @When("admin mengisi kode resi pengiriman")
    public void admin_isi_kode_resi() {
        orderPage.enterTrackingCode("JNE123456");
    }

    @When("admin mengisi estimasi kedatangan ke customer")
    public void admin_isi_estimasi_ke_customer() {
        orderPage.enterEstimatedArrivalToCustomer("2025-07-05");
    }

    @Then("status pesanan berubah menjadi sent")
    public void status_menjadi_sent() {
        assertEquals("Sent", orderPage.getOrderStatus());
    }

    @Then("admin tidak menemukan pesanan di section order")
    public void tidak_ada_pesanan_ditampilkan() {
        assertTrue(orderPage.noOrderDisplayed());
    }
}
