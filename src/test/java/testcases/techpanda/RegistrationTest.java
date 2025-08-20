package testcases.nopCommerce;

import actions.common.BaseTest;
import actions.common.GlobalConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.nopCommerce.UserHomePageObject;
import pages.nopCommerce.UserRegisterPageObject;

public class RegistrationTest extends BaseTest {
    private UserRegisterPageObject registerPage;
    private UserHomePageObject homePage ;
    @BeforeMethod
    public void beforeMethod() {
        driver.get(GlobalConstants.PORTAL_DEV_URL);
        registerPage = new UserRegisterPageObject(driver);
        homePage = new UserHomePageObject(driver);
    }

    @Test
    public void TC_REG_001() {
        registerPage= homePage.openRegisterPage();
        registerPage.inputFirstNameTextBox("John");
        registerPage.inputToLastNameTextbox("Doe");
        registerPage.inputToEmailTextbox("john.doe@example.com");
        registerPage.inputTCompanyTextbox("Electronic");
        registerPage.selectNewsletter();
        registerPage.inputToPasswordTextbox("P@ssw0rd123");
        registerPage.inputToConfirmPasswordTextbox("P@ssw0rd123");

        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
    }

}
