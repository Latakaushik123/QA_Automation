package steps;

import base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PersonalInformationPage;
import util.UtilityFunctions;

import java.util.concurrent.TimeUnit;

public class PersonalInformation {
    PersonalInformationPage personalInfo = new PersonalInformationPage();

    @When("Update Name")
    public void updateName() throws InterruptedException {
        BaseUtil.webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        UtilityFunctions.click(personalInfo.MyAccount);
        UtilityFunctions.click(personalInfo.MyPersonalInformation);
        System.out.println("Updating First Name");
        personalInfo.FirstName.clear();
        personalInfo.FirstName.sendKeys(BaseUtil.prop.getProperty("UpdatedFirstName"));
        personalInfo.CurrentPwd.sendKeys(BaseUtil.prop.getProperty("Password"));
        UtilityFunctions.click(personalInfo.Save);
        Thread.sleep(5000);
    }
    @Then("Success Message")
    public void successMessage(){
        System.out.println(personalInfo.SuccessMessage.getText());
    }
}
