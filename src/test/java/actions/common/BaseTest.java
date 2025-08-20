package common;

import factoryEnvironment.EnvironmentList;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) throws Exception {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized", "--disable-notifications");
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--width=1920", "--height=1080"); // Set fullscreen
            driver = new FirefoxDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--start-maximized");
            driver = new EdgeDriver(options);

        } else {
            throw new IllegalArgumentException("Trình duyệt không được hỗ trợ: " + browser);
        }
    }

    protected String getEnvironmentUrl(String serverName) {
        String envUrl = null;
        EnvironmentList environment = EnvironmentList.valueOf(serverName.toUpperCase());
        switch (environment) {
            case DEV:
                envUrl = "https://demo.nopcommerce.com/";
                break;
            case TESTING:
                envUrl = "https://testing.nopcommerce.com";
                break;
            case STAGING:
                envUrl = "https://staging.nopcommerce.com";
                break;
            case PRE_PRODUCTION:
                envUrl = "https://pre-prod.nopcommerce.com";
                break;

            case PROD:
                envUrl = "https://prod.nopcommerce.com";
                break;

            default:
                envUrl = null;
                break;
        }
        return envUrl;
    }

    public long generateRandomNumber() {
        return System.currentTimeMillis();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
//            driver.quit();
        }
    }
}
