package steps;

import base.BaseUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.OrderPage;
import util.ConstantUtility;
import util.UtilityFunctions;

import java.util.concurrent.TimeUnit;

public class Order {
OrderPage orderpage = new OrderPage();
Actions actions = new Actions(BaseUtil.webDriver);

@When("Add Item to cart")
    public void orderTShirt() {
    BaseUtil.webDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    UtilityFunctions.click(orderpage.TShirts);
    System.out.println(orderpage.ProductName.getText());
    actions.moveToElement(orderpage.HoverItem).build().perform();
    UtilityFunctions.click(orderpage.AddtoCart);
    System.out.println("Product added to cart");
    UtilityFunctions.click(orderpage.ProceedtoCheckout);
    UtilityFunctions.click(orderpage.CartProceedtoCheckout);
    UtilityFunctions.click(orderpage.CartProceedtoCheckout);
    UtilityFunctions.click(orderpage.TermsOfService);
    UtilityFunctions.click(orderpage.CartProceedtoCheckout);
}
 @Then("Place the Order")
    public void PlaceOrder() throws InterruptedException {
     BaseUtil.webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    UtilityFunctions.click(orderpage.PayByCheck);
     System.out.println("Confirming Order");
    UtilityFunctions.click(orderpage.ConfirmOrder);
        UtilityFunctions.click(orderpage.BacktoOrders);
        Assert.assertEquals(ConstantUtility.OrderHistory,orderpage.OrderHistory.getText());
        System.out.println("Verifying order");
        orderpage.Details.click();
        Thread.sleep(8000);
     System.out.println(orderpage.OrderName.getText());

    }

}
