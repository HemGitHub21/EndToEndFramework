package runnerfile;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features ="src/test/resources/Featurefiles",
		glue = {"stepdefinitions"},
		tags = {"@smoke"},
		format = {
				 "pretty",
				 "html:target/cucumber-reports/cucumber-pretty",
				 "json:target/cucumber-reports/CucumberTestReport.json",
				 "rerun:target/cucumber-reports/rerun.txt"
		}, plugin = "json"target/cucumber-reports/CucumberTestReport.json")

		
public class TestRunner {

			private TestNGCucumberRunner testNGCucumberRunner;
			
			@BeforeClass(alwaysRun= true)
			public void setupClass() throws Exception {
				testNGCucumberRunner = new TestNGCucumberRunner (this.getClass());
			}
			
			@Test(groups= "cucumber" , description = "Runs Cucumber Feature", dataprovider = "features")
			public void feature (CucumberFeatureWrapper cucumberFeature)
			{
				testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
			}
			
			@DataProvider
			public Object[][] features() {
				return testNGCucumberRunner.provideFeatures();
			}
			}
}
