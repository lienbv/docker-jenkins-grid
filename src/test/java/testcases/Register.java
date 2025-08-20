package testcases;

import actions.common.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Register {
WebDriver driver;
String username,password;

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(String browser) {
        driver = Setup.createDriver(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @Test
    public void testRegister() {
        driver.get("https://demo.guru99.com/");
        WebElement email = driver.findElement(By.xpath("//td[text()='Email ID']/following-sibling::td/input[@name='emailid']"));
        email.sendKeys("phungThiLien" + System.currentTimeMillis() + "@gmail.com");

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit' and @name='btnLogin']"));
        submit.submit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        username =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='User ID :']/following-sibling::td"))).getText();
        password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();

    }

    @Test
    public void testLogin() {

    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
