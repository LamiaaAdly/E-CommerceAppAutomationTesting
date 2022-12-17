package stepDefinitions;

import MyDriver.PublicDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoggedUserHomePage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchStepDefinition {

    WebDriver driver =null;
    LoggedUserHomePage loggedUser;
    Logger logger;

    @Before
    public void user_open_browser() {
        driver = PublicDriver.getDriver();
    }

    @When("^user write \"(.*)\" in search field$")
    public void write_product_name(String productName){
        loggedUser = new LoggedUserHomePage(driver);

        loggedUser.searchTerms().sendKeys(productName);
    }

    @And("press search button")
    public void press_search_button(){
        loggedUser.searchTerms().sendKeys(Keys.ENTER);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user find product")
    public void find_product(){
        logger = LoggerFactory.getLogger(SearchStepDefinition.class);
        logger.info("Search Result:");

        String expectedRes = "https://demo.nopcommerce.com/search?q=Apple+MacBook";
        String actualRes = driver.getCurrentUrl();
        Assert.assertEquals("Error in search", expectedRes,actualRes);

        if(expectedRes == actualRes){
            logger.info("Pass");
        }else logger.error("Fail");
    }

    @After
    public void close_browser(){
        PublicDriver.quit();
    }

}
