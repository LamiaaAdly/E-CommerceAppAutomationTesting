package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedUserCategoryPage {

    WebDriver driver;

    public LoggedUserCategoryPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement selectedColor(){
        By selectedColor = By.cssSelector("ul>li>input[id=\"attribute-option-15\"]");
        return driver.findElement(selectedColor);
    }
}
