package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.EditorHomePage;
import utilities.MediaUtils;
import utilities.ReusableMethods;
import utilities.WaitUtils;

import java.io.IOException;

public class EditorDataTablesDefs {
    EditorHomePage editorHomePage=new EditorHomePage();
    @Given("user clicks on the new button")
    public void user_clicks_on_the_new_button() {
editorHomePage.newButton.click();
    }
    @Given("user enter {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void user_enter_and_and_and_and_and_and(String string, String string2, String string3, String string4, String string5, String string6, String string7) throws IOException {
editorHomePage.firstName.sendKeys(string);
editorHomePage.lastName.sendKeys(string2);
editorHomePage.position.sendKeys(string3);
editorHomePage.office.sendKeys(string4);
editorHomePage.extention.sendKeys(string5);
editorHomePage.startDate.sendKeys(string6);
editorHomePage.salary.sendKeys(string7);
        WaitUtils.waitFor(3);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @Given("click create button")
    public void click_create_button() throws IOException {
editorHomePage.createButton.click();
WaitUtils.waitFor(3);
MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @Given("search for the {string}")
    public void search_for_the(String string) throws IOException {
        editorHomePage.searchButton.sendKeys(string);
        WaitUtils.waitFor(3);
        MediaUtils.takeScreenshotOfTheEntirePage();

    }
    @Then("verify the name field contains {string}")
    public void verify_the_name_field_contains(String string) {
        Assert.assertTrue(editorHomePage.nameField.getText().contains(string));
    }

}
