package steps;

import base.BaseUtil;
import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import reports.ReportsUtility;

public class Hook {
    BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
        BaseUtil.logger=LogManager.getLogger(Hook.class);

        /*System.out.print("\n-------------\n");
        BaseUtil.logger.debug("This is my debug message");
        BaseUtil.logger.info("This is an info message");
        BaseUtil.logger.error("This is a error message");
        BaseUtil.logger.warn("This is a warn message");
        BaseUtil.logger.fatal("This is a fatal message");
        System.out.print("\n-------------\n");*/

    }

    @Before
    public void Before(Scenario s) {
        /*String scNam=s.getName();
        if(scNam.)*/
        System.out.println("BeforeScenario- Creating Report instance");
        ReportsUtility.initReports(s.getName());
        System.out.println("Report Generated");
    }

    @After
    public void after(Scenario scenario) {

        System.out.println("AfterScenario- Collecting Test Result Data for "+scenario.getName());

        if(scenario.isFailed())
        {
            ReportsUtility.takeScreenShotBase64(scenario.getName());
        }
        else
        {
            ReportsUtility.passLog("Test Passed ");
        }

        base.quit();
        ReportsUtility.flushReports();
        System.out.println("Report Generated with Screenshots");
    }

    @BeforeStep
    public void BeforeStep() {
        System.out.println("BeforeStep");
    }

    @AfterStep
    public void AfterStep() {

        System.out.println("AfterStep");

    }

}
