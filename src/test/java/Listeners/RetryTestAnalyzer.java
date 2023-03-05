package Listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTestAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int NUMBER_OF_RETRIES = 2;
    private final Logger logger = LogManager.getLogger(RetryTestAnalyzer.class);

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < NUMBER_OF_RETRIES) {
                count++;
                logger.info("Retrying test method " + iTestResult.getName());
                return true;
            }
        }
        logger.info("Test method" + iTestResult.getName() + "will be not retried!");
        return false;
    }
}