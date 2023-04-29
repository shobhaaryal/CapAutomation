package org.example.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/CoinmarketcapAutomation.feature"},
        plugin = { "pretty", "html:target/cucumber-reports.html" },
        glue = {"org.example.stepdefinitions"}
)
public class CucumberRunner {
}
