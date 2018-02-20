package core.Google;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {
    public static ElementsCollection getResults() {
        return $$("#ires .g");
    }
    public static SelenideElement getResult(int index) {
        return $("#ires .g", index);
    }
}
