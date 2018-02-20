package core.Google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Drivers {
    private static WebDriver driver = null;

    public  Drivers() {
        System.out.println("Drivers initiated");
    }

    public WebDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\WebDriver\\chromedriver.exe");
        return driver = new ChromeDriver();
    }
}
