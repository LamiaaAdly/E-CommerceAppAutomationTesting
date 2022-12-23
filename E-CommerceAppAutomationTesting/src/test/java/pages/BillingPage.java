package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BillingPage {
    WebDriver driver;

    public BillingPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement firstName(){
        By firstName = By.id("BillingNewAddress_FirstName");
        return driver.findElement(firstName);
    }

    public WebElement lastName(){
        By lastName = By.id("BillingNewAddress_LastName");
        return driver.findElement(lastName);
    }

    public WebElement email(){
        By email = By.id("BillingNewAddress_Email");
        return driver.findElement(email);
    }
    public WebElement country(){
        By country = By.cssSelector("select[id=\"BillingNewAddress_CountryId\"]");
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

    public WebElement shipSameAddress(){
        By shipAddress = By.cssSelector("input[id=\"ShipToSameAddress\"]");
        return driver.findElement(shipAddress);
    }

    public WebElement continueButton(){
        By continueButton = By.cssSelector("div[id=\"billing-buttons-container\"]>button[name=\"save\"]");
        return driver.findElement(continueButton);
    }
}
