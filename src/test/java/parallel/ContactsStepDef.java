package parallel;

import com.factory.DriverFactory;
import com.qa.pages.ContactPage;
import com.qa.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;

import java.util.*;

public class ContactsStepDef {

    WebDriver driver;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private ContactPage contactPage;

    @Given("User has already logged in to the application")
    public void user_Has_Already_LoggedIn_To_The_Application(DataTable credTable) throws InterruptedException {
        List<Map <String,String>> credList = credTable.asMaps();
        String userName = credList.get(0).get("userName");
        String password = credList.get(0).get("Password");
        DriverFactory.getDriver().get("https://ui.cogmento.com/");
        contactPage = loginPage.login(userName,password);
        Thread.sleep(1000);
    }

    @Given("User clicks on the create button")
    public void users_clicks_on_the_create_button() throws InterruptedException {

        contactPage.setSideBar();
        contactPage.clickCreate();
    }

    @When("User fills {string}, {string}, {string} and clicks on save button")
    public void user_fills_and_clicks_on_save_button(String firstname, String lastname, String status) throws InterruptedException {
        contactPage.enterName(firstname,lastname);
        contactPage.setRecordStatus(status);

    }
    @Then("User clicks on save button")
    public void user_Clicks_Save() throws InterruptedException {
        contactPage.clickSave();
        Thread.sleep(1000);

    }
    @And("Verify that contact having {string}, {string} details are saved successfully")
    public void verify_that_details_are_saved_successfully(String firstname, String lastname) throws InterruptedException {

        contactPage.setSideBar();
        Thread.sleep(1000);
        contactPage.clickContactMenu();
        Thread.sleep(1000);
        String userName = firstname + ' ' + lastname;
        Assert.assertTrue(contactPage.validateContactName().contains(userName));
        System.out.println("Contact is added");
    }

    @Given("User clicks on the home button")
    public void user_Clicks_On_The_HomeButton() throws InterruptedException {
        contactPage.setSideBar();
        contactPage.clickHomeBtn();
    }

    @And("Verify that contact having {string}, {string} details are displayed successfully")
    public void verify_Contact_Details_Displayed(String firstName, String lastName) {
        contactPage.ActivityBox();
        String user = firstName + ' ' + lastName;
        if (contactPage.getUserList().contains(user)){
            Assert.assertTrue(user,contactPage.getUserList().equals(user));
        }
        System.out.println("Contact is displayed on Home Page");
    }



}
