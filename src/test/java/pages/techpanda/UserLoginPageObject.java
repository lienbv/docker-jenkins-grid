package pages.techpanda;

import Interfaces.pageUIs.liveTech.user.UserLoginPageUI;
import actions.common.BasePage;
import org.openqa.selenium.WebDriver;

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
