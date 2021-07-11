package base;

import autoitx4java.AutoItX;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.Logger;
import org.apache.xpath.operations.String;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ReportsUtility;

import java.awt.*;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseUtil {
    private WebDriver driver;
    public String name;
    public static Properties prop;
    public ExtentReports rep;
    public ExtentTest scenario;
    public static EventFiringWebDriver webDriver;
    public static boolean browserIsClosed = true;
    public static boolean isLoggedIn = false;
    public static Logger logger=null;
    JavascriptExecutor js;
    public static AutoItX autoIT;
    public static Robot robot;
    public static WebDriverWait wait;


    public BaseUtil() {


        if(prop==null) {
            try {
                prop= new Properties();
                FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\AppSettings.properties");
                prop.load(fs);

            } catch (Exception e) {
                e.printStackTrace();
                // report
            }
        }


    }

    // To open browser
    public void openBrowser() {
        if (driver == null || browserIsClosed) {

            if (prop.getProperty("Browser").equals("Chrome")) {

                System.setProperty("webdriver.chrome.driver", ".\\Resources\\chromedriver.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("useAutomationExtension", false);
                options.addArguments("test-type", "start-maximized");
                capabilities.setCapability("chrome.binary",
                        ".\\Resources\\chromedriver.exe");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,
                        true);
                options.merge(capabilities);
                driver = new ChromeDriver(options);
                try {
                    robot = new Robot();
                } catch (AWTException e) {
                    e.printStackTrace();
                }

            } else if (prop.getProperty("Browser").equals("Mozilla"))
                driver = new FirefoxDriver();
            else if (prop.getProperty("Browser").equals("IE"))
                driver = new InternetExplorerDriver();
        }

        webDriver=new EventFiringWebDriver(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    // To navigate to url
    public void navigate() {
        try {
            driver.get(prop.getProperty("Url"));
            System.out.println("Navigated to AutomationPractice site");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    // To quit browser
    public void quit() {
        try {
            ReportsUtility.flushReports();
           /* if(driver !=null) {
                driver.quit();
            } */
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
