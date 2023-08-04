package parallel;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/parallel",
        glue = {"parallel"},
        monochrome = true, //display console output in readable format
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/"},
        publish = true
)
public class ParallelRun extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    public Object[][] scenario(){
        return  super.scenarios();

    }
}
