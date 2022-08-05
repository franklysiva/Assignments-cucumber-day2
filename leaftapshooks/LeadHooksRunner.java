package leaftapshooks;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/leaftapshooks", glue = "leaftapshooks", tags = ("@SmokeTest or @RegressionTest or @SanityTest"),
							monochrome = true, publish = true)
public class LeadHooksRunner extends AbstractTestNGCucumberTests {

}
