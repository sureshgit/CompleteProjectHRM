package com.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.homepage.base.BasePage;
import com.hubspot.pages.ContactsPage;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LogInPage;
import com.hubspot.util.Credentials;

public class HomePageTest {

	WebDriver driver;
	BasePage basepage;
	Properties properties;
	LogInPage loginpage;
	HomePage homepage;
	Credentials credentials;
	ContactsPage contactpage;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		basepage = new BasePage();
		properties = basepage.driverProperties();
		String browsername = properties.getProperty("browser");
		driver = basepage.driver_init(browsername);
		driver.get(properties.getProperty("url"));
		loginpage = new LogInPage(driver);

		credentials = new Credentials(properties.getProperty("username"), properties.getProperty("password"));
		homepage = loginpage.logIn(credentials);

	}

	@Test(priority = 1, groups = "smoke")
	public void checkingAdmin() {

		Assert.assertTrue(homepage.doAdmin());

	}

	@Test(priority = 2, groups = "smoke")
	public void checkingWelcome() {

		homepage.doWelcome();

	}

	@Test(priority = 3, groups = "smoke")
	public void checkingInfo() {

		String infoclick = homepage.doInfo();
		Assert.assertEquals(infoclick, "My Info");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
