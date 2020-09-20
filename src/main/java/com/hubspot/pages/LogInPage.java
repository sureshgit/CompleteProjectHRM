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
	By loginErrorMsg=By.id("spanMessage");

	public LogInPage(WebDriver driver) {
		this.driver = driver;
		Elementutil = new ElementUtil(driver);

	}

	public String getTitle() {
		return Elementutil.elementGetTitle();
	}

	public boolean forgetPassword() {
		return Elementutil.elementIsdisplayed(forgetpassword);
	}

	public HomePage logIn(Credentials credentials) {
		// driver.findElement(username).sendKeys(usernam);
		// driver.findElement(password).sendKeys(pwd);
		// driver.findElement(login).click();

		Elementutil.elementSendkeys(username, credentials.getUsername());
		Elementutil.elementSendkeys(password, credentials.getPassword());
		Elementutil.elementClick(login);
		

		return new HomePage(driver);
	}
	
	
	public boolean loginErrorMsg1()
	{
		return Elementutil.elementIsdisplayed(loginErrorMsg);
	}
	
	

}
