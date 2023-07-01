package stepdefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.devtools.v112.input.model.DragData;
import pages.BRHomePage;
import pages.BRLoginPage;
import utilities.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelStepDefs {
    BRLoginPage brLoginPage;
    BRHomePage brHomePage;

    ExcelUtils excelUtils;//Used to call Excel Utils methods
    List<Map<String,String>> dataList;//Data will be coming as List of Map and we will store them in this object
    @Given("user tries to login as {string}")
    public void user_tries_to_login_as(String sheet) {
        String path="C:\\Users\\faruk\\Downloads\\mycucumberproject\\src\\test\\resources\\testdata\\mysmoketestdata .xlsx";
        String sheetName=sheet;//sheet name
        excelUtils=new ExcelUtils(path,sheetName);//calling constructor
        dataList=excelUtils.getDataList();// get data list returns all of the data in that sheet
        for (Map<String,String> eachData : dataList) {
            Driver.getDriver().get(ConfigReader.getProperty("br_url"));
            brHomePage = new BRHomePage();
            brLoginPage = new BRLoginPage();
            WaitUtils.waitFor(1);
            brHomePage.homeLoginLink.click();//clicking home page login link to navigate login page
            WaitUtils.waitFor(1);
            brLoginPage.userEmail.sendKeys(eachData.get("username"));//WE GET THE DATA FROM EXCEL SHEET
            WaitUtils.waitFor(1);
            brLoginPage.userPass.sendKeys(eachData.get("password"));//WE GET THE DATA FROM EXCEL SHEET
            WaitUtils.waitFor(1);
            brLoginPage.loginButton.click();
            WaitUtils.waitFor(1);
            ReusableMethods.verifyElementDisplayed(brHomePage.userID);
            WaitUtils.waitFor(1);
            try {
                MediaUtils.takeScreenshotOfTheEntirePage();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            WaitUtils.waitFor(1);
            //LOGIN ID COMPLETE NOW TIME TO LOG OUT
            brHomePage.userID.click();
            WaitUtils.waitFor(1);
            brHomePage.logOut.click();
            WaitUtils.waitFor(1);
            brHomePage.OK.click();
        }
        Driver.closeDriver();
    }
    }




