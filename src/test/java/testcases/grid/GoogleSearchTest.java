package testcases.grid;

import actions.common.BaseGridTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

public class GoogleSearchTest extends BaseGridTest {
    WebDriver driver;

    @Parameters({ "browser", "url", "osName", "ipAddress", "port" })
    @BeforeClass
    public void beforeClass(String browserName, String url, String osName, String ipAddress, String portNumber) {
        driver = getBrowserDriver(browserName, url, osName, ipAddress, portNumber);
        sleepInSecond(2);
    }

    @Test
    public void testGoogle() {
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
        sleepInSecond(10);
    }
    @Test
    public void testFail() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Wrong Title");  // Fail test → Zalenium sẽ quay video
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
