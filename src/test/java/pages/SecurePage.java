package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class SecurePage extends BasePage {

	public SecurePage(WebDriver driver) {
		super(driver);
	}

	private By successMsg = By.xpath("//div[@id='flash']");

	public String verifyMessage() {
		return getMessage(successMsg);
	}

}
