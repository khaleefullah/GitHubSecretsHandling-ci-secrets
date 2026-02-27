package core;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	private DriverFactory() {

	}

	public static WebDriver initDriver() {
		if (driver.get() == null) {
			driver.set(DriverManager.createDriver());
		}
		return driver.get();
	}

	public static WebDriver getDriver() {
		if (driver.get() == null) {
			throw new SessionNotCreatedException(
					"WebDriver session is not created. Call the initDriver() to create the session");
		}
		return driver.get();
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}

}
