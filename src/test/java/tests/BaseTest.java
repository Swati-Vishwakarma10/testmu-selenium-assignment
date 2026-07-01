package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.DriverFactory;

public class BaseTest {

    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    @Parameters({"browser", "platform", "version"})
    @BeforeMethod
    public void setUp(String browser, String platform, String version) throws Exception {
        WebDriver driverInstance = DriverFactory.getDriver(browser, platform, version);
        threadLocalDriver.set(driverInstance);
    }

    public WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        WebDriver driver = getDriver();
        if (driver != null) {
            // Report pass/fail to the TestMu AI dashboard
            boolean passed = result.isSuccess();
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + passed);
            driver.quit();
        }
        threadLocalDriver.remove();
    }
}