package core.pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.Google.SearchResultsPage;
import core.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class MessagesPage extends PageBase {
    //private WebDriver driver;
    private static final By buttonDelete = cssSelector("div[data-mnemo='toolbar-letter'] div[data-shortcut='del|command+backspace']");
    private static  final By themeInMessage = cssSelector(".b-letter__head__subj__text");
    private static  final By themeMessages = cssSelector(".b-datalist__item__subj");
    private static  final By inboxLink = xpath("//*[@id='b-nav_folders']/div/div[1]/a/span[1]");
    private static  final By textInbox = cssSelector(".b-nav__link[href='/messages/inbox/']");
    private static  final By textSentbox = cssSelector(".b-nav__link[href='/messages/sent/']");
    private static  final By textDrafts = cssSelector(".b-nav__link[href='/messages/drafts/']");
    private static  final By textSpam = cssSelector(".b-nav__link[href='/messages/spam/']");
    private static  final By textBasket = cssSelector(".b-nav__link[href='/messages/trash/']");

    /*public MessagesPage(WebDriver driver){
        this.driver = driver;
    }*/
    public static ElementsCollection allLettersResults (){
        return $$(themeMessages);
    }
    public static SelenideElement lettersResult (int index){
        $(themeMessages,index);
 //       Assert.assertTrue(lettersResult(0).text().contains("Autotest Theme message"));
        return $(themeMessages,index);
    }
    public static void letterOpen (){
        lettersResult(0).click();
        Assert.assertTrue($(themeInMessage).getText().contains("Autotest Theme message"));
    }
    public static void deleteClick (){
/*
        allLettersResults().shouldHave(sizeGreaterThan(1));
        lettersResult(0).shouldHave(text("Autotest Theme message"));
*/
        $(buttonDelete).click();
    }

    public static void checkInboxQuantity (){ //получаем колличество входящих сообщений
        String inbox = $(inboxLink).getText();//используем XPath
        int countMessages = Integer.parseInt(inbox);//преобразуем строку в число
        System.out.println("Колличество непрочитанных входящих сообщений: " +countMessages);
    }

    public static void checkInfoInbox (){
        String textIn= $(textInbox).getAttribute("data-title");
        System.out.println("Во входящих " +textIn);
    }
    public static void checkInfoSentbox (){
        String textSe= $(textSentbox).getAttribute("data-title");
        System.out.println("В отправленных " +textSe);
    }
    public static void checkInfoDrafts (){
        String textDr= $(textDrafts).getAttribute("data-title");
        System.out.println("В черновиках " +textDr);
    }
    public static void checkInfoSpam (){
        String textSp= $(textSpam).getAttribute("data-title");
        System.out.println("В спаме " +textSp);
    }
    public static void checkInfoBasket (){
        String textBa= $(textBasket).getAttribute("data-title");
        System.out.println("В корзине " +textBa);
    }
}
