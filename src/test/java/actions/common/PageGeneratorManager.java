package common;

import org.openqa.selenium.WebDriver;
import pages.nopCommerce.UserHomePageObject;
import pages.nopCommerce.UserLoginPageObject;
import pages.nopCommerce.UserRegisterPageObject;

public class PageGeneratorManager {
    public static UserHomePageObject getUserHomePage(WebDriver driver) {
        return new UserHomePageObject(driver);
    }

    public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
        return new UserLoginPageObject(driver);
    }

    public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
        return new UserRegisterPageObject(driver);
    }

}
