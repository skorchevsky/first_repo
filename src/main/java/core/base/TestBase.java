package core.base;

import com.codeborne.selenide.Configuration;
import core.pages.HeaderPage;
import core.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;


public class TestBase {
    protected String url = "https://mail.ru";

    @BeforeClass

    public void start() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\WebDriver\\ChromeDriver.exe");
        Configuration.browser = "firefox";
        open(url);
    }

    @AfterClass
    public void close() {
        HomePage.logOutClick();
        //driver.quit();
    }
}
