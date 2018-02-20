package core.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.*;
import org.sikuli.script.Screen;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.forward;

public class Actions {

    private static WebDriver driver;

    public static void waitTitle (final String titleName) {
        (new WebDriverWait(driver, 3)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().contains(titleName);
            }
        });
    }
    public  static void waitLoadPage () {
        driver.manage().timeouts().pageLoadTimeout(4,	TimeUnit.SECONDS);
    }
    /*public static void scrollUpAndDown (){
    //verh
    $(document).ready(function(){
        $(window).scrollTop(0);
        }

    //это до низа
    window.scrollTo(0,document.body.scrollHeight);
    }*/
    public static void scrollUnderElement(By elementLocator) {
        Point location = $(elementLocator).getLocation();
        executeJavaScript("window.scrollTo(" + location.getX() + ", " + (location.getY() - 200) + ')');
    }
    public static void sikuli ()throws Exception {

        Screen screen = new Screen();
        Pattern pattern = new Pattern("D:\\Automation\\Java\\testng2\\result\\etalonFile.png");
        screen.find(pattern);
    }
}
