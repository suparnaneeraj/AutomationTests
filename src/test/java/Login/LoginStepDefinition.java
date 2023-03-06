package Login;

import Pages.LoginPage;
import Pages.ProductsPage;
import io.cucumber.java.After;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import Utility.WebDriverClass;
import io.cucumber.java.Before;

public class LoginStepDefinition {
    protected LoginPage loginpage;
    private String errormessage ="Epic sadface: Username and password do not match any user in this service";
    private WebDriverClass webDriverClass=new WebDriverClass();
    protected ProductsPage productsPage;

    @Before
    public void setUp()
    {
        webDriverClass.CreateWebDriver();

    }
    @Given("^the user is in the login page$")
    public void the_user_is_in_the_login_page() throws InterruptedException
    {
        try{
            loginpage=new LoginPage(webDriverClass.getDriver());
            Assert.assertTrue("The user is not in the Login page",loginpage.getLoginPageTitle()!="Swag Labs");

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }


    @And("^the user enters the given username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void the_user_enters_the_given_username_and_password(String username, String password)  throws InterruptedException{
        try {
            loginpage.EnterCredentials(username, password);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }


    @When("^clicks login button$")
    public void clicks_login_button() throws InterruptedException
    {
        try {
            loginpage.Login();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    @Then("^user should be logged in successfully$")
    public void user_should_be_logged_in_successfully() throws InterruptedException
    {
        try {
            productsPage=new ProductsPage(webDriverClass.getDriver());
            Assert.assertTrue("The user is not in the Products page", productsPage.getProductPageTitle() != "Products");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
    @Then("^login failed message should be displayed$")
    public void login_failed_message_should_be_displayed()
    {
        Assert.assertTrue("Login failed" , loginpage.getErrorMessage().equals(errormessage));
    }

    @After
    public void tearDown(){

        webDriverClass.getDriver().close();
    }
}
