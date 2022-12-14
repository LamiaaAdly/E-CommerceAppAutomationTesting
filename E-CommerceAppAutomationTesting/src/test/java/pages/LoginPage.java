package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    WebElement userEmailPF;

    public WebElement userEmail(){
        By username = By.id("Email");
        return driver.findElement(username);
    }

    public WebElement password(){
        By password = By.id("Password");
        return driver.findElement(password);
    }

    public By loginErrorMsg(){

        return By.className("message-error");
    }

    public void loginSteps(String username, String password){
        userEmailPF.clear();
        userEmail().sendKeys(username);
        password().sendKeys(password);
    }

}
