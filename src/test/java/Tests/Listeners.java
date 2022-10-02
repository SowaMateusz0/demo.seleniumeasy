package Tests;

import Assists.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseClass implements ITestListener {


    ExtentReports extentReports = ExtentReporter.getReportObject();
    ExtentTest test;
    ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();
    public static Logger log = LogManager.getLogger(BaseClass.class.getName());
    WebDriver driver;

    @Override
    public void onTestStart(ITestResult iTestResult) {

        test = extentReports.createTest(iTestResult.getMethod().getMethodName());
        threadLocal.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
            log.info("Pass Test case is: " + iTestResult.getName(), Status.PASS);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String testMethodName = iTestResult.getMethod().getMethodName();

        try {
            driver = (WebDriver) iTestResult.getTestClass().getRealClass().getField("driver").get(iTestResult.getInstance());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        try {
            threadLocal.get().addScreenCaptureFromPath("."+getScreenShotPath(iTestResult.getMethod().getMethodName(),driver),iTestResult.getMethod().getMethodName());
            getScreenShotPath(testMethodName,driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("Fail Test case is : " +iTestResult.getName(), Status.FAIL);

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        test = extentReports.createTest(iTestResult.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel(iTestResult.getName(), ExtentColor.ORANGE));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extentReports.flush();
    }

}
