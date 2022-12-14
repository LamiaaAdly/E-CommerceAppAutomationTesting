package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoggedUserCategoryPage;

public class FilterWithColorStepDefinition {
    WebDriver driver;
    LoggedUserCategoryPage lUserCategory;

    @Before
    public void user_open_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("user select colors")
    public void select_colors(){
        lUserCategory = new LoggedUserCategoryPage(driver);

        lUserCategory.selectedColor().click();
    }

    @Then("user see products with selected colors")
    public void products_selected_colors(){
        String id = lUserCategory.selectedColor().getAttribute("data-option-id");
        String expectedUrl = "https://demo.nopcommerce.com/shoes?viewmode=grid&orderby=0&pagesize=6" +
                "&specs=" + id;
        Assert.assertEquals("Products with selected colors error!",
                expectedUrl, driver.getCurrentUrl());
    }

    @After
    public void close_browser(){
        driver.quit();
    }
}
