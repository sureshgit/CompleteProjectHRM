package com.hubspot.test;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class HomePageTest {

	WebDriver driver;
	BasePage basepage;
	Properties properties;
	LogInPage loginpage;
	HomePage homepage;
	Credentials credentials;
	ContactsPage contactpage;

	@BeforeTest
	public void setup() throws InterruptedException {
		basepage = new BasePage();
		properties = basepage.driverProperties();
		String browsername = properties.getProperty("browser");
		driver = basepage.driver_init(browsername);
		driver.get(properties.getProperty("url"));
		loginpage = new LogInPage(driver);
		
		credentials=new Credentials(properties.getProperty("username"), properties.getProperty("password"));
		homepage = loginpage.logIn(credentials);
		
		Thread.sleep(10000);

	}

	@Test(priority = 1)
	public void checkingAdmin() {
		
		String adminclick=homepage.doAdmin();
		Assert.assertEquals(adminclick, "Admin");

	}

	@Test(priority = 2)
	public void checkingWelcome() {
	
		homepage.doWelcome();

	}

	@Test(priority = 3)
	public void checkingInfo() {
		
		String infoclick=homepage.doInfo();
		Assert.assertEquals(infoclick, "My Info");
		
		
		
		
		
	
	}
	@Test(priority = 4)
	public void pagenavigation()
	{
		contactpage=homepage.getContactsPage();
		System.out.println("calling pagenavigation");
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
