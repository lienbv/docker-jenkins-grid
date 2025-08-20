package pages.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveTech.user.UserAccountDashBoardPageUI;

public class UserAccountDashboardPageObject extends BasePage {
	private WebDriver driver;
	
	public	UserAccountDashboardPageObject (WebDriver driver) {
		this.driver =driver;
		
	}
	
	public String getSuccessMessageText() {
		waitForAllElementVisible(driver, UserAccountDashBoardPageUI.SUCCESS_MESSAGE);
		return getElementText(driver, UserAccountDashBoardPageUI.SUCCESS_MESSAGE);
	}

	
	

}
