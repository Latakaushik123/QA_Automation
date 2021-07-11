package pages;

import base.BaseUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PersonalInformationPage {
    public PersonalInformationPage(){
        PageFactory.initElements(BaseUtil.webDriver, this);
    }
    @FindBy(how = How.XPATH, using = "//div[@class='breadcrumb clearfix']/a[2]")
    public WebElement MyAccount;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'My personal information')]")
    public WebElement MyPersonalInformation;

    @FindBy(how = How.XPATH, using = "//input[@id='firstname']")
    public WebElement FirstName;

    @FindBy(how = How.XPATH, using = "//input[@id='old_passwd']")
    public WebElement CurrentPwd;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']/span[contains(text(),'Save')]")
    public WebElement Save;

    @FindBy(how = How.XPATH, using = "//p[@class='alert alert-success']")
    public WebElement SuccessMessage;
}
