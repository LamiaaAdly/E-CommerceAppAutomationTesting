package stepDefinitions;

import MyDriver.PublicDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoggedUserHomePage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddProductToWishlistStepDefinition {
    WebDriver driver;
    LoggedUserHomePage loggedUser;
    Logger logger;
    @Before
    public void user_open_browser() {
        driver = PublicDriver.getDriver();
    }

    @When("user select Add to wishlist button")
    public void addToCart_button(){
        loggedUser = new LoggedUserHomePage(driver);
        loggedUser.addToWishlist().click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user success to add selected product to wishlist")
    public void successAddingProduct(){
        logger = LoggerFactory.getLogger(AddProductToWishlistStepDefinition.class);
        logger.info("Add to wishlist Result:");

        String successMsg = loggedUser.addToWishlistSuccess().getText();
        String expectedMsgPart = "The product has been added to your ";
        String wishlistName = loggedUser.wishLink().getText();

        Assert.assertTrue("Add product to wishlist error",
                successMsg.contains(expectedMsgPart));
        Assert.assertEquals("wishlist",wishlistName);

        if(successMsg.contains(expectedMsgPart)){
            logger.info("Adding to wishlist success");
        }else logger.error("Fail adding to list!");
    }

    @After
    public void close_browser(){
//        driver.quit();
//        driver = PublicDriver.getDriver();
        PublicDriver.quit();
    }

}
