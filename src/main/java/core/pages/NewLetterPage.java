package core.pages;

import core.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class NewLetterPage extends PageBase{
    //private WebDriver driver;
    private static final String addressRecipient = "sergkorchevskiy@mail.ru";
    private static final String themeLetter = "Autotest Theme message";
    private static final String textMessage = "Test Message";

    private static By addressRecipientInput = By.cssSelector("textarea[data-original-name='To']");
    private static By themeLetterInput = By.cssSelector("input[data-bem='b-input']");
    private static By frameTextLetterInput = By.cssSelector("iframe[title='{#aria.rich_text_area}']");
    private static By textLetterInput = By.id("tinymce");
    private static By sentLetterButton = By.cssSelector("div[data-mnemo='toolbar-compose'] div[data-name='send'] span.b-toolbar__btn__text");

    /*public NewLetterPage(WebDriver driver){
        this.driver = driver;
    }*/

    public Object [][] testDataForLetter() {
        return new Object[][]{
                new Object[]{1, "Test Mettsge"},
                new Object[]{2, "Test Messages"},
                new Object[]{3, "Test Mess"},
        };
    }

    private static NewLetterPage fillToField (String address){
        $(addressRecipientInput).setValue(address);
        //набрали адресс
        return new NewLetterPage();
    }
    private static NewLetterPage fillToTheme (String theme){
        $(themeLetterInput).val(theme);
        return new NewLetterPage();
    }
    private static NewLetterPage fillToTextLetter (String textLetter) {
        switchTo().frame($(frameTextLetterInput));
        $(textLetterInput).setValue(textLetter);
        //набрали текст сообщения
        switchTo().parentFrame();
        return new NewLetterPage();
    }
    private static void sentButtonClick () {
        $(sentLetterButton).click();
    }
    public static void writeLetter (){ //заполнить письмо
        fillToTextLetter(textMessage);
        fillToField(addressRecipient);
        fillToTheme(themeLetter);

        sentButtonClick();
    }
}
