package core.pages;

import core.base.PageBase;
import core.helpers.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;
import static core.helpers.Actions.waitTitle;

public class HomePage extends PageBase{

    //private static WebDriver driver;
    private static final String titleNameInbox = "Входящие - Почта Mail.Ru";
    private static final String titleNameNewLetter = "Новое письмо - Почта Mail.Ru";
    private static final String titleNameSentBox = "Отправленные - Почта Mail.Ru";
    private static final String titleNameDrafts = "Черновики - Почта Mail.Ru";
    private static final String titleNameSpam = "Спам - Почта Mail.Ru";
    private static final String titleNameBasket = "Корзина - Почта Mail.Ru";
    private final static String titleNameMailRuPage = "Mail.Ru: почта, поиск в интернете, новости, игры";

    private static By logOutLink = By.id("PH_logoutLink");
    private static By createNewLetter = By.xpath("//*[@id=\"b-toolbar__left\"]/div/div/div[2]/div");
    private static By searchThemeInboxMessages = By.cssSelector(".b-datalist__item__subj");
    private static By clickLinkInbox = By.cssSelector(".b-nav__link[href='/messages/inbox/']");
    private static By clickLinkSentox = By.cssSelector(".b-nav__link[href='/messages/sent/']");
    private static By clickLinkDrafts = By.cssSelector(".b-nav__link[href='/messages/drafts/']");
    private static By clickLinkSpam = By.cssSelector(".b-nav__link[href='/messages/spam/']");
    private static By clickLinkBasket = By.cssSelector(".b-nav__link[href='/messages/trash/']");

    /*public HomePage(WebDriver driver) {
        this.driver = driver;
    }*/
    public static void logOutClick() {
        $(logOutLink).click();
    }
    public static void clickButtonWriteLetter (){
        $(createNewLetter).click();
    }
    public static void searchInboxLetterByTheme (){
        $(searchThemeInboxMessages);
    }
    public static void openInbox () {//входящие
        $(clickLinkInbox).click();
    }
    public static void openSentbox () {//отправленные
        $(clickLinkSentox).click();
    }
    public static void openDrafts () {//черновики
        $(clickLinkDrafts).click();
    }
    public static void openSpam () {//спам
        $(clickLinkSpam).click();
    }
    public static void openBasket () {//корзина
        $(clickLinkBasket).click();
    }


}
