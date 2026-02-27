package tests;

import base.BaseTest;
import config.Config;
import pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

	@Test
	public void loginTest() {
		LoginPage login = new LoginPage(driver);
		String message = login.enterUserName(Config.getUser()).enterPassword(Config.getPassword()).clickLoginBtn().verifyMessage();
		Assert.assertTrue(message.contains("You logged into a secure area!"));
	}
}
