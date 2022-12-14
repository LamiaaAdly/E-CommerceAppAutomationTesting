package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.LoggedUserHomePage;

public class SelectCategoriesStepDefinition {
    WebDriver driver;
    LoggedUserHomePage loggedUser;
    Actions actions;
    WebElement categoryList, subCategory;

    @Before
    public void user_open_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("^user hover to \"(.*)\"$")
    public void user_hover(String categoryName){
        loggedUser = new LoggedUserHomePage(driver);

        categoryList = loggedUser.categoryList(categoryName);
        actions = new Actions(driver);
        actions.moveToElement(categoryList);
    }

    @And("^user select \"(.*)\"$")
    public void user_select(String subCategoryName){
        subCategory = loggedUser.subCategory(subCategoryName);
        actions.moveToElement(subCategory);

        actions.click().build().perform();
    }

    @Then("user go to this category page")
    public void category_page(){
        Assert.assertEquals("Select Category error!",
                "https://demo.nopcommerce.com/" + subCategory.getText(),
                driver.getCurrentUrl());
    }

    @After
    public void close_browser(){
        driver.quit();
    }
}
