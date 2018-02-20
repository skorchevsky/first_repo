package core.pages;

import com.codeborne.selenide.*;
import core.base.PageBase;
import core.helpers.Actions;
import core.helpers.CompareUtil;
import org.openqa.selenium.*;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

import java.io.File;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.openqa.selenium.By.cssSelector;
import static org.testng.Assert.assertEquals;

public class SearchPage extends PageBase {
    //private static String textSearch;
    private static String textSearch = "Selenium";
    private static StringBuffer verificationErrors = new StringBuffer();

    private static final By stringSearch = By.name("q");
    private static final By imgLinkSearch = By.id("tbl-img");
    private static final By newsLinkSearch = By.id("tbl-news");
    private static final By linkClickSearch = By.id("MSearch-submit");
    private static final By themeMessages = cssSelector(".b-datalist__item__subj");
    private static final By buttonDelete = cssSelector("div[data-mnemo='toolbar-letter'] div[data-shortcut='del|command+backspace']");
    private static final By themeInMessage = cssSelector(".b-letter__head__subj__text");
    private static final By firstLinkResultsSearch = cssSelector("[id='js-result_1'] .block-info-serp");
    private static final By SearchResults = By.cssSelector(".result__li .result__snp");
    private static final By SearchResultsTitles = By.cssSelector("#js-result [class='light-link']");//(".result__li .result__title");
    private static final By btnShowMore = By.cssSelector(".more-results__btn");
    private static final By parentDiv = By.cssSelector(".media-responses__list [class='js-images-item images-item']");

    public static void performSearch () {
        performSearch(textSearch);
    }

    public static void performSearch(String textSearch) {
        $(stringSearch).val(textSearch).pressEnter();
    }
    public static void scrollImagesResultsAndClickBtnShowMore (){
        SelenideElement btn = $(btnShowMore);
        ElementsCollection imagesCollectionsFirst = $$(parentDiv);
        //SelenideElement btn=$(parentDiv).scrollTo(btnInd, ).pressEnter();
       // for (btn.shouldBe(visible)){
        $(".top_menu__wrapper").click();
        //Selenide.actions().keyDown(Keys.PAGE_DOWN);
        Actions.scrollUnderElement((By) btn);
       /* Selenide.executeJavaScript("arguments[0].scrollIntoView(true);",btn);
        Selenide.actions().moveToElement(btn);
        Selenide.actions().perform();*/
        Selenide.actions().click(btn);
        ElementsCollection imagesCollectionsSecond = $$(parentDiv);
        /*Selenide.Wait().withTimeout(4,TimeUnit.SECONDS);*/
        Assert.assertTrue(imagesCollectionsFirst.size() > imagesCollectionsSecond.size());
        //btn.click();
       // parentDiv.find(btnShowMore).scrollTo().click();
        //parentDiv.find(btnShowMore).scrollTo().shouldBe(visible).click();
        //$(btnShowMore).shouldBe(visible).click();
    }


    public static void printLinkFirstResultSearch (){
        String textLink = $(firstLinkResultsSearch).getText();
        $(SearchResults).getText().contains(textSearch);
        System.out.println(textLink+ " - адресс первого результата поиска");
    }
    public static  void clickImagesResults () {
        $(imgLinkSearch).click();
    }

    public static void verifySearchResults(String textSearch) throws InterruptedException {
        ElementsCollection searchResultsTitles = $$(SearchResultsTitles);
        ElementsCollection searchResults = $$(SearchResults);
        searchResults.shouldHaveSize(10);
        getWebDriver().getCurrentUrl();
        for (int i = 0; i < searchResults.size(); i++) {
            if (!(searchResults.get(i).text().equals("Найден по ссылке")))
                Assert.assertTrue(searchResults.get(i).text().contains(textSearch) || searchResultsTitles.get(i).text().contains(textSearch));
            else {
                String currentWindowId = getWebDriver().getWindowHandle();
                Set<String> allWindowsBefore = getWebDriver().getWindowHandles();
                searchResultsTitles.get(i).click();
                Selenide.sleep(7000);
                Set<String> allWindowsAfter = getWebDriver().getWindowHandles();
                allWindowsAfter.removeAll(allWindowsBefore);
                getWebDriver().switchTo().window(allWindowsAfter.toArray()[0].toString());
                Assert.assertTrue(url().contains(textSearch.toLowerCase()));
                getWebDriver().close();
                getWebDriver().switchTo().window(currentWindowId);


/*                if (!allWindows.isEmpty()) {
                    for (String windowId : allWindows) {
                        getWebDriver().switchTo().window(windowId);
                        if (getWebDriver().getPageSource().contains("Make your product perfect")) {
                            try {
                                String urll = getWebDriver().getCurrentUrl();
                                String uirl2 = url();
                                Assert.assertTrue(uirl2.contains(textSearch));
                                //getWebDriver().close();
                                getWebDriver().switchTo().window(currentWindowId);
                            } catch (NoSuchWindowException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }*/
            }
        }

    }

    public static void verifyThatImagesEqual() throws Exception{
        /*Configuration.reportsFolder = "D:\\Automation\\Java\\testng2\\result";
        screenshot("my_file_name");//делаю скрин*/
        //File etalon = new File("D:\\Automation\\Java\\testng2\\result\\etalonFile.png");
        //File newFile = new File("D:\\Automation\\Java\\testng2\\result\\my_file_name.png");
        String scrFile = "D:\\Automation\\Java\\testng2\\result\\my_file_name.png";
        String baseScrFile = "D:\\Automation\\Java\\testng2\\result\\etalonFile.png";
        System.out.println(CompareUtil.CompareImage(baseScrFile,scrFile));
        assertEquals(CompareUtil.Result.Matched, CompareUtil.CompareImage(baseScrFile, scrFile));

        Screen screen = new Screen();
        Pattern pattern = new Pattern("D:\\Automation\\Java\\testng2\\result\\etalonFile.png");
        screen.find(pattern);

    }

}
