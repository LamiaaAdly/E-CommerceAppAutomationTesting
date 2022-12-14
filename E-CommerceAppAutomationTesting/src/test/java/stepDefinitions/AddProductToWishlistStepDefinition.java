package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoggedUserHomePage;

public class AddProductToWishlistStepDefinition {
    WebDriver driver;
    LoggedUserHomePage loggedUser;

    @Before
    public void user_open_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("user select Add to wishlist button")
    public void addToCart_button(){
        loggedUser = new LoggedUserHomePage(driver);
        loggedUser.addToWishlist().click();
    }

    @Then("user success to add selected product to wishlist")
    public void successAddingProduct(){
        String successMsg = loggedUser.addToWishlistSuccess().getText();
        String expectedMsgPart = "The product has been added to your ";
        String wishlistName = loggedUser.wishLink().getText();

        Assert.assertTrue("Add product to wishlist error",
                successMsg.contains(expectedMsgPart));
        Assert.assertEquals("wishlist",wishlistName);
    }

    @After
    public void close_browser(){
        driver.quit();
    }

}
