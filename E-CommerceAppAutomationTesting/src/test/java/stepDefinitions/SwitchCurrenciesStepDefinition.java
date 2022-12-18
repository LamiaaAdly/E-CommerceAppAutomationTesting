package stepDefinitions;

import MyDriver.PublicDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.LoggedUserHomePage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SwitchCurrenciesStepDefinition {

    WebDriver driver;
    LoggedUserHomePage loggedUser;
    Logger logger;
    @Before
    public void user_open_browser() {
        driver = PublicDriver.getDriver();
    }

    @When("user change customer currency")
    public void change_currency(){
        loggedUser = new LoggedUserHomePage(driver);
        WebElement currencyList = loggedUser.customerCurrencyOption();
        Select select = new Select(currencyList);
        String option = select.getFirstSelectedOption().getText();
        System.out.println("Option was "+   option);
//        switch (option){
//            case "US Dollar":
                select.selectByVisibleText("Euro");
//                break;
//            case "Euro":
//                select.selectByVisibleText("US Dollar");
//                break;
//        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("product price change")
    public void price_change(){
        logger = LoggerFactory.getLogger(SwitchCurrenciesStepDefinition.class);
        logger.info("Switch Currency Result:");

        String price = loggedUser.changeCurrencyRes().getText();

        WebElement currencyList = loggedUser.customerCurrencyOption();
        Select select = new Select(currencyList);
        String option = select.getFirstSelectedOption().getText();
//        switch (option){
//            case "US Dollar":
//                Assert.assertTrue("Dollar error",price.contains("$"));
//                logger.info("US Dollar switched success");
//                break;
//            case "Euro":
                Assert.assertTrue("Euro error",price.contains("€"));
                logger.info("Euro switched success");
//                break;
//        }

    }

    @After
    public void close_browser(){
        PublicDriver.quit();
    }
}
