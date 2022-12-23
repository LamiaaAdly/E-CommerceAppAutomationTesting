package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.LoggedUserCategoryPage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoggedUserHomePage;

public class FilterWithColorStepDefinition {
    WebDriver driver;
    LoggedUserCategoryPage lUserCategory;
    LoggedUserHomePage loggedUser;
    Logger logger;
    Actions actions;
    WebElement categoryList, subCategory;

    @When("user hover to Apparel")
    public void user_hover(){
        driver = hooks.getDriver();
        driver.get("https://demo.nopcommerce.com/");
        loggedUser = new LoggedUserHomePage(driver);

        categoryList = loggedUser.categoryList_Apparel();
        actions = new Actions(driver);
        actions.moveToElement(categoryList);
    }

    @And("user select Shoes")
    public void user_select(){
        subCategory = loggedUser.subCategory_Shoes();
        actions.moveToElement(subCategory);

        actions.click().build().perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user go to Shoes category page")
    public void category_page(){
        logger = LoggerFactory.getLogger(SelectCategoriesStepDefinition.class);
        logger.info("Select Category Result:");

        String expectedRes = "https://demo.nopcommerce.com/shoes";

        Assert.assertEquals("Select Category error!",
                expectedRes, driver.getCurrentUrl());

        if(expectedRes.equals(driver.getCurrentUrl())){
            logger.info("Pass");
        }else logger.error("Fail");
    }

    @When("user select colors")
    public void select_colors(){
        driver = hooks.getDriver();
        driver.get("https://demo.nopcommerce.com/shoes");
        lUserCategory = new LoggedUserCategoryPage(driver);

        lUserCategory.selectedColor().click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user see products with selected colors")
    public void products_selected_colors(){
        logger = LoggerFactory.getLogger(FilterWithColorStepDefinition.class);
        logger.info("Colored product Result:");

//        String id = lUserCategory.selectedColor().getAttribute("data-option-id");
        String expectedUrl = "https://demo.nopcommerce.com/shoes?viewmode=grid&orderby=0&pagesize=6&specs=15";
        Assert.assertEquals("Products with selected colors error!",
                expectedUrl, driver.getCurrentUrl());

        if(expectedUrl.equals(driver.getCurrentUrl())){
            logger.info("Pass");
        }else logger.error("Fail");
    }

}
