package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompletedPage {
    WebDriver driver;
    public CompletedPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement continueButton(){
        By continueButton = By.className("order-completed-continue-button");
        return driver.findElement(continueButton);
    }
}
