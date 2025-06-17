package stepdefinitions;

import io.cucumber.java.en.Then;
import org.example.HistoryPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentShipment {
    WebDriver driver = BaseSteps.driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    HistoryPage historyPage = new HistoryPage(driver);

    @Then("user mengklik pembayaran pengiriman")
    public void userMengklikPembayaranPengiriman() {
        historyPage.clickPayShipmentButton();
    }

    @Then("user mengklik bayar pengiriman")
    public void userMengklikBayarPengiriman() {
        historyPage.clickPayShipmentModalButton();
    }

    @Then("user memilih metode pembayaran pengiriman")
    public void userMemilihMetodePembayaran() {
        historyPage.clickMandiriPaymentMethod();
    }

    @Then("payment modal muncul")
    public void paymentModalMuncul() {
        Assert.assertTrue("Payment modal header tidak muncul",
                historyPage.isPaymentModalDisplayed());
    }
}
