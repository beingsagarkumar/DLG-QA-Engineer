package runners;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utils.Utils;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/test/resources/features",
		glue={"stepDefinitions"},
		monochrome = true, 
		plugin = {"pretty", "html:target/cucumber-reports.html"}
		)

public class TestRunner {
	@AfterClass
	public static void tearDown() {
		WebDriver driver = Utils.getDriver();
		driver.quit();
	}
}
