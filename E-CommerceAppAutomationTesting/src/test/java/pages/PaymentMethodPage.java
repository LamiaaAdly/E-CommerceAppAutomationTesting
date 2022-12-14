package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentMethodPage {
    WebDriver driver;
    public PaymentMethodPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement continueButton(){
        By continueButton = By.className("payment-method-next-step-button");
        return driver.findElement(continueButton);
    }
}
