package testcases.grid;

import actions.common.BaseGridTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FacebookTest extends BaseGridTest {
    WebDriver driver;

    @Parameters({ "browser", "url", "osName", "ipAddress", "port" })
    @BeforeClass
    public void beforeClass(String browserName, String url, String osName, String ipAddress, String portNumber) {
        driver = getBrowserDriver(browserName, url, osName, ipAddress, portNumber);
        sleepInSecond(2);
    }

    @Test
    public void testFB() {
        driver.get("https://www.facebook.com");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");

        System.out.println("Title: " + driver.getTitle());
        sleepInSecond(10);
    }
    public void sleepInSecond(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
