package config;

public class Config {

	private static final String KEY_BROWSER = "browser";
	private static final String KEY_BASE_URL = "baseUrl";
	private static final String KEY_USER = "TEST_USER";
	private static final String KEY_PASSWORD = "TEST_PASS";
	private static final String KEY_HEADLESS = "headless";
	private static final String KEY_TIMEOUT = "timeout";

	private static final String DEFAULT_BROWSER = "chrome";
	private static final String DEFAULT_BASE_URL = "https://the-internet.herokuapp.com/login";
	private static final boolean DEFAULT_HEADLESS = false;
	private static final int DEFAULT_TIMEOUT = 10;

	private Config() {

	}

	public static String getBrowser() {
		return System.getProperty(KEY_BROWSER, DEFAULT_BROWSER).trim().toLowerCase();
	}

	public static String getBaseUrl() {
		return System.getProperty(KEY_BASE_URL, DEFAULT_BASE_URL);
	}

	public static String getUser() {
		String user = System.getProperty(KEY_USER, System.getenv(KEY_USER));
		if (user == null || user.isBlank()) {
			throw new IllegalStateException("TEST_USER not provided");
		}
		return user.trim();
	}

	public static String getPassword() {
		String password = System.getProperty(KEY_PASSWORD, System.getenv(KEY_PASSWORD));
		if (password == null || password.isEmpty()) {
			throw new IllegalStateException("TEST_PASS not provided");
		}
		return password.trim();
	}

	public static boolean isHeadless() {
		return Boolean.parseBoolean(System.getProperty(KEY_HEADLESS, String.valueOf(DEFAULT_HEADLESS)));
	}

	public static int getTimeout() {
		try {
			return Integer.parseInt(System.getProperty(KEY_TIMEOUT, String.valueOf(DEFAULT_TIMEOUT)));
		} catch (NumberFormatException e) {
			return DEFAULT_TIMEOUT;
		}
	}

}
