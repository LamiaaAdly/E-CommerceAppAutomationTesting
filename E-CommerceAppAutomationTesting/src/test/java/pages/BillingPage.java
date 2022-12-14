package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BillingPage {
    WebDriver driver;

    public BillingPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement country(){
        By country = By.id("BillingNewAddress_CountryId");
        return driver.findElement(country);
    }

    public WebElement city(){
        By city = By.id("BillingNewAddress_City");
        return driver.findElement(city);
    }

    public WebElement address(){
        By address = By.id("BillingNewAddress_Address1");
        return driver.findElement(address);
    }

    public WebElement postalCode(){
        By postalCode = By.id("BillingNewAddress_ZipPostalCode");
        return driver.findElement(postalCode);
    }

    public WebElement phone(){
        By phone = By.id("BillingNewAddress_PhoneNumber");
        return driver.findElement(phone);
    }

    public WebElement continueButton(){
        By continueButton = By.name("save");
        return driver.findElement(continueButton);
    }
}
