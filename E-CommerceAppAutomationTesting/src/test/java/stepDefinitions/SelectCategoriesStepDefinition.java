package stepDefinitions;

import MyDriver.PublicDriver;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectCategoriesStepDefinition {
    WebDriver driver;
    LoggedUserHomePage loggedUser;
    Actions actions;
    WebElement categoryList, subCategory;
    Logger logger;

    @Before
    public void user_open_browser() {
        driver = PublicDriver.getDriver();
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

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user go to this category page")
    public void category_page(){
        logger = LoggerFactory.getLogger(SelectCategoriesStepDefinition.class);
        logger.info("Select Category Result:");

        String expecredRes = "https://demo.nopcommerce.com/" + subCategory.getText();

        Assert.assertEquals("Select Category error!",
                expecredRes, driver.getCurrentUrl());

        if(expecredRes.equals(driver.getCurrentUrl())){
            logger.info("Pass");
        }else logger.error("Fail");
    }

    @After
    public void close_browser(){
        PublicDriver.quit();
    }
}
