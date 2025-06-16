package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/loginAdmin.feature",
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
