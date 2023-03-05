package Listeners;

import Tests.BaseClass;
import Utility.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Listeners extends BaseClass implements ITestListener {


    ExtentReports extentReports = ExtentReporter.getReportObject();
    ExtentTest test;
    ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();
    WebDriver driver;
    private final Logger logger = LogManager.getLogger(Listeners.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {

        test = extentReports.createTest(iTestResult.getMethod().getMethodName());
        threadLocal.set(test);
        logger.info("Starting test: " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("Test "+ iTestResult.getName() +" passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String testMethodName = iTestResult.getMethod().getMethodName();
        logger.info("Test "+ testMethodName +" failed!");

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
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test = extentReports.createTest(iTestResult.getName());
        logger.info("Test "+ iTestResult.getName() +" skipped!");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        logger.info("Test "+ iTestResult.getName() +" failed!");
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extentReports.flush();
    }

}
