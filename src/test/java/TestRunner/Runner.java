package TestRunner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import StepDefinition.CucumberRunner;


@RunWith(CucumberRunner.class)
@CucumberOptions(
        features="Features",
        glue={"StepDefinition"},
        plugin = {
                "pretty",
                "html:target/cucumber"
        }
)
public class Runner {
}
