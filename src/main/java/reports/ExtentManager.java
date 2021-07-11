package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;
    public static String screenshotFolderPath;

    //GB
    public static String projectPath = System.getProperty("user.dir");
    private static final String OUTPUT_FOLDER = projectPath + "\\Test_Report\\";


    public static ExtentReports getInstance(String reportPath) {
        if (extent == null){
            // generate report folder
            String fileName="Report.html";
            Date d = new Date();
            String folderName=d.toString().replace(":", "_");

            new File(OUTPUT_FOLDER+"//screenshots").mkdirs();
            screenshotFolderPath=OUTPUT_FOLDER+"screenshots//";
            System.out.println(OUTPUT_FOLDER+fileName+"TestReport**");
            createInstance(OUTPUT_FOLDER+fileName);




        }

        return extent;
    }

    public static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Reports");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Reports - Automation Testing");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }
}
