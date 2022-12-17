package stepDefinitions;

import MyDriver.PublicDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginStepDefinition {
        WebDriver driver =null;
        LoginPage login;
        Logger logger;
        @Before
        public void user_open_browser() {
            driver = PublicDriver.getDriver();
        }

        @And("user navigates to login page")
        public void user_navigates(){
            login = new LoginPage(driver);
            driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
        }

        @When("^user enter \"(.*)\" and \"(.*)\"$")
        public void valid_data(String email, String password) {
            login.loginSteps(email, password);
        }

        @And("user click on login button")
        public void button_login(){
            login.password().sendKeys(Keys.ENTER);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //compare actual with expected result
        @Then("user go to home page")
        public void go_home_success(){
            logger = LoggerFactory.getLogger(LoginStepDefinition.class);
            logger.info("Login Result:");

            Assert.assertEquals("https://demo.nopcommerce.com/",
                    driver.getCurrentUrl());

            if(driver.getCurrentUrl() == "https://demo.nopcommerce.com/")
                logger.info("Login success");
            else logger.error("Login fail");

        }

        //compare actual with expected result
        @Then("user could not login")
        public void wrong_login(){
            String expectedResult = "Login was unsuccessful. Please correct the errors and try again.";
            String actualResult = driver.findElement(login.loginErrorMsg()).getText();

            //Assertion JUnit
            Assert.assertTrue("Error Message: Text is wrong",
                    actualResult.contains(expectedResult));
        }

//        @After
//        public void close_browser(){
//            PublicDriver.quit();
//        }
}
