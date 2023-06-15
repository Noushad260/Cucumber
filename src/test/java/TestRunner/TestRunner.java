package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="./src/test/resources/Feature/Homepagelogin.feature",
		glue= {"StepDefination"},
		plugin= {"pretty","html:target/cucumber-report/html_report.html"}
		
		
		)

public class TestRunner  {

}