package com.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

   // features = "src/test/resources/Login.feature",
    features="/Users/suparnapaul/Desktop/CucumberSelenium/selenium-cucumber-framework/Features/Login.feature",

    glue = "com.cucumber.stepDefinitions",

    dryRun = true,

    plugin = {
        "pretty",
        "html:target/cucumber-report.html",

        //"tech.grasshopper.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
       "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },

    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}

