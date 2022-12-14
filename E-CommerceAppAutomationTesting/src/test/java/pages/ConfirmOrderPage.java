package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmOrderPage {
    WebDriver driver;
    public ConfirmOrderPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement continueButton(){
        By continueButton = By.className("confirm-order-next-step-button");
        return driver.findElement(continueButton);
    }
}
