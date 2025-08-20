package pages.techpanda;

import Interfaces.pageUIs.liveTech.user.UserRegisterPageUI;
import actions.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserRegisterPageObject extends BasePage {
	private final WebDriver driver;
	
	public	UserRegisterPageObject (WebDriver driver) {
		this.driver =driver;
		
	}

	

	public void inputToFirstNameTextBox(String firstName) {
		waitForAllElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXT_BOX);
		sendkeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXT_BOX, firstName);
		
	}

	

	public void inputToLastNameTextBox(String lastName) {
		waitForAllElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXT_BOX);
		sendkeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXT_BOX, lastName);
		
	}

	public void inputToMiddleNameTextBox(String middle) {
		waitForAllElementVisible(driver, UserRegisterPageUI.MIDDLE_NAME_TEXT_BOX);
		sendkeyToElement(driver, UserRegisterPageUI.MIDDLE_NAME_TEXT_BOX, middle);

	}

	public void inputToEmailTextBox(String emailAddress) {
		waitForAllElementVisible(driver, UserRegisterPageUI.EMAIL_TEXT_BOX);
		sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXT_BOX, emailAddress);
		
	}

	public void inputToPasswordTextBox(String password) {
		waitForAllElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXT_BOX, password);
		
	}

	public void inputToConfirmPasswordTextBox(String confirmPassword) {
		waitForAllElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX, confirmPassword);
		
	}
	public void isSubscribed(Boolean isSubscribed) {
		try {
			WebElement checkbox = getWebElement(driver, UserRegisterPageUI.SUBSCRIBED);

			if (isSubscribed && !checkbox.isSelected()) {
				checkbox.click(); // Chọn checkbox nếu chưa được chọn
			} else if (!isSubscribed && checkbox.isSelected()) {
				checkbox.click(); // Bỏ chọn nếu đang được chọn
			}
		} catch (Exception e) {
			System.out.println("Không tìm thấy checkbox Subscription: " + e.getMessage());
		}
	}

	public UserAccountDashboardPageObject clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
		return PageGenerator.getAccountDashBoardPage(driver);
	}

	public String getTextError() {
		return getElementText(driver, UserRegisterPageUI.ERROR_MESSAGE);
	}

	public String getTextErrorPass() {
		return getElementText(driver, UserRegisterPageUI.ERROR_MESSAGE_PASS);
	}

}
