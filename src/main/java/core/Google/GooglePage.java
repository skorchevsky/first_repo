package core.Google;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class GooglePage {
    public static void searchFor(String text) {
        $(By.name("q")).val(text).pressEnter();

    }
}
