package StepDefinition;

import com.factory.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import com.qa.pages.LoginPage;


public class LoginStepDef {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());


    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        DriverFactory.getDriver().get("https://ui.cogmento.com/");
    }
    @When("User enters {string} and {string}")
    public void user_enters_username_and_password(String userName, String password) {
        loginPage.enterEmail(userName);
        loginPage.enterPassword(password);

    }
    @And("Clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickButton();

    }
    @Then("Verify that Homepage appears")
    public void verify_that_homepage_appears() throws InterruptedException {

        Assert.assertEquals("Cogmento CRM", loginPage.validateTitle());
        System.out.println("Title verified");

    }

    @When("User enters invalid {string} and {string}")
    public void user_Enters_Invalid_Credentials(String userName, String password) {
        loginPage.enterEmail(userName);
        loginPage.enterPassword(password);
    }

    @Then("{string} message appears")
    public void messageAppears(String error) throws InterruptedException {
            Assert.assertEquals(error,loginPage.errorMsg());
            System.out.println("Error message" + loginPage.errorMsg());
    }

}
