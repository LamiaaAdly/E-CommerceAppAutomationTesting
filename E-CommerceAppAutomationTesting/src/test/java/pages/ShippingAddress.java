package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingAddress {
    WebDriver driver;
    public ShippingAddress(WebDriver driver){
        this.driver = driver;
    }

    public WebElement shippingAddList(){
        By shippingAddList = By.cssSelector("div>select[id=\"shipping-address-select\"]");
        return driver.findElement(shippingAddList);
    }

    public WebElement continueButton(){
        By continueButton = By.cssSelector("div[id=\"billing-buttons-container\"]>button[name=\"save\"]");
        return driver.findElement(continueButton);
    }
}
