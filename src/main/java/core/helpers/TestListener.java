package core.helpers;

import com.codeborne.selenide.testng.ScreenShooter;
import core.base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestListener extends ScreenShooter {
    private static String getTestMethodName (ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value="0", type = "text/plain")
    public static String saveTextLog (String message){
        return message;
    }
    @Attachment (value = "Page screenshot with the failure cause")
    public static byte[] saveScreenshot() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        saveScreenshot();
        System.out.println(result.getMethod().getTestClass().getName() + "-" + result.getMethod().getMethodName() +
                " failed at " + new Date());
        System.out.println("Execution time: " + millisToMinSec(result.getEndMillis() - result.getStartMillis()));
        result.getThrowable().printStackTrace();
    }


    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
    private String millisToMinSec(long millis){
        return String.format("%02d min : %02d sec",
                TimeUnit.MILLISECONDS.toMinutes(millis),
                TimeUnit.MILLISECONDS.toSeconds((millis) -
                        TimeUnit.MINUTES.toMillis(TimeUnit.MILLISECONDS.toMinutes(millis))));
    }
}
