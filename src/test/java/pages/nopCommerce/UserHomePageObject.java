package pages.nopCommerce;

import Interfaces.pageUIs.HomePageUI;
import actions.common.BasePage;
import actions.common.GlobalConstants;
import actions.common.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserHomePageObject extends BasePage {
    private WebDriver driver;

    //constructor
    public  UserHomePageObject(WebDriver driver) {
        //  Biến local
        this.driver = driver;
    }

    @Step("Navigate to Register page")
    public UserRegisterPageObject openRegisterPage() {
        waitForElementClickable(driver,HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGeneratorManager.getUserRegisterPage(driver);

    }
    public void waitForElementClickable(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
    }

    public void checkCapcha(){
        WebElement captchaElements = waitForElementToBeVisible(getWebElement(driver, HomePageUI.CAPTRA));

        if (!captchaElements.isDisplayed()) {
            System.out.println("CAPTCHA xuất hiện, đang xử lý...");

            new java.util.Scanner(System.in).nextLine();

// Click vào checkbox CAPTCHA
            driver.findElement(By.cssSelector(".recaptcha-checkbox")).click();

// Quay lại trang chính
            driver.switchTo().defaultContent();
        } else {
            System.out.println("Không có CAPTCHA, tiếp tục test.");
        }
    }

    private long longTimeout = GlobalConstants.LONG_TIMEOUT;
    private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
}
