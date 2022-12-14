package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResetPasswordPage {
    WebDriver driver;
    public ResetPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement forgotPasswordLink(){
        By forgotPasswordLink = By.cssSelector("span[class=\"forgot-password\"]>a");
        return driver.findElement(forgotPasswordLink);
    }

    public WebElement email(){
        By email = By.id("Email");
        return driver.findElement(email);
    }

    public WebElement successResult(){
        By successMsg = By.cssSelector("div>p[class=\"content\"]");
        return driver.findElement(successMsg);
    }

    public void resetPasswordSteps(String mail){
        email().clear();
        email().sendKeys(mail);
    }
}
