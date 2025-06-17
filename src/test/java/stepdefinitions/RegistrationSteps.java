package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

import java.time.Duration;

public class RegistrationSteps {

    WebDriver driver = BaseSteps.driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @And("user mengklik tombol Register")
    public void user_mengklik_tombol_register() {
        WebElement registerLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Register')]")));
        registerLink.click();
    }

    @Then("user diarahkan ke dalam halaman registrasi")
    public void user_diarahkan_ke_dalam_halaman_registrasi() {
        wait.until(ExpectedConditions.urlContains("/auth/register"));
        WebElement registerContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='app']/main/div")));
        assertTrue("Tidak diarahkan ke halaman registrasi", registerContainer.isDisplayed());
    }

    @Given("user berada di halaman registrasi")
    public void user_berada_di_halaman_registrasi() {
        wait.until(ExpectedConditions.urlContains("/auth/register"));
        assertTrue("URL bukan halaman register", driver.getCurrentUrl().contains("/auth/register"));
    }

    @When("user memasukan fullname {string}")
    public void user_memasukan_fullname(String fullname) {
        WebElement fullnameField = driver.findElement(By.xpath("//input[@placeholder='Fullname']"));
        fullnameField.clear();
        fullnameField.sendKeys(fullname);
    }

    @And("user memasukan email register {string}")
    public void user_memasukan_email_register(String email) {
        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    @And("user memasukan password register {string}")
    public void user_memasukan_password_register(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @And("user memasukan confirmed password {string}")
    public void user_memasukan_confirmed_password(String confirmPassword) {
        WebElement confirmField = driver.findElement(By.xpath("//input[@placeholder='Confirm Password']"));
        confirmField.clear();
        confirmField.sendKeys(confirmPassword);
    }

    @And("user mengklik tombol Register di dalam halaman Register")
    public void user_mengklik_tombol_register_di_dalam_halaman_register() {
        WebElement registerButton = driver.findElement(By.xpath("//button[contains(text(),'Register')]"));
        registerButton.click();
    }

    @And("user memasukkan OTP yang dikirim via email")
    public void user_memasukkan_otp_yang_dikirim_via_email() {
        try {
            WebElement otpField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@placeholder='OTP']")));
            otpField.sendKeys("123456");
            WebElement otpButton = driver.findElement(By.xpath("//button[contains(text(),'Verify')]"));
            otpButton.click();
        } catch (TimeoutException e) {
            System.out.println("Form OTP tidak muncul, mungkin tidak diperlukan.");
        }
    }

    @Then("user mendapatkan respon hasil registrasi {string}")
    public void user_mendapatkan_respon_hasil_registrasi(String expected) {
        String expectedLower = expected.toLowerCase().trim();
        boolean validationMatched = false;

        if (expectedLower.contains("save password")) {
            try {
                WebElement profileImage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id=\"app\"]/div/nav/div/div/div[1]/a/span")
                ));
                assertTrue("User tidak diarahkan ke halaman utama setelah registrasi", profileImage.isDisplayed());
                validationMatched = true;
            } catch (Exception e) {
                fail("Gagal masuk ke halaman utama setelah registrasi.");
            }
        } else {

            try {
                WebElement activeElement = driver.switchTo().activeElement();
                String validationMessage = (String) ((JavascriptExecutor) driver)
                        .executeScript("return arguments[0].validationMessage;", activeElement);
                if (validationMessage != null && validationMessage.toLowerCase().contains(expectedLower)) {
                    validationMatched = true;
                }
            } catch (Exception e) {
                System.out.println("Tidak ada validasi HTML5.");
            }

            if (!validationMatched) {
                try {
                    WebElement alert = driver.findElement(By.id("alert-1"));
                    String alertText = alert.getText().toLowerCase().trim();
                    if (alertText.contains(expectedLower)) {
                        validationMatched = true;
                    }
                } catch (Exception e) {
                    System.out.println("Alert error tidak ditemukan.");
                }
            }

            if (!validationMatched) {
                try {
                    WebElement body = driver.findElement(By.tagName("body"));
                    String bodyText = body.getText().toLowerCase();
                    if (bodyText.contains(expectedLower)) {
                        validationMatched = true;
                    }
                } catch (Exception e) {
                    System.out.println("Gagal membaca body: " + e.getMessage());
                }
            }

            assertTrue("Respon tidak sesuai dengan expected: " + expected, validationMatched);
        }
    }


}
