package singletonWebDriverTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import singletonWebdriver.Constants;
import singletonWebdriver.TestBase;

public class SeleniumTestClass {

	@BeforeMethod
	public void setUp() {
		TestBase.initialize();
	}

	@Test(priority = 1)
	public void verifySeleniumTitleTest() {
		String title = TestBase.driver.getTitle();
		System.out.println("Page title is: " + title);
		Assert.assertEquals(title, Constants.loginPageTitle);
	}

	@Test(priority = 2)
	public void logoTest() {
		Assert.assertEquals(TestBase.driver.findElement(By.xpath("//*[@id=\"header\"]/a[1]/img[1]")).isDisplayed(), true);
	}

	@AfterMethod
	public void tearDown() {
		TestBase.quit();
	}

}
