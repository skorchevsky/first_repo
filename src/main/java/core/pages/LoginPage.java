package core.pages;

import core.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static core.helpers.Locators.get;

public class LoginPage extends PageBase{
    private static final String fillToEmail = "sergkorchevskiy";
    private static final String fillToPassword = "ab1757792";

    //public static final By email = get("login.name");

    private static final By email = get("login.name");
    private static final By password = get("login.password");
    private static final By submit = get("login.ok.button");

    public static void login () {
       // Assert.assertEquals(driver.getTitle(), "Mail.Ru: почта, поиск в интернете, новости, игры");
            $(email).val(fillToEmail);
            $(password).setValue(fillToPassword).pressEnter();
           /* $(submit).shouldBe(visible);*/
            //$(submit).shouldHave(text("Войти"));
            //$(submit).click();
    }
}
