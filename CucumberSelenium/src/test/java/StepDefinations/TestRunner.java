package StepDefinations;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;  
import org.junit.runner.RunWith;   

@RunWith(Cucumber.class) 
@CucumberOptions(features="src/test/resources/Features",glue={"src/test/resources/java/StepDefinations"},
monochrome=true,
//to generate reports
//plugin = { "pretty", "html:target/reports"} -- for single format report
plugin = { "pretty", "html:target/reports", "json:target/reports/cucumber.json","junit:target/reports/cucumber.xml"} /* to get report in all formats*/
,tags="@Smoketest"
)

//monochrome is for alighnment
public class TestRunner {

}
