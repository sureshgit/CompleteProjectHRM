package com.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.homepage.base.BasePage;
import com.hubspot.pages.ContactsPage;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LogInPage;
import com.hubspot.util.Credentials;
import com.hubspot.util.ElementUtil;

public class ContactsPageTest {

	WebDriver driver;
	BasePage basepage;
	Properties properties;
	LogInPage loginpage;
	HomePage homepage;
	Credentials credentials;
	ContactsPage contactsPage;

	@BeforeMethod
	public void setup() throws InterruptedException {
		basepage = new BasePage();
		properties = basepage.driverProperties();
		String browsername = properties.getProperty("browser");
		driver = basepage.driver_init(browsername);
		driver.get(properties.getProperty("url"));
		loginpage = new LogInPage(driver);
		// homepage = new HomePage(driver);

		credentials = new Credentials(properties.getProperty("username"), properties.getProperty("password"));
		homepage = loginpage.logIn(credentials);
		contactsPage = homepage.gotContactsPage();

	}
	
	@Test
	public void getFilling()
	{
		contactsPage.filling();
	}
	


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
