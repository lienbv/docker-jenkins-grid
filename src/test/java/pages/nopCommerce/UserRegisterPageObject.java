package pages.nopCommerce;

import Interfaces.pageUIs.RegisterPageUI;
import common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to Register button")
    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public String getErrorMessageAtFirstnameTextbox() {
        waitForElementVisible(driver,RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
        return  getElementText(driver,RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
    }

    public String getErrorMessageAtLastnameTextbox() {
        waitForElementVisible(driver,RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
        return  getElementText(driver,RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver,RegisterPageUI.EMAIL_ERROR_MESSAGE);
        return  getElementText(driver,RegisterPageUI.EMAIL_ERROR_MESSAGE);
    }

    public String getErrorMessageAtPasswordTextbox() {
        waitForElementVisible(driver,RegisterPageUI.PASSWORD_ERROR_MESSAGE);
        return  getElementText(driver,RegisterPageUI.PASSWORD_ERROR_MESSAGE);
    }

    public String getErrorMessageAtConfirmPasswordTextbox() {
        waitForElementVisible(driver,RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
        return  getElementText(driver,RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    @Step("Enter to firstname textbox with value is {0}")
    public void inputFirstNameTextBox(String firstname) {
        waitForElementVisible(driver,RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstname);
    }
    @Step("Enter to Lastname textbox with value is {0}")
    public void inputToLastNameTextbox(String lastName) {
        waitForElementVisible(driver,RegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUI.LAST_NAME_TEXTBOX,lastName);
    }

    @Step("Enter to Email textbox with value is {0}")
    public void inputToEmailTextbox(String emailAddres) {
        waitForElementVisible(driver,RegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX,emailAddres);
    }

    @Step("Enter to Password textbox with value is {0}")
    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver,RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUI.PASSWORD_TEXTBOX,password);
    }

    @Step("Enter to Confirm Password textbox with value is {0}")
    public void inputToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,confirmPassword);
    }


    @Step("Verify register success message is displayed")
    public String getRegisterSuccessMessage() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return  getElementText(driver,RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }


//    public UserHomePageObject clickToLogoutLink() {
//        waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
//        clickToElement(driver,RegisterPageUI.LOGOUT_LINK);
//        //2 return new HomePageObject(driver);
//        return PageGeneratorManager.getUserHomePage(driver);
//    }

    public String getErrorExistingEmailMessage() {
        waitForElementClickable(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
        return  getElementText(driver,RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
    }




}
