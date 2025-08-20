package pages.techpanda;

import Interfaces.pageUIs.liveTech.user.UserHomePageUI;
import actions.common.BasePage;
import org.openqa.selenium.WebDriver;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;
	
	public	UserHomePageObject (WebDriver driver) {
		this.driver =driver;
		
	}

	public UserLoginPageObject openMyAccountLink() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGenerator.getLoginPage(driver);
	}
	

}
