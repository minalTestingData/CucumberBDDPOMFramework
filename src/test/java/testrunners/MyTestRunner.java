package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/AppFeatures/PersonalInformationPage.feature"},
		glue = {"stepdefinations", "apphooks"},
		plugin = {"pretty"},
		monochrome =true
				//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				//"timeline:test-output-thread/"}		
		
		)

public class MyTestRunner {

}

