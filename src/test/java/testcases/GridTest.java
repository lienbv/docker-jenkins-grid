package testcases;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GridTest {
    public static void main(String[] args) {
        // Địa chỉ hub
        String hubURL = "http://192.168.100.247:4444";

        // Chạy trên Chrome
        runTestOnBrowser(hubURL, new ChromeOptions());

        // Chạy trên Firefox
        runTestOnBrowser(hubURL, new FirefoxOptions());
    }

    private static void runTestOnBrowser(String hubURL, Object options) {
        WebDriver driver = null;
        try {
            // Khởi tạo RemoteWebDriver với các tùy chọn
            driver = new RemoteWebDriver(new URL(hubURL), ((DesiredCapabilities) options));
            driver.get("https://www.example.com");
            System.out.println("Title: " + driver.getTitle());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
    WebDriver driver;
    String projectFolder = System.getProperty("user.dir");
    public Platform platform;

    protected WebDriver getBrowserDriver(String browserName, String url, String osName, String ipAddress, String portNumber) {
        Capabilities capability = null;

        if (osName.toLowerCase().contains("windows")) {
            platform = Platform.WINDOWS;
        } else {
            platform = Platform.MAC;
        }

        switch (browserName) {
            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = fOptions;
                break;
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = cOptions;
                break;
            case "edge":
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = eOptions;
                break;
            case "safari":
                SafariOptions sOptions = new SafariOptions();
                sOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = sOptions;
                break;
            default:
                throw new RuntimeException("Browser is not valid!");
        }

        try {
            driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/", ipAddress, portNumber)), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        long time = 15;
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}
