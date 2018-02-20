package core.pages;

import core.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static core.helpers.Actions.waitTitle;

public class HeaderPage extends PageBase{

    //private static WebDriver driver;

    private static final String titleNameMailRuPage = "Mail.Ru: почта, поиск в интернете, новости, игры";
    private static final String titleNameRegistrationPage = "Регистрация";
    private static final String titleNameMailPage = "Вход - Почта Mail.Ru";
    private static final String titleNameMyWorldPage = "My World@Mail.Ru: stay in touch with your classmates and friends";
    private static final String titleNameClassmaterPage = "OK.RU";
    private static final String titleNameGamesPage = "Бесплатные онлайн игры, а также платные игры для ПК";
    private static final String titleNameAcquaintancePage = "Знакомства@Mail.Ru";
    private static final String titleNameNewsPage = "Новости Mail.Ru: Последние новости России и мира - Новости Mail.Ru";
    private static final String titleNameSearchPage = "Поиск Mail.Ru";
    private static final String titleNameAllProjectsPage = "Регистрация";

    private static By registrationLink = By.cssSelector("#PH_regLink");
    private static By mailRuLink = By.cssSelector("#ph_mail");
    private static By mailLink = By.cssSelector("#ph_mail");
    private static By myWorldLink = By.cssSelector("#ph_my");
    private static By classmaterLink = By.cssSelector(".w-x-ph__link");
    private static By gamesLink = By.cssSelector("#PH_regLink");
    private static By acquaintanceLink = By.cssSelector("#PH_regLink");
    private static By newsLink = By.linkText("Новости");
    private static By searchLink = By.linkText("Поиск");
    private static By allProjectsLink = By.cssSelector("#PH_projectsMenu");

   /* public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }*/
    public static void registrationHeader () {
        $(registrationLink).click();
    }
    public static void mailRuHeader () { //Mail.ru
        $(mailRuLink).click();
    }
    public static void mailHeader () { //почта
        $(mailLink).click();
    }
    public static void myWorldHeader () {
        $(myWorldLink).click();
    }
    public static void classmaterHeader () { //одноклассники
        $(classmaterLink).click();
    }
    public static void gamesHeader () {
        $(gamesLink).click();
    }
    public static void acquaintanceHeader () { //знакомства
        $(acquaintanceLink).click();
    }
    public static void newsHeader() {
        $(newsLink).click();
        //waitTitle(titleNameNewsPage);
    }
    public static void searchHeader () {
        $(searchLink).click();
    }
    public static void allProjectsHeader () { //выпадающее меню
        $(allProjectsLink).click();
        waitTitle(titleNameAllProjectsPage);
    }
}
