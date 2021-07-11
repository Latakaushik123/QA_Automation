package pages;

import base.BaseUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
public OrderPage(){
    PageFactory.initElements(BaseUtil.webDriver, this);
}


    @FindBy(how = How.XPATH, using = "//h5[@itemprop='name']/a[@class='product-name']")
    public WebElement ProductName;

    @FindBy(how = How.XPATH, using = "//table[@id='order-list']/tbody/tr[@class='first_item ']/td[@class='history_detail footable-last-column']//span")
    public WebElement Details;

    @FindBy(how = How.XPATH, using = "//table[@class='table table-bordered']//tbody//tr[@class='item']//td[@class='bold']/label[starts-with(@for,'cb')]")
    public WebElement OrderName;

    @FindBy(how = How.XPATH, using = "//*[@id='block_top_menu']//li[3]//a[contains(text(),'T-shirts')]")
    public WebElement TShirts;

    @FindBy(how = How.XPATH, using = "//*[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line']")
    public WebElement HoverItem;

    @FindBy(how = How.XPATH, using = "//*[@class='button-container']//span[contains(text(),'Add to cart')]")
    public WebElement AddtoCart;

    @FindBy(how = How.XPATH, using = "//*[@class='button-container']//a[@title='Proceed to checkout']/span")
    public WebElement ProceedtoCheckout;

    @FindBy(how = How.XPATH, using = "//*[@class='cart_navigation clearfix']//span[contains(text(),'Proceed to checkout')]")
    public WebElement CartProceedtoCheckout;

    @FindBy(how = How.XPATH, using = "//*[@class='checker']//span/input[@type='checkbox']")
    public WebElement TermsOfService;

    @FindBy(how = How.XPATH, using = "//*[@class='cheque']")
    public WebElement PayByCheck;

    @FindBy(how = How.XPATH, using = "//*[@class='cart_navigation clearfix']//span[contains(text(),'I confirm my order')]")
    public WebElement ConfirmOrder;

    @FindBy(how = How.XPATH, using = "//*[@class='cart_navigation exclusive']/a[@title='Back to orders']")
    public WebElement BacktoOrders;

    @FindBy(how = How.XPATH, using = "//h1[@class='page-heading bottom-indent']")
    public WebElement OrderHistory;

}
