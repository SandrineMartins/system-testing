package system.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static system.helpers.Constants.CAMINHO_FEATURES;
import static system.helpers.Constants.CAMINHO_STEP_DEFINITIONS;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = CAMINHO_FEATURES,
    glue = CAMINHO_STEP_DEFINITIONS,
    tags = "@expressions",
    monochrome = false,
    plugin = {"pretty","json:target/cucumber-json/cucumber.json","junit:target/cucumber-reports/Cucumber.xml","html:target/cucumber-reports"},
    snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
}



