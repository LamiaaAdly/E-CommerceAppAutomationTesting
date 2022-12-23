package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\main\\resources\\features",
        glue = "stepDefinitions",
        tags = "@resetPassword or @search or @createSuccessfulOrder " +
                "or @switchCurrencies or @selectCategories or @filterWithColor " +
                "or @selectDifferentTags " +
                "or @addToShoppingCart or @addToWishlist or @addCompareList",
        plugin = { "usage" },
        publish = true,
        monochrome = true
)

public class TestRunner {
}
