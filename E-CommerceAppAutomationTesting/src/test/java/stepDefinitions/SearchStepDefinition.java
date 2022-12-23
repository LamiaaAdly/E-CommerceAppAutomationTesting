package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.LoggedUserHomePage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchStepDefinition {

    WebDriver driver =null;
    LoggedUserHomePage loggedUser;
    Logger logger;

//    @Before
//    public void user_open_browser() {
//        driver = hooks.getDriver();
//    }

    @When("^user write \"(.*)\" in search field$")
    public void write_product_name(String productName){
        driver = hooks.getDriver();
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

        String expectedRes = "https://demo.nopcommerce.com/search?q=Apple+MacBook+Pro+13-inch";
        String actualRes = driver.getCurrentUrl();
        Assert.assertEquals("Error in search", expectedRes,actualRes);

        if(expectedRes.equals(actualRes)){
            logger.info("Pass");
        }else logger.error("Fail");
    }

//    @After
//    public void close_browser(){
//        hooks.quit();
//    }

}
