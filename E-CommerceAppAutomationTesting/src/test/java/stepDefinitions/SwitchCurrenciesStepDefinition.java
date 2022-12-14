package stepDefinitions;

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

public class SwitchCurrenciesStepDefinition {

    WebDriver driver;
    LoggedUserHomePage loggedUser;

    @Before
    public void user_open_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("user change customer currency")
    public void change_currency(){
        loggedUser = new LoggedUserHomePage(driver);
        WebElement currencyList = loggedUser.customerCurrencyOption();
        Select select = new Select(currencyList);
        String option = select.getFirstSelectedOption().getText();
        System.out.println("Option was "+   option);
        switch (option){
            case "US Dollar":
                select.selectByVisibleText("Euro");
                break;
            case "Euro":
                select.selectByVisibleText("US Dollar");
                break;
        }
    }

    @Then("product price change")
    public void price_change(){
        String price = loggedUser.changeCurrencyRes().getText();

        WebElement currencyList = loggedUser.customerCurrencyOption();
        Select select = new Select(currencyList);
        String option = select.getFirstSelectedOption().getText();
        switch (option){
            case "US Dollar":
                Assert.assertTrue("Dollar error",price.contains("$"));
                break;
            case "Euro":
                Assert.assertTrue("Euro error",price.contains("€"));
                break;
        }

    }

    @After
    public void close_browser(){
        driver.quit();
    }
}
