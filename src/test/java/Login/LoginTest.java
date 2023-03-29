package Login;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
//import cucumber.api.junit.Cucumber;
//import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/loginFeature.feature" ,
        glue={"Login"} ,
        plugin = {"pretty", "html:target/cucumber/report.html"}
)

public class LoginTest {
}
