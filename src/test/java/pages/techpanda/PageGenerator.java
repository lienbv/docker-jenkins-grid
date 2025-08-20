package pages.techpanda;

import actions.pageObjects.techpanda.admin.AdminCustomerPageObject;
import actions.pageObjects.techpanda.admin.AdminLoginPageObject;
import org.openqa.selenium.WebDriver;

public class PageGenerator {
	public static UserHomePageObject getHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	public static UserLoginPageObject getLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	public static UserRegisterPageObject getRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	public static UserAccountDashboardPageObject getAccountDashBoardPage(WebDriver driver) {
		return new UserAccountDashboardPageObject(driver);
	}
	
	// Trang Admin
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminCustomerPageObject getAdminCustomerPage(WebDriver driver) {
		return new AdminCustomerPageObject(driver);
	}
}
