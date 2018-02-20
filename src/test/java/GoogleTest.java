import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import core.Google.Drivers;
import core.Google.SearchResultsPage;
import core.Google.GooglePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {
    public static Drivers drvs = new Drivers();

    @Test
    public static void userCanSearch() {
        //Configuration.browser = "chrome";
        //WebDriverRunner.setWebDriver(drvs.getChromeDriver());
        open("https://google.com/");
        GooglePage.searchFor("selenide");
        SearchResultsPage.getResults().shouldHave(sizeGreaterThan(1));
        Assert.assertTrue(SearchResultsPage.getResults().size() > 0);
        SearchResultsPage.getResult(0).shouldHave(text("Selenide: concise UI tests in Java"));
        Assert.assertTrue(SearchResultsPage.getResult(0).text().contains("Selenide: concise UI tests in Java"));
    }
}
