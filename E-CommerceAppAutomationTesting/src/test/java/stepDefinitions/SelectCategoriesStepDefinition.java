package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

//    @Before
//    public void user_open_browser() {
//        driver = hooks.getDriver();
//    }

    @When("user hover to Computers")
    public void user_hover(){
        driver = hooks.getDriver();
        driver.get("https://demo.nopcommerce.com/");
        loggedUser = new LoggedUserHomePage(driver);

        categoryList = loggedUser.categoryList();
        actions = new Actions(driver);
        actions.moveToElement(categoryList);
    }

    @And("user select Notebooks")
    public void user_select(){
        subCategory = loggedUser.subCategory();
        actions.moveToElement(subCategory);

        actions.click().build().perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user go to Notebooks category page")
    public void category_page(){
        logger = LoggerFactory.getLogger(SelectCategoriesStepDefinition.class);
        logger.info("Select Category Result:");

        String expecredRes = "https://demo.nopcommerce.com/notebooks";

        Assert.assertEquals("Select Category error!",
                expecredRes, driver.getCurrentUrl());

        if(expecredRes.equals(driver.getCurrentUrl())){
            logger.info("Pass");
        }else logger.error("Fail");
    }

//    @After
//    public void close_browser(){
//        hooks.quit();
//    }
}
