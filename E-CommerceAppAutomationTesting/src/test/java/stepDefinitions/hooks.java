package stepDefinitions;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class hooks {
    private static WebDriver driver = null;
    @BeforeAll
    public static void before_all(){
        driver = hooks.getDriver();
    }
    @AfterAll
    public static void after_all(){
        if(driver != null)
            driver.quit();
        driver = null;
    }

    public static WebDriver getDriver()
    {
        if(driver ==null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
//    @After
//    public static void quit() {
//        if(driver != null)
//            driver.quit();
//        driver = null;
//    }
}
