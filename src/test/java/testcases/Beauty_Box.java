package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Beauty_Box {
    WebDriver driver;
    long time = 15;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void test() {
        driver.get("https://beautybox.com.vn/");

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
