package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ProductTagPage;

public class SelectDifferentTagsStepDefinition {

    WebDriver driver;
    ProductTagPage productTagPage;
    String ptName;
    @Before
    public void user_open_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("user go to product tags page")
    public void product_tags_page(){
        driver.get("https://demo.nopcommerce.com/producttag/all");
    }

    @When("^user select \"(.*)\" product tag$")
    public void select_product_tag(String productTagName){
        productTagPage.productTag(productTagName).click();
        ptName = productTagName;
    }

    @Then("user go to selected product tag page")
    public void selected_productTag_page(){
        String expectedUrl = "https://demo.nopcommerce.com/" + ptName;

        Assert.assertEquals("Selected product tag error!",
                expectedUrl,
                driver.getCurrentUrl());
    }

    @After
    public void close_browser(){
        driver.quit();
    }
}
