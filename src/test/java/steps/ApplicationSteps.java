package steps;

import base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.LoginPage;
import reports.ReportsUtility;
import util.ConstantUtility;
import util.UtilityFunctions;

public class ApplicationSteps {

    BaseUtil base;
    LoginPage loginPage;

    public ApplicationSteps(BaseUtil baseUtil) {
        this.base=baseUtil;
        loginPage= new LoginPage(base.webDriver);
    }
    @And("I Login inside application")
    public void login() {
        UtilityFunctions.wait(4000);
        loginPage.login();
        System.out.println("Login to AutomationPractice");
    }

    @And("Exit browser")
    public void exitBrowser() {
        base.quit();
    }
}
