import core.base.TestBase;
import core.helpers.TestDataD;
import core.helpers.TestListener;
import core.pages.HeaderPage;
import core.pages.SearchPage;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
import static core.helpers.Actions.sikuli;


@Listeners({TestListener.class})
/*
@Epic("My tests")
@Feature("Test mailRu")
*/
public class TestMailRu extends TestBase{
/*
    @Flaky
*/
    @Test(description = "Search Test")
    public void searchTest() {
        open("https://mail.ru");
        HeaderPage.searchHeader();
        SearchPage.performSearch();
        SearchPage.printLinkFirstResultSearch();
        /*SearchResultsPage.getResults().shouldHave(sizeGreaterThan(1));
        Assert.assertTrue(SearchResultsPage.getResults().size() > 0);
        SearchResultsPage.getResult(0).shouldHave(text("Минск"));
        Assert.assertTrue(SearchResultsPage.getResult(0).text().contains("Минск"));*/
    }
    @Test (description = "First Link Test")
    public void firstLinkTest () throws Exception {
        HeaderPage.searchHeader();
        SearchPage.performSearch();
        SearchPage.clickImagesResults();
        sikuli();
        //SearchPage.scrollImagesResultsAndClickBtnShowMore();

        //SearchPage.verifyThatImagesEqual();
    }
    @DataProvider (name="TestData")
    public Object[][] testDataSearch() {
        return new Object[][] {
                new Object[] {"Selenium"},
                new Object[] {"TestNG"},
                new Object[] {"Microsoft"},
                new Object[] {"Firefox"},
        };
    }
    //@Parameters
    //public static Collection testData() throws IOException {  return  getTestData("D:\\Automation\\Java\\testng2\\src\\main\\resources\\data.csv");

    @Test(dataProviderClass = TestDataD.class, dataProvider = "TestDataFromFile",description = "Search And Verify Results Test")
    public void searchAndVerifyResultsTest (String textSearch) throws InterruptedException {
        HeaderPage.searchHeader();
        SearchPage.performSearch(textSearch);
        System.out.println("Search Text is " + textSearch);
        SearchPage.printLinkFirstResultSearch();
        SearchPage.verifySearchResults(textSearch);
    }
    @AfterClass
    public void close (){

    }
}
