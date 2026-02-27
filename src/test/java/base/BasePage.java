package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.Config;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(Config.getTimeout()));
	}

	public void waitAndClick(By by) {
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void waitAndType(By by, String value) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		element.clear();
		element.sendKeys(value);
	}

	public String getMessage(By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
	}

}
