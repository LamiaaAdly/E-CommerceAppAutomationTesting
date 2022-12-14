package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
    WebDriver driver;

    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement checkTermsofservice() {
        By termsofservice = By.id("termsofservice");
        return driver.findElement(termsofservice);
    }

    public WebElement checkoutButton(){
        By checkoutButton = By.id("checkout");
        return driver.findElement(checkoutButton);
    }


}
