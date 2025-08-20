package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageFactory {
    protected WebDriver driver;
    private WebDriverWait wait;
    public BasePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitForElementToBeVisible (WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public WebElement waitForElementToBeClickable (WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public WebElement waitForElementToBeVisibilityOfElementLocated (By element) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
