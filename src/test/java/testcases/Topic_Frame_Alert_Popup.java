package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_Frame_Alert_Popup {

    WebDriver driver;
    WebDriverWait explicitWait;
    By resultText = By.cssSelector("p#result");
    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
    }
    @Test
    public void test() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();
        sleep(2);

        Assert.assertEquals(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(resultText)).getText(), "You clicked an alert successfully");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    public void sleep(int millis) {
        try {
            Thread.sleep(millis*1000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
