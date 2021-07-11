package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict=true,
        monochrome=false,
        features = {"src/test/java/features/Login.feature",
                "src/test/java/features/Order.feature",
                "src/test/java/features/PersonalInformation.feature"
        },
        glue = {"steps"},
        plugin= {
                "html:target/site/cucumber-html",
                "json:target/cucumber1.json"}//,
        //tags= {"@CreatePortFolio"}
)
public class TestRunner {
}
