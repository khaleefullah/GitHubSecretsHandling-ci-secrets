package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import base.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private By userName = By.id("username");
	private By password = By.id("password");
	private By loginBtn = By.xpath("(//i[@class='fa fa-2x fa-sign-in'])[1]");

	public LoginPage enterUserName(String uName) {
		waitAndType(userName, uName);
		return this;
	}

	public LoginPage enterPassword(String pwd) {
		waitAndType(password, pwd);
		return this;
	}

	public SecurePage clickLoginBtn() {
		waitAndClick(loginBtn);
		return new SecurePage(driver);
	}

}
