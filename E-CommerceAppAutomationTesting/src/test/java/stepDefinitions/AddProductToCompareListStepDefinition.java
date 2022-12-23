package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoggedUserHomePage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddProductToCompareListStepDefinition {
    WebDriver driver;
    LoggedUserHomePage loggedUser;
    Logger logger;
//    @Before
//    public void user_open_browser() {
//        driver = hooks.getDriver();
//    }

    @When("user select Add to compare list button")
    public void addToComp_button(){
        driver = hooks.getDriver();
        driver.get("https://demo.nopcommerce.com/");
        loggedUser = new LoggedUserHomePage(driver);
        loggedUser.addToCompareList().click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user success to add selected product to compare list")
    public void successAddingProduct(){
        logger = LoggerFactory.getLogger(AddProductToCompareListStepDefinition.class);
        logger.info("Add to compare list Result:");

        String successMsg = loggedUser.addToCompareListSuccess().getText();
        String expectedMsgPart = "The product has been added to your ";
        String compareName = loggedUser.compLink().getText();

        Assert.assertTrue("Add product to shopping cart error",
                successMsg.contains(expectedMsgPart));
        Assert.assertEquals("product comparison", compareName);

        if(successMsg.contains(expectedMsgPart)){
            logger.info("Adding to compare list success");
        }else logger.error("Fail adding to list!");
    }

//    @After
//    public void close_browser(){
//        hooks.quit();
//    }
}
