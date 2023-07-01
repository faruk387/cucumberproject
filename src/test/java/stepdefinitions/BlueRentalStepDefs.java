package stepdefinitions;

import io.cucumber.java.en.And;
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

import java.util.List;
import java.util.Map;

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

    @Given("user enters customer_email and customer_password")
    public void user_enters_customer_email_and_customer_password(io.cucumber.datatable.DataTable credentials) {
      //1.get the data as list<string>
       // List<String> customerData= credentials.row(1);
       // System.out.println(customerData); | jack@gmail.com | 12345    |
//brLoginPage.userEmail.sendKeys(customerData.get(0));//jack@gmail.com
//brLoginPage.userPass.sendKeys(customerData.get(1));//12345
  //2. List<Map<String,String>>
        List<Map<String,String>> customerData=credentials.asMaps(String.class,String.class);
        System.out.println(customerData);//[{email=jack@gmail.com},{password=12345}]
    for(Map<String,String> each: customerData){
     brLoginPage.userEmail.sendKeys(each.get("email"));
     brLoginPage.userPass.sendKeys(each.get("password"));
    }
    }
}
