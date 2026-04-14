package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources",
        glue = {"Steps", "hooks", "Context"},
        plugin = {"pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

