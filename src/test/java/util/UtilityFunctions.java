package util;

import base.BaseUtil;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UtilityFunctions {

    public static void wait(int timeInMilliSeconds)
    {
        try {
            Thread.sleep(timeInMilliSeconds);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static String getText(WebElement element)
    {
        try {
            String s=element.getText();
            System.out.println("TEXT VALUE OF ELEMENT :" + s);
            return element.getText();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;// TODO what need to be return here
        }
    }
    public static void click(WebElement element) {

        try {
            element.click();
        }
        catch (Exception e)
        {
            System.out.println("Clicked Fail - Trying Again");
            String Exceptions = e.toString();
            System.out.println("Exception coming is "+Exceptions);
            int Start = Exceptions.indexOf(123);
            int End = Exceptions.indexOf(44);
            String Method = StringUtils.substring(Exceptions,Start,End);
            int Start1 = Method.indexOf(58);
            String locator = StringUtils.substring(Method,Start1 + 2, Method.length() - 1);
            String path = StringUtils.substring(Exceptions,End,Exceptions.length()-1);
            int colon = path.indexOf(58);
            String correctPath = StringUtils.substring(path,colon,path.length()-1);
            int bracket = correctPath.indexOf(125);
            String relativePath = StringUtils.substring(correctPath,1,bracket);
            String absolutePath = StringUtils.substring(relativePath,1,relativePath.length()-1);
            System.out.println("relativePath coming is "+relativePath);
            System.out.println("absolutePath coming is "+absolutePath);

            if (locator.equalsIgnoreCase("css selector")) {
                BaseUtil.webDriver.findElement(By.cssSelector(absolutePath)).click();
            } else if (locator.equalsIgnoreCase("xpath")) {
                System.out.println("Coming in xpath if condition");
                BaseUtil.webDriver.findElement(By.xpath(absolutePath)).click();
            } else if (locator.equalsIgnoreCase("id")) {
                BaseUtil.webDriver.findElement(By.id(absolutePath)).click();
            } else if (locator.equalsIgnoreCase("name")) {
                BaseUtil.webDriver.findElement(By.name(absolutePath)).click();
            } else if (locator.equalsIgnoreCase("class name")) {
                BaseUtil.webDriver.findElement(By.className(absolutePath)).click();
            }
            System.out.println("Different locator found");


        }
    }
}
