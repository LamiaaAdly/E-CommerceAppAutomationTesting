package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement firstName(){
        By firstName = By.id("FirstName");
        return driver.findElement(firstName);
    }

    public WebElement lastName(){
        By lastName = By.id("LastName");
        return driver.findElement(lastName);
    }

    public WebElement email(){
        By email = By.id("Email");
        return driver.findElement(email);
    }

    public WebElement password(){
        By password = By.id("Password");
        return driver.findElement(password);
    }

    public WebElement confirmPassword(){
        By confirmPassword = By.id("ConfirmPassword");
        return driver.findElement(confirmPassword);
    }

    public WebElement firstNameError(){
        By firstNameError = By.id("FirstName-error");
        return driver.findElement(firstNameError);
    }

    public WebElement lastNameError(){
        By lastNameError = By.id("LastName-error");
        return driver.findElement(lastNameError);
    }

    public WebElement emailError(){
        By emailError = By.id("Email-error");
        return driver.findElement(emailError);
    }

    public WebElement passwordError(){
        By passwordError = By.id("Password-error");
        return driver.findElement(passwordError);
    }

    public WebElement confirmPasswordError(){
        By confirmPasswordError = By.id("ConfirmPassword-error");
        return driver.findElement(confirmPasswordError);
    }

    public WebElement successResult(){
        By successResult = By.cssSelector("div>div[class=\"result\"]");
        return driver.findElement(successResult);
    }

    public WebElement continueButton(){
        By continueButton = By.className("register-continue-button");
        return driver.findElement(continueButton);
    }


    public void registerSteps(String fName, String lName, String email, String password, String confirmPassword){
        firstName().clear();
        lastName().clear();
        email().clear();
        password().clear();
        confirmPassword().clear();

        firstName().sendKeys(fName);
        lastName().sendKeys(lName);
        email().sendKeys(email);
        password().sendKeys(password);
        confirmPassword().sendKeys(confirmPassword);
    }

}
