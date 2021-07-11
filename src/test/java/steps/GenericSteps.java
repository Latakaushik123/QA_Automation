package steps;

import base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class GenericSteps {
    BaseUtil base;

    public GenericSteps(BaseUtil base) {
        this.base=base;
    }

    @Given("I open browser")
    public void openBrowser() {
        System.out.println("Browser Opened");
        base.openBrowser();

    }

    @And("I go to loginURL")
    public void navigate() {
        System.out.println("Navigate to URL");
        base.navigate();
    }
}
