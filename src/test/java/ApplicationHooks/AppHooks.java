package ApplicationHooks;

import com.factory.DriverFactory;
import com.qa.util.Config;
import com.qa.util.EnumBrowser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class AppHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private Config configReader;
    Properties prop;

    @Before(order = 0)
    public void getProperty(){
        configReader = new Config();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser(){
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(EnumBrowser.valueOf(prop.getProperty("browser")));
        System.out.println(driver);
    }

    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }

    @After(order = 1)
    public void screenShot(Scenario scenario){
        String screenshotName = scenario.getName().replaceAll(" ","_");
        byte[] sourcePath =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sourcePath,"image/png",screenshotName);
    }
}
