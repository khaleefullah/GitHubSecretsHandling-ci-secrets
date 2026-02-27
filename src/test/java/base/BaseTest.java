package base;

import org.openqa.selenium.WebDriver;

import config.Config;
import core.DriverFactory;
import org.testng.annotations.*;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setup() {
		DriverFactory.initDriver();
		driver = DriverFactory.getDriver();
		driver.get(Config.getBaseUrl());
	}

	@AfterMethod
	public void teardown() {
		DriverFactory.quitDriver();
	}

}
