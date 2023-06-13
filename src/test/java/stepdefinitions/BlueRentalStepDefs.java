package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BRHomePage;
import pages.BRLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.WaitUtils;

public class BlueRentalStepDefs {
    BRHomePage brHomePage=new BRHomePage();
    BRLoginPage brLoginPage=new BRLoginPage();


    @Given("user clicks on home page login button")
    public void user_clicks_on_home_page_login_button() {
brHomePage.homeLoginLink.click();
    }
    @Given("enter {string} and {string}")
    public void enter_and(String string, String string2) {
brLoginPage.userEmail.sendKeys(string);
brLoginPage.userPass.sendKeys(string2);
        WaitUtils.waitFor(1);
    }

    @Given("click on login page login button")
    public void click_on_login_page_login_button() {
brLoginPage.loginButton.click();
    }
    @Then("verify the default page is visible")
    public void verify_the_default_page_is_visible() {
        //if user id is displayed then default page is visible
        ReusableMethods.verifyElementDisplayed(brHomePage.userID);
    }

    @Then("user logs out the application")
    public void userLogsOutTheApplication() {
        WaitUtils.waitFor(1);
        brHomePage.userID.click();
        WaitUtils.waitFor(1);
        brHomePage.logOut.click();
        WaitUtils.waitFor(1);
        brHomePage.OK.click();
        WaitUtils.waitFor(1);
    }
}
