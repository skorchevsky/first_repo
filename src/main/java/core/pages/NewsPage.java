package core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static core.helpers.Actions.waitLoadPage;

public class NewsPage {
    private static WebDriver driver;

    private static final By politicLinkClick = By.xpath(".//*[@id='portal-menu__submenu']/div[1]/div/div/div/span/span[1]/span[2]/a/span[2]/span");
    private static final By economicLinkClick = By.xpath(".//*[@id='portal-menu__submenu']/div[1]/div/div/div/span/span[1]/span[3]/a/span[2]/span");


    public NewsPage(WebDriver driver) {
        this.driver = driver;
    }
    public static void clickLinkPolitics () {
        $(politicLinkClick).click();

    }
    public static void clickLinkEconomics () {
        $(economicLinkClick).click();

    }
}
