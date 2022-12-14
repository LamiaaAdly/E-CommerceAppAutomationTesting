package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductTagPage {
    WebDriver driver;

    public ProductTagPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement productTag(String productTagName){
        By productTag = By.cssSelector("ul[class=\"product-tags-list\"]>li>a[href=\"/"+ productTagName +"\"]");
        return driver.findElement(productTag);
    }
}
