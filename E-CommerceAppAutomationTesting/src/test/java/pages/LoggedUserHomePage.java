package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedUserHomePage {
    WebDriver driver;
    public LoggedUserHomePage(WebDriver driver){
        this.driver = driver;
    }
    //---- Search for a Product from home page -----//
    public WebElement searchTerms(){
        By searchTerms = By.id("small-searchterms");
        return driver.findElement(searchTerms);
    }
    //---- Change Currency from home page -----//
    public WebElement customerCurrencyOption(){
        By customerCurrency = By.id("customerCurrency");
        return driver.findElement(customerCurrency);
    }

    public WebElement changeCurrencyRes(){
        By changeCurrency = By.cssSelector("div[data-productid=\"4\"]>div>div>div[class=\"prices\"]>span");
        return driver.findElement(changeCurrency);
    }
    //---- Select Category from home page -----//
    public WebElement categoryList(String categoryName){
        By categoryList = By.cssSelector("ul>li>a[href = \"/"+ categoryName +"\"]"); // main list is "div> ul[class="top-menu notmobile"]"
        return driver.findElement(categoryList);
    }

    public WebElement subCategory(String subCategoryName){
        By subCategory = By.cssSelector("ul>li>a[href=\"/"+ subCategoryName +"\"]");
        return driver.findElement(subCategory);
    }

    //---- Add Product from home page to Shopping cart-----//
    public WebElement addToCard(){
        By addToCard = By.cssSelector("div[data-productid=\"4\"]>div>div>div[class=\"buttons\"]>button[class=\"button-2 product-box-add-to-cart-button\"]");
        return driver.findElement(addToCard);
    }

    public WebElement addToCardProductP(){
        By addToCard = By.id("add-to-cart-button-4");
        return driver.findElement(addToCard);
    }

    public WebElement addToCartSuccess(){
        By addToCardSuccess = By.cssSelector("p[class=\"content\"]");
        return driver.findElement(addToCardSuccess);
    }
    //addtocard select //div>div[class="product-item"] // with product number //data-productid
    public WebElement cartLink(){
        By cartLink = By.cssSelector("div>p>a[href=\"/cart\"]");
        return driver.findElement(cartLink);
    }

    //---- Add Product from home page to wishlist-----//
    public WebElement addToWishlist(){
        By addToWishlist = By.cssSelector("div[data-productid=\"4\"]>div>div>div[class=\"buttons\"]>button[class=\"button-2 add-to-wishlist-button\"]");
        return driver.findElement(addToWishlist);
    }

    public WebElement addToWishlistP(){
        By addToCard = By.id("add-to-wishlist-button-4");
        return driver.findElement(addToCard);
    }

    public WebElement addToWishlistSuccess(){
        By addToCardSuccess = By.cssSelector("div>p[class=\"content\"]");
        return driver.findElement(addToCardSuccess);
    }

    public WebElement wishLink(){
        By wishLink = By.cssSelector("div>p>a[href=\"/wishlist\"]");
        return driver.findElement(wishLink);
    }

    //---- Add Product from home page to wishlist-----//
    public WebElement addToCompareList(){
        By addToWishlist = By.cssSelector("div[data-productid=\"4\"]>div>div>div[class=\"buttons\"]>button[class=\"button-2 add-to-compare-list-button\"]");
        return driver.findElement(addToWishlist);
    }

    public WebElement addToCompareListSuccess(){
        By addToCompareListSuccess = By.cssSelector("div>p[class=\"content\"]");
        return driver.findElement(addToCompareListSuccess);
    }

    public WebElement compLink(){
        By compLink = By.cssSelector("div>p>a[href=\"/compareproducts\"]");
        return driver.findElement(compLink);
    }

}
