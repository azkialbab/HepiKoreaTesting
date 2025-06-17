package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.HistoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FinishOrderSteps {
    WebDriver driver = BaseSteps.driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    HistoryPage historyPage;

    @Given("user telah melakukan login sebagai customers")
    public void user_login_customers() {
        driver.get("https://hk.crazyz.biz.id/auth/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email']"))).sendKeys("testuser@example.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("testpassword");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        wait.until(ExpectedConditions.urlToBe("https://hk.crazyz.biz.id/"));
    }

    @And("user membuka halaman sent")
    public void user_membuka_halaman_sent() {
        driver.get("https://hk.crazyz.biz.id/order/sent");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Sent')]")));
        historyPage = new HistoryPage(driver);
    }

    @Then("user mengklik confirm arrival pada order yang sudah dikirim")
    public void mencari_order_yang_sudah_dikirim() {
        historyPage.clickConfirmArrivalBtn();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Your Order Has Been Received!')]")));
    }
}
