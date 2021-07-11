package reports;

import base.BaseUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportsUtility {
    public static ExtentReports rep;
    public static ExtentTest feature;
    public static ExtentTest scenario;
    private static ExtentReports extent;
    public static String screenshotFolderPath;


    public static void initReports(String scenarioName) {
        rep = ExtentManager.getInstance(BaseUtil.prop.getProperty("reportPath"));
        scenario = rep.createTest(scenarioName);
        scenario.log(Status.INFO, "Starting " +scenarioName);
    }

    public static void infoLog(String msg) {
        //TODO
        scenario.log(Status.INFO, msg);
    }
    public static void reportFailure(String errMsg) {
        scenario.log(Status.FAIL, errMsg);
        takeScreenShot(errMsg);
        assertThat(false);
    }


    public static void reportFailureAPI(String errMsg,String responseValue) {
        scenario.log(Status.FAIL, errMsg);

        System.out.println(" ERROR MESSAGE FOR API : "+ errMsg);
        System.out.println(" RESPONSE VALUE FOR API : "+ responseValue);
        assertThat(false);
    }

    public static void takeScreenShot(String errMsg){
        Date d=new Date();
        String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+"_"+errMsg+"_"+".png";
        // take screenshot
        File srcFile = ((TakesScreenshot) BaseUtil.webDriver).getScreenshotAs(OutputType.FILE);
        try {
            // get the dynamic folder name
            FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath+screenshotFile));
            //put screenshot file in reports
            scenario.log(Status.FAIL,"Screenshot-> "+ scenario.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    //Take screenshot for API
    public static void takeScreenShotBase64(String errMsg){

        System.out.println("Taking Screenshots");
        String srcFile = ((TakesScreenshot) BaseUtil.webDriver).getScreenshotAs(OutputType.BASE64);

        try {
            scenario.fail("Test Failed "+errMsg, MediaEntityBuilder.createScreenCaptureFromBase64String(srcFile).build());
            System.out.println("Appending Screenshots to the Report");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }}

    //FOr screenshots in Reports
    public static void passLog(String msg) {
        //TODO
        scenario.log(Status.PASS, msg);
    }


    public static void flushReports()
    {
        if(rep!=null)
            rep.flush();
    }
}
