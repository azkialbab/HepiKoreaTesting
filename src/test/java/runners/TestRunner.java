package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
<<<<<<< HEAD
        features = "src/main/resources/features/logoutAdmin.feature",
=======
        features = "src/main/resources/features/addFAQ.feature",
>>>>>>> origin/master
        glue = {"stepdefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports.json"
        },
        monochrome = true,
        publish = false
)
public class TestRunner {
}
