package testcases.techpanda;

import actions.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.techpanda.UserAccountDashboardPageObject;
import pages.techpanda.UserHomePageObject;
import pages.techpanda.UserLoginPageObject;
import pages.techpanda.UserRegisterPageObject;

public class RegistrationTest extends BaseTest {
    private UserRegisterPageObject registerPage;
    private UserHomePageObject homePage ;
    UserAccountDashboardPageObject accountDashboardPage;
    UserLoginPageObject loginPage;

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://live.techpanda.org/");
        registerPage = new UserRegisterPageObject(driver);
        homePage = new UserHomePageObject(driver);
        accountDashboardPage = new UserAccountDashboardPageObject(driver);
        loginPage = new UserLoginPageObject(driver);
    }

    @Test
    public void TC_REG_001() {
        loginPage = homePage.openMyAccountLink();
        registerPage =	loginPage.clickToCreateAnAccountButton();

        registerPage.inputToFirstNameTextBox("John");
        registerPage.inputToLastNameTextBox("Doe");
        registerPage.inputToMiddleNameTextBox("Linda");
        registerPage.inputToEmailTextBox("john.doe" +generateRandomNumber() + "@gmail.com");
        registerPage.inputToPasswordTextBox("P@ssw0rd123");
        registerPage.inputToConfirmPasswordTextBox("P@ssw0rd123");
        registerPage.isSubscribed(false);

        accountDashboardPage= registerPage.clickToRegisterButton();
        Assert.assertEquals(accountDashboardPage.getSuccessMessageText(), "Thank you for registering with Main Website Store.");
    }

    @Test
    public void TC_REG_002() {
        loginPage = homePage.openMyAccountLink();
        registerPage =	loginPage.clickToCreateAnAccountButton();

        registerPage.inputToFirstNameTextBox("");
        registerPage.inputToLastNameTextBox("");
        registerPage.inputToMiddleNameTextBox("");
        registerPage.inputToEmailTextBox("");
        registerPage.inputToPasswordTextBox("");
        registerPage.inputToConfirmPasswordTextBox("");
        registerPage.isSubscribed(false);

        accountDashboardPage= registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getTextError(), "This is a required field.");
    }

    @Test
    public void TC_REG_003() {
        loginPage = homePage.openMyAccountLink();
        registerPage =	loginPage.clickToCreateAnAccountButton();

        registerPage.inputToFirstNameTextBox("John");
        registerPage.inputToLastNameTextBox("Doe");
        registerPage.inputToMiddleNameTextBox("Linda");
        registerPage.inputToEmailTextBox("test!@gmail.com");
        registerPage.inputToPasswordTextBox("P@ssw0rd123");
        registerPage.inputToConfirmPasswordTextBox("P@ssw0rd123");
        registerPage.isSubscribed(false);

        accountDashboardPage= registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getTextError(), "This is a required field.");
    }

    @Test
    public void TC_REG_004() {
        loginPage = homePage.openMyAccountLink();
        registerPage =	loginPage.clickToCreateAnAccountButton();

        registerPage.inputToFirstNameTextBox("John");
        registerPage.inputToLastNameTextBox("Doe");
        registerPage.inputToMiddleNameTextBox("Linda");
        registerPage.inputToEmailTextBox("john.doe" +generateRandomNumber() + "@gmail.com");
        registerPage.inputToPasswordTextBox("P@ssw0rd124");
        registerPage.inputToConfirmPasswordTextBox("P@ssw0rd123");
        registerPage.isSubscribed(false);

        accountDashboardPage= registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getTextErrorPass(), "Please make sure your passwords match.");
    }

    @Test
    public void TC_REG_005() {
        loginPage = homePage.openMyAccountLink();
        registerPage =	loginPage.clickToCreateAnAccountButton();

        registerPage.inputToFirstNameTextBox("John");
        registerPage.inputToLastNameTextBox("Doe");
        registerPage.inputToMiddleNameTextBox("Linda");
        registerPage.inputToEmailTextBox("john.doe@gmail.com");
        registerPage.inputToPasswordTextBox("P@ssw0rd124");
        registerPage.inputToConfirmPasswordTextBox("P@ssw0rd123");
        registerPage.isSubscribed(false);

        accountDashboardPage= registerPage.clickToRegisterButton();

        registerPage.inputToFirstNameTextBox("John01");
        registerPage.inputToLastNameTextBox("Doe01");
        registerPage.inputToMiddleNameTextBox("Linda01");
        registerPage.inputToEmailTextBox("john.doe@gmail.com");
        registerPage.inputToPasswordTextBox("P@ssw0rd124");
        registerPage.inputToConfirmPasswordTextBox("P@ssw0rd123");
        registerPage.isSubscribed(false);

        accountDashboardPage= registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getTextErrorPass(), "The specified email already exists");
    }

    @Test
    public void TC_REG_006() {
        loginPage = homePage.openMyAccountLink();
        registerPage =	loginPage.clickToCreateAnAccountButton();

        registerPage.inputToFirstNameTextBox("John");
        registerPage.inputToLastNameTextBox("Doe");
        registerPage.inputToMiddleNameTextBox("Linda");
        registerPage.inputToEmailTextBox("john.doe" +generateRandomNumber() + "@gmail.com");
        registerPage.inputToPasswordTextBox("123");
        registerPage.inputToConfirmPasswordTextBox("123");
        registerPage.isSubscribed(false);

        accountDashboardPage= registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getTextErrorPass(), "Please enter 6 or more characters without leading or trailing spaces.");
    }

}
