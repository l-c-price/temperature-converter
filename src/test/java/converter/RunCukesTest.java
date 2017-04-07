package converter;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

/**
 * Created by Novus_Admin on 4/7/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-htmlreport","json:target/cucumber-report.json"})
public class RunCukesTest {
}
