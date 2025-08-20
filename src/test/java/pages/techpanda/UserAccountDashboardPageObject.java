package pages.techpanda;

import Interfaces.pageUIs.liveTech.user.UserAccountDashBoardPageUI;
import actions.common.BasePage;
import org.openqa.selenium.WebDriver;

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
