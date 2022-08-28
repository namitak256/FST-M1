package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/features",
    glue = {"stepDefinitions"},
    tags = "@SmokeTest",
    plugin = { "pretty", "json:target/Cucumber.json" },
    //plugin = { "pretty", "html:target/cucumber-reports.html" },
    monochrome = true
)

public class ActivitiesRunner {

}
