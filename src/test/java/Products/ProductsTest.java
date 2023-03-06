package Products;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features" ,
        glue={"Products"} ,
        tags="@Test",
        plugin = {"pretty", "html:target/cucumber/report.html"}
)
public class ProductsTest {

}
