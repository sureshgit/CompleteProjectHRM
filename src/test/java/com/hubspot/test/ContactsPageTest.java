package com.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.homepage.base.BasePage;
import com.hubspot.pages.ContactsPage;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LogInPage;
import com.hubspot.util.Credentials;
import com.hubspot.util.ElementUtil;
import com.hubspot.utils.ExcelUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ContactsPageTest {

	WebDriver driver;
	BasePage basepage;
	Properties properties;
	LogInPage loginpage;
	HomePage homepage;
	Credentials credentials;
	ContactsPage contactsPage;
	public ExcelUtil excelutil;
	ElementUtil elementutil;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException {
		basepage = new BasePage();
		properties = basepage.driverProperties();
		String browsername = properties.getProperty("browser");
		driver = basepage.driver_init(browsername);
		driver.get(properties.getProperty("url"));
		loginpage = new LogInPage(driver);

		credentials = new Credentials(properties.getProperty("username"), properties.getProperty("password"));
		homepage = loginpage.logIn(credentials);
		contactsPage = homepage.getContactsPage();
		elementutil = new ElementUtil(driver);

	}

	@DataProvider()
	public Object[][] getContactData() {
		Object data[][] = ExcelUtil.getTestData("DataTest");
		return data;

	}

	@Test(priority = 0, dataProvider = "getContactData", groups = "sanity")
	@Description("verify contacts  Page Title Test.....")
	@Severity(SeverityLevel.CRITICAL)
	public void getFilling(String empnam, String username, String pwd, String confpwd) {
		contactsPage.filling(empnam, username, pwd, confpwd);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
