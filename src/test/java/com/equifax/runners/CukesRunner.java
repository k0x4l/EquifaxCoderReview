package com.equifax.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin      =   "html:target/cucumber/cucumber-report.html",
        features    =   "src\\test\\resources\\features",
        glue        =   "com\\equifax\\step_definitions",
        dryRun      =   false
)

public class CukesRunner {
}
