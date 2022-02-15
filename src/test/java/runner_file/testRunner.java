package runner_file;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(features = "src/test/java/Features/",
glue = {"stepdefinition_files"},
plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
monochrome = true,
dryRun = false
//dryRun = true
//tags = "@now"
)

public class testRunner {

	
}

