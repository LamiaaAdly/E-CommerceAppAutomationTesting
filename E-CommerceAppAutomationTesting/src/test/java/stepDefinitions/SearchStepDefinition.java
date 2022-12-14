package stepDefinitions;

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

public class SearchStepDefinition {

    WebDriver driver =null;
    LoggedUserHomePage loggedUser;

    @Before
    public void user_open_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        loggedUser = new LoggedUserHomePage(driver);
    }

    @When("^user write \"(.*)\" in search field$")
    public void write_product_name(String productName){
        loggedUser = new LoggedUserHomePage(driver);

        loggedUser.searchTerms().sendKeys(productName);
    }

    @And("press search button")
    public void press_search_button(){
        loggedUser.searchTerms().sendKeys(Keys.ENTER);
    }

    @Then("user find product")
    public void find_product(){
        String expectedRes = "https://demo.nopcommerce.com/search?q=Apple+MacBook";
        String actualRes = driver.getCurrentUrl();
        Assert.assertEquals("Error in search", expectedRes,actualRes);
    }

    @After
    public void close_browser(){
        driver.quit();
    }

}
