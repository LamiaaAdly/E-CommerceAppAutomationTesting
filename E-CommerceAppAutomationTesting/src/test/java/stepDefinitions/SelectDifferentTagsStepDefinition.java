package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ProductTagPage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectDifferentTagsStepDefinition {

    WebDriver driver;
    ProductTagPage productTagPage;
    Logger logger;
//    @Before
//    public void user_open_browser() {
//        driver = hooks.getDriver();
//    }

    @Given("user go to product tags page")
    public void product_tags_page(){
        driver = hooks.getDriver();
        driver.get("https://demo.nopcommerce.com/producttag/all");
    }

    @When("user select awesome product tag")
    public void select_product_tag(){
        productTagPage.productTag().click();
//        ptName = productTagName;

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

        String expectedUrl = "https://demo.nopcommerce.com/awesome";

        Assert.assertEquals("Selected product tag error!",
                expectedUrl,
                driver.getCurrentUrl());

        if(expectedUrl.equals(driver.getCurrentUrl())){
            logger.info("Pass");
        }else logger.error("Fail");
    }

//    @After
//    public void close_browser(){
//        hooks.quit();
//    }
}
