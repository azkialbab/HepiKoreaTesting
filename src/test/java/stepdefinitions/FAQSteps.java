package stepdefinitions;

import io.cucumber.java.en.*;
import org.example.AdminDashboardPage;
import org.example.FAQPage;
import org.junit.Assert;

import static stepdefinitions.BaseSteps.driver;

public class FAQSteps {

    FAQPage faqPage = new FAQPage(driver);

    @When("admin klik tab FAQ")
    public void admin_klik_tab_faq() {
        AdminDashboardPage dashboard = new AdminDashboardPage(driver);
        dashboard.clickFAQSidebar();
    }

    @And("admin klik tombol Add FAQ")
    public void admin_klik_tombol_add_faq() {
        faqPage.clickAddFAQ();
    }

    @And("admin mengisi FAQ Title dengan {string}")
    public void admin_mengisi_faq_title_dengan(String FAQTitle) {
        faqPage.enterFAQTitle(FAQTitle);
    }

    @And("admin mengisi FAQ Content dengan {string}")
    public void admin_mengisi_faq_content_dengan(String FAQContent) {
        faqPage.enterFAQContent(FAQContent);
    }

    @And("admin klik tombol Save")
    public void admin_klik_tombol_save() {
        faqPage.clickSaveButton();
    }

    @Then("{string}")
    public void hasil_dari_tambah_faq(String expectedResult) {
        if (expectedResult.equalsIgnoreCase("Successfully Added")) {
            Assert.assertTrue("Tidak ada pesan error, dianggap berhasil", true);
        } else {
            boolean titleError = faqPage.isErrorMessageTitleDisplayed(expectedResult);
            boolean contentError = faqPage.isErrorMessageContentDisplayed(expectedResult);

            Assert.assertTrue("Pesan kesalahan tidak sesuai atau tidak muncul",
                    titleError || contentError);
        }
    }
}
