package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        //        ADDING CONFIGURATIONS
        plugin = {
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"
        },
        features = "./src/test/resources/features",//PATH OF FEATURES FOLDER
        glue = "stepdefinitions",//PATH OF STEPDEFINITIONS FOLDER
        dryRun = false, //dryRun = true RUNS AND GENERATES ONLY MISSING STEPS DEFS WHEN
                        //dryRun=false  Run normal. this is default value
        tags = "@customer_login"
)
public class Runner {
}