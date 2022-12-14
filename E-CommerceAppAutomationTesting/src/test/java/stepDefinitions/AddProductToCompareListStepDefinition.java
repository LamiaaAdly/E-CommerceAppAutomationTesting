package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoggedUserHomePage;

public class AddProductToCompareListStepDefinition {
    WebDriver driver;
    LoggedUserHomePage loggedUser;

    @Before
    public void user_open_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("user select Add to compare list button")
    public void addToCart_button(){
        loggedUser = new LoggedUserHomePage(driver);
        loggedUser.addToCompareList().click();
    }

    @Then("user success to add selected product to compare list")
    public void successAddingProduct(){
        String successMsg = loggedUser.addToCompareListSuccess().getText();
        String expectedMsgPart = "The product has been added to your ";
        String compareName = loggedUser.compLink().getText();

        Assert.assertTrue("Add product to shopping cart error",
                successMsg.contains(expectedMsgPart));
        Assert.assertEquals("product comparison", compareName);
    }

    @After
    public void close_browser(){
        driver.quit();
    }
}
