package singletonClassTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		DriverInit instanDriver = DriverInit.getInstance();
		driver = instanDriver.openBrowser();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@Test
	public void testMethod() {
		driver.get("https://www.dccomics.com/");
		System.out.println("The title of this website is "+driver.getTitle()+".");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
