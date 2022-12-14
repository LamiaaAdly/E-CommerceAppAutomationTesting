package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentInfoPage {
    WebDriver driver;
    public PaymentInfoPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement continueButton(){
        By continueButton = By.className("payment-info-next-step-button");
        return driver.findElement(continueButton);
    }
}
