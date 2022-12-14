package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingPage {
    WebDriver driver;
    public ShippingPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement continueButton(){
        By continueButton = By.className("shipping-method-next-step-button");
        return driver.findElement(continueButton);
    }
}
