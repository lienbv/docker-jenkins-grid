package actions.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Setup {
    public static WebDriver createDriver(String browser) {
        WebDriver driver = null;
        String hubURL = "http://localhost:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        try {
            if (browser.equalsIgnoreCase("chrome")) {

                capabilities.setCapability("browserName", "chrome");
                driver = new RemoteWebDriver(new URL(hubURL), capabilities);
            } else if (browser.equalsIgnoreCase("firefox")) {
                capabilities.setCapability("browserName", "firefox");
                driver = new RemoteWebDriver(new URL(hubURL), capabilities);
            }
            else if (browser.equalsIgnoreCase("edge")) {
                capabilities.setCapability("browserName", "edge");
                driver = new RemoteWebDriver(new URL(hubURL), capabilities);
            }
            // Có thể thêm các trình duyệt khác nếu cần
        } catch ( MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
