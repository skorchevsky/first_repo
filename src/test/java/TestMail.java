import com.codeborne.selenide.Configuration;
import core.Google.SearchResultsPage;
import core.base.TestBase;
import core.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;


public class TestMail extends TestBase{

    @BeforeClass
    public void start () throws IOException, InterruptedException {
        super.start();

        LoginPage.login();
    }
    @Test (priority = 0)
    public void deleteFirstInboxMessage () {
        MessagesPage.allLettersResults();
        MessagesPage.letterOpen();
        MessagesPage.deleteClick();
    }
    @Test (priority = 1)
    public void createSentNewLetter () {
        HomePage.clickButtonWriteLetter();
        NewLetterPage.writeLetter();
    }
    @Test (priority = 2)//(dependsOnMethods = "createSentNewLetter")//зависимость от другого теста
    public void printMailInfo () {
        HomePage.openInbox();
        MessagesPage.checkInfoInbox();
        HomePage.openSentbox();
        MessagesPage.checkInfoSentbox();
        HomePage.openDrafts();
        MessagesPage.checkInfoDrafts();
        HomePage.openSpam();
        MessagesPage.checkInfoSpam();
        HomePage.openBasket();
        MessagesPage.checkInfoBasket();
    }
    @Test (priority = 3)
    public void checkLogOut () throws IOException, InterruptedException{
        HomePage.logOutClick();
        LoginPage.login();
    }


}
