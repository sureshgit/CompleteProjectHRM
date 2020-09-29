package com.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.homepage.base.BasePage;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LogInPage;
import com.hubspot.util.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LogInPageTest {

	WebDriver driver;
	BasePage basepage;
	Properties properties;
	LogInPage loginpage;

	HomePage homepage;
	Credentials credentials;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		basepage = new BasePage();
		properties = basepage.driverProperties();
		String browsername = properties.getProperty("browser");
		driver = basepage.driver_init(browsername);
		driver.get(properties.getProperty("url"));
		loginpage = new LogInPage(driver);
		credentials = new Credentials(properties.getProperty("username"), properties.getProperty("password"));

	}

	@Test(priority = 1, groups = "smoke")
	@Description("verify Login Page Title Test.....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyTitleTest() {
		String title = loginpage.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}

	@Test(priority = 2, groups = "sanity")
	@Description("verify Login Page Title Test.....")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyLogInPageTest() {
		homepage = loginpage.logIn(credentials);

	}

	@DataProvider
	public Object[][] getLoginInvalidData() {
		Object data[][] = { { "suresh", "suresh123" },

				{ "surewihdi", "ajdajdasd" }, };
		return data;
	}

	@Test(priority = 3, dataProvider = "getLoginInvalidData", groups = "sanity")
	@Description("verify badLogin Page Title Test.....")
	@Severity(SeverityLevel.NORMAL)
	public void badLogin(String name, String pwd) {
		credentials.setUsername(name);
		credentials.setPassword(pwd);
		loginpage.logIn(credentials);
		Assert.assertTrue(loginpage.loginErrorMsg1());

	}

	@Test(priority = 4, groups = "smoke")
	@Description("verify forgetpwd Test.....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyForgetPwd() {

		Assert.assertTrue(loginpage.forgetPassword());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
