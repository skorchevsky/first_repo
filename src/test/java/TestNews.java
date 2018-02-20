import core.base.TestBase;
import core.pages.HeaderPage;
import core.pages.NewsPage;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class TestNews extends TestBase{


    @Test
    public void news (){
        open("https://mail.ru");
        HeaderPage.newsHeader();
        NewsPage.clickLinkPolitics();
        NewsPage.clickLinkEconomics();
    }
}
