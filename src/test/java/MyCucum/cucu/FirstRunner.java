package MyCucum.cucu;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features="FeatureFolder/Negative.feature",
		glue="MyCucum.cucu",
		//tags= {"@Saurab"},
		plugin  = {"pretty:STDOUT","html:target/HTMLCucumberReport","json:target/Cucumber.json"}
)
public class FirstRunner
{

	/*
	 * @Test public void f() {
	 * 
	 * }
	 */
}
