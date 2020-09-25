package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.homepage.base.BasePage;
import com.hubspot.util.Credentials;
import com.hubspot.util.ElementUtil;

public class LogInPage extends BasePage {

	WebDriver driver;
	ElementUtil Elementutil;
	

	// pageObjects

	By username = By.id("txtUsername");
	By password = By.id("txtPassword");
	By login = By.id("btnLogin");
	By forgetpassword = By.xpath("//a[text()='Forgot your password?']");
	By invalidcredentials = By.id("spanMessage");

	public LogInPage(WebDriver driver) {
		this.driver = driver;
		Elementutil = new ElementUtil(driver);

	}

	public String getTitle() {
		return Elementutil.waitForTitleToBePresent("OrangeHRM", 20);
	}

	public boolean forgetPassword() {
		return Elementutil.doIsDisplayed(forgetpassword);
		// Elementutil.doIsDisplayed(forgetpassword);
	}

	public HomePage logIn(Credentials credentials) {

		Elementutil.doSendKeys(username, credentials.getUsername());
		Elementutil.doSendKeys(password, credentials.getPassword());
		Elementutil.doClick(login);

		return new HomePage(driver);
	}

	public boolean loginErrorMsg1() {

		return Elementutil.doIsDisplayed(invalidcredentials);
	}

}
