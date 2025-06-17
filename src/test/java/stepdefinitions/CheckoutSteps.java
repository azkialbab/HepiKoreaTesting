package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static stepdefinitions.BaseSteps.driver;

import java.time.Duration;

public class CheckoutSteps {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("user telah melakukan login sebagai customer")
    public void user_login_customer() {
        driver.get("https://hepikorea.pad19.me/auth/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email']"))).sendKeys("albab@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        wait.until(ExpectedConditions.urlContains("/home"));
    }

    @Given("user berada di halaman utama setelah login")
    public void user_di_halaman_utama() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
    }

    @When("user memilih tab Cart pada navigation bar")
    public void user_pilih_tab_cart() {
        WebElement cartNav = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Cart')]")));
        cartNav.click();
    }

    @Then("user akan diarahkan ke dalam halaman keranjang")
    public void user_di_halaman_keranjang() {
        wait.until(ExpectedConditions.urlContains("/cart"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart"));
    }

    @And("user memilih produk yang ingin di bayar")
    public void user_pilih_produk_checkout() {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox']")));
        checkbox.click();
    }

    @And("user mengklik tombol Checkout")
    public void user_klik_checkout_cart() {
        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Checkout')]")));
        checkoutBtn.click();
    }

    @Then("user akan diarahkan ke dalam halaman checkout")
    public void user_di_halaman_checkout() {
        wait.until(ExpectedConditions.urlContains("/checkout"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/checkout"));
    }

    @And("user memilih alamat pengiriman")
    public void user_pilih_alamat() {
        WebElement addressDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='shipping_address']")));
        addressDropdown.click();
        addressDropdown.findElement(By.xpath("//option[2]")).click(); // pilih alamat kedua
    }

    @And("user memilih jumlah produk di halaman checkout")
    public void user_pilih_jumlah_produk() {
        WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='number']")));
        quantityInput.clear();
        quantityInput.sendKeys("2");
    }

    @And("user memilih tombol checkout")
    public void user_konfirmasi_checkout() {
        WebElement confirmCheckout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Continue to Payment')]")));
        confirmCheckout.click();
    }

    @And("user memilih metode pembayaran")
    public void user_pilih_metode_pembayaran() {
        WebElement method = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='radio' and @value='bank_transfer']")));
        method.click();
    }

    @And("user memilih tombol pay")
    public void user_klik_bayar() {
        WebElement payBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Pay Now')]")));
        payBtn.click();
    }

    @Then("user diarahkan ke dalam halaman pembayaran")
    public void user_di_halaman_pembayaran() {
        wait.until(ExpectedConditions.urlContains("/payment"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/payment"));
    }

    @When("user memilih produk {string} dari homepage")
    public void user_pilih_produk_detail(String produk) {
        WebElement produkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[contains(text(),'" + produk + "')]")));
        produkElement.click();
    }

    @And("user mengklik tombol Buy")
    public void user_klik_buy() {
        WebElement buyBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Buy')]")));
        buyBtn.click();
    }

    @Then("user akan diarahkan ke dalam halaman product detail")
    public void user_di_product_detail() {
        wait.until(ExpectedConditions.urlContains("/product"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/product"));
    }

    @And("user memilih jumlah product di halaman product detail")
    public void user_input_jumlah_di_detail() {
        WebElement qty = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='number']")));
        qty.clear();
        qty.sendKeys("1");
    }

    @And("user mengklik tombol Buy Now")
    public void user_click_buy_now() {
        WebElement buyNow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Buy Now')]")));
        buyNow.click();
    }

    @Then("sistem tidak mengarahkan user ke dalam halaman checkout dengan login email {string} dan password {string}")
    public void gagal_checkout_dengan_email_dan_password(String email, String password) {
        driver.get("https://hepikorea.pad19.me/auth/login");

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email']")));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordField.sendKeys(password);

        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

        wait.until(ExpectedConditions.urlContains("/home"));
        driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox']"))).click();
        driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();

        boolean isCheckout = driver.getCurrentUrl().contains("/checkout");
        Assert.assertFalse("Seharusnya tidak masuk ke halaman checkout", isCheckout);
    }
}
