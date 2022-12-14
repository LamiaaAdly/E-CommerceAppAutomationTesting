package stepDefinitions;

import pages.ResetPasswordPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResetPasswordStepDefinition {
    WebDriver driver =null;
    ResetPasswordPage resetPassword;

    @Before
    public void user_open_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Given("user press forget password link")
    public void press_forget_password(){
        resetPassword = new ResetPasswordPage(driver);
        //go to login page
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
        resetPassword.forgotPasswordLink().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("^user enters \"(.*)\"$")
    public void enter_email(String mail) {
        resetPassword.resetPasswordSteps(mail);
    }

    @And("user click on recover button")
    public void click_change_password_button(){
        resetPassword.email().sendKeys(Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user read successful message")
    public void successResult(){
        String successResult = resetPassword.successResult().getText();
        System.out.println(successResult);
        Assert.assertTrue("Error in reset password!",
                successResult.contains("Email with instructions has been sent to you."));

    }

    @After
    public void close_browser(){
        driver.quit();
    }
}
