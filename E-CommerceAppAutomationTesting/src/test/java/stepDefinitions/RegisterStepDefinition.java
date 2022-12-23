package stepDefinitions;

import pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterStepDefinition {

    WebDriver driver =null;
    RegisterPage register;
    Logger logger;

//    @Before
//    public void user_open_browser() {
//
//        register = new RegisterPage(driver);
//    }

    @Given("user open browser")
    public void open_browser(){
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver = hooks.getDriver();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user navigates to register page")
    public void user_goto_register(){
        register = new RegisterPage(driver);
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

    @When("^user enter data \"(.*)\" , \"(.*)\" , \"(.*)\" , \"(.*)\" and \"(.*)\"$")
    public void enter_data(String fName, String lName, String email, String password, String confirmPassword) {
        register.registerSteps(fName, lName, email, password, confirmPassword);
    }

    @And("user click on register button")
    public void button_register(){
        register.confirmPassword().sendKeys(Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user go to register result page")
    public void registerResult(){
        logger = LoggerFactory.getLogger(RegisterStepDefinition.class);
        logger.info("Register Result:");
        String actualResult = register.successResult().getText();
        Assert.assertEquals("Success message Error",
                "Your registration completed",
                actualResult);
        if(actualResult.contains("Your registration completed")){
            logger.info("Register Success");
        }else logger.error("Register Fail");

    }

    @When("press continue button")
    public void press_continue(){
        register.continueButton().click();
    }

    @Then("user return to home page")
    public void go_home_success(){
        Assert.assertEquals("https://demo.nopcommerce.com/",
                driver.getCurrentUrl());
    }

//    @After
//    public void close_browser(){
//        hooks.quit();
//    }
}
