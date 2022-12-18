package stepDefinitions;

import MyDriver.PublicDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ProductTagPage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectDifferentTagsStepDefinition {

    WebDriver driver;
    ProductTagPage productTagPage;
    String ptName;
    Logger logger;
    @Before
    public void user_open_browser() {
        driver = PublicDriver.getDriver();
    }

    @Given("user go to product tags page")
    public void product_tags_page(){
        driver.get("https://demo.nopcommerce.com/producttag/all");
    }

    @When("^user select \"(.*)\" product tag$")
    public void select_product_tag(String productTagName){
        productTagPage.productTag(productTagName).click();
        ptName = productTagName;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user go to selected product tag page")
    public void selected_productTag_page(){
        logger = LoggerFactory.getLogger(SelectDifferentTagsStepDefinition.class);
        logger.info("Select Product Tag Result:");

        String expectedUrl = "https://demo.nopcommerce.com/" + ptName;

        Assert.assertEquals("Selected product tag error!",
                expectedUrl,
                driver.getCurrentUrl());

        if(expectedUrl.equals(driver.getCurrentUrl())){
            logger.info("Pass");
        }else logger.error("Fail");
    }

    @After
    public void close_browser(){
        PublicDriver.quit();
    }
}
