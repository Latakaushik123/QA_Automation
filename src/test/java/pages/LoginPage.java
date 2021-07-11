package pages;

import base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import steps.Order;
import util.UtilityFunctions;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using = "//a[@class='login']")
    public WebElement Login;

    @FindBy(how = How.ID, using = "email")
    public WebElement txtUserEmail;

    @FindBy(how = How.ID, using = "passwd")
    public WebElement txtPassword;

    @FindBy(how = How.ID, using = "SubmitLogin")
    public WebElement btnSignIn;
OrderPage orderPage = new OrderPage();

    public void login() {
        try {
            BaseUtil.webDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
           Login.click();
            System.out.println("Clicked on SignIn");
            txtUserEmail.sendKeys(BaseUtil.prop.getProperty("UserEmail"));
            txtPassword.sendKeys(BaseUtil.prop.getProperty("Password"));

            clickSignIn();
            if(validateLogin())
                BaseUtil.isLoggedIn=true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void clickSignIn()
    {
        try {
            UtilityFunctions.click(btnSignIn);
            UtilityFunctions.wait(4000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public boolean validateLogin() {
        boolean result=true;
        String actualResult="";
        return true;
    }

}
