package singletonWebdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;

public class TestBase {

	// -> Singleton Pattern (driver can only be initialized once)
	public static WebDriver driver = null;

	public static void initialize() {

		if (driver == null) {
			if (Constants.browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if (Constants.browserName.equalsIgnoreCase("Firefox")) {
				FirefoxDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(Constants.url);

	}

	public static void quit() {
		System.out.println("quitting the browser");
		driver.quit();
		driver = null;
	}

	public static void close() {
		System.out.println("closing the browser");
		driver.close();
		driver = null;
	}

}
