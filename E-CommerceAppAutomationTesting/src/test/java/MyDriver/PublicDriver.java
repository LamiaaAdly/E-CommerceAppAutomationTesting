package MyDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PublicDriver {
    private static WebDriver driver = null;
    public static WebDriver getDriver()
    {
        if(driver ==null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;

    }

    public static void quit() {
        if(driver != null)
            driver.quit();
        driver = null;
    }
}
