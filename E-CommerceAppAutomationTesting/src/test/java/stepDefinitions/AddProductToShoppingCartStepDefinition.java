package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoggedUserHomePage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddProductToShoppingCartStepDefinition {
    WebDriver driver;
    LoggedUserHomePage loggedUser;
    Logger logger;
//    @Before
//    public void user_open_browser() {
//        driver = hooks.getDriver();
//    }

    @When("user select Add to cart button")
    public void addToCart_button(){
        driver = hooks.getDriver();
        driver.get("https://demo.nopcommerce.com/");
        loggedUser = new LoggedUserHomePage(driver);
        loggedUser.addToCard().click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user go to product page")
    public void go_to_product_page(){
        if(driver!=null)
            Assert.assertEquals("https://demo.nopcommerce.com/apple-macbook-pro-13-inch",
                driver.getCurrentUrl());
    }
    @When("user select Add to cart button in product page")
    public void Add_to_cart_button_PP(){
        loggedUser.addToCardProductP().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user success to add selected product to Shopping cart")
    public void successAddingProduct(){
        logger = LoggerFactory.getLogger(AddProductToShoppingCartStepDefinition.class);
        logger.info("Add to Shopping cart Result:");

        String successMsg = loggedUser.addToCartSuccess().getText();
        String expectedMsgPart = "The product has been added to your ";
        String shoppingCartName = loggedUser.cartLink().getText();

        Assert.assertTrue("Add product to shopping cart error",
                successMsg.contains(expectedMsgPart));
        Assert.assertEquals("shopping cart", shoppingCartName);

        if(successMsg.contains(expectedMsgPart)){
            logger.info("Adding to shopping cart success");
        }else logger.error("Fail adding to list!");
    }

//    @After
//    public void close_browser(){
//        hooks.quit();
//    }
}
