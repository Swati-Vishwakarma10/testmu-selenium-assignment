package utils;

import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    public static WebDriver getDriver(String browser, String platform, String version) throws Exception {

        String username = System.getenv("LT_USERNAME");
        String accesskey = System.getenv("LT_ACCESS_KEY");
        String gridURL = "@hub.lambdatest.com/wd/hub";

        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("build", "Selenium Playground Assignment");
        ltOptions.put("name", browser + " - " + platform);
        ltOptions.put("w3c", true);
        ltOptions.put("video", true);      // video recording (assignment requirement)
        ltOptions.put("network", true);    // network logs
        ltOptions.put("console", true);    // console logs
        ltOptions.put("visual", true);     // step screenshots

        WebDriver driver;

        if (browser.equalsIgnoreCase("Firefox")) {
            FirefoxOptions browserOptions = new FirefoxOptions();
            browserOptions.setPlatformName(platform);
            browserOptions.setBrowserVersion(version);
            browserOptions.setCapability("LT:Options", ltOptions);
            driver = new RemoteWebDriver(
                new URL("https://" + username + ":" + accesskey + gridURL), browserOptions);
        } else {
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName(platform);
            browserOptions.setBrowserVersion(version);
            browserOptions.setCapability("LT:Options", ltOptions);
            driver = new RemoteWebDriver(
                new URL("https://" + username + ":" + accesskey + gridURL), browserOptions);
        }

        return driver;
    }
}