package MyCucum.cucu;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features="FeatureFolder",
		glue="MyCucum.cucu",
		tags="@Regression",
		plugin  = {"pretty:STDOUT","html:target/HTMLCucumberReport","json:target/Cucumber.json"}
)
public class RunnerClass
{

}
