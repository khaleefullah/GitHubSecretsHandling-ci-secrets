package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.edge.*;

import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public static WebDriver createDriver() {

		String browser = Config.getBrowser();
		boolean headless = Config.isHeadless();

		switch (browser) {
		case "chrome":

			ChromeOptions chromeOptions = new ChromeOptions();

			if (headless) {
				chromeOptions.addArguments("--headless=new");
			}

			WebDriverManager.chromedriver().setup();
			return new ChromeDriver(chromeOptions);

		case "firefox":

			FirefoxOptions firefoxOptions = new FirefoxOptions();

			if (headless) {
				firefoxOptions.addArguments("--headless=new");
			}

			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver(firefoxOptions);

		case "edge":

			EdgeOptions edgeOptions = new EdgeOptions();

			if (headless) {
				edgeOptions.addArguments("--headless=new");
			}

			WebDriverManager.edgedriver().setup();
			return new EdgeDriver(edgeOptions);

		default:
			throw new IllegalArgumentException("Invalid browser passed : " + browser);
		}
	}
}
