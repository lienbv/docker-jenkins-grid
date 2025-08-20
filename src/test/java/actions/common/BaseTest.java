package actions.common;

import actions.factoryEnvironment.EnvironmentList;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
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

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    long time = 15;


    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) throws Exception {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("user-data-dir=C:\\Users\\ADMIN\\AppData\\Local\\Google\\Chrome\\User Data\\");
            options.addArguments("profile-directory=Profile 3");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--disable-blink-features=AutomationControlled");

            driver = new ChromeDriver(options);
            // 🔥 Viết ở đây, sau khi driver được khởi tạo
            ((JavascriptExecutor) driver).executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");

            driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--width=1920", "--height=1080"); // Set fullscreen
            driver = new FirefoxDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
            driver.manage().window().maximize();

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

    public WebDriver getDriverInstance() {
        return this.driver;
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
//            driver.quit();
        }
    }

    public void deleteAllureReport() {
        try {

            String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-json";
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println(listOfFiles[i].getName());
                    new File(listOfFiles[i].toString()).delete();
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
