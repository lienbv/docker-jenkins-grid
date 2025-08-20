package pages.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveTech.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;
	
	public	UserLoginPageObject (WebDriver driver) {
		this.driver =driver;
		
	}

	public UserRegisterPageObject clickToCreateAnAccountButton() {
		waitForElementClickable(driver, UserLoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		clickToElement(driver, UserLoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		return PageGenerator.getRegisterPage(driver);
		
	}

	
	

}
