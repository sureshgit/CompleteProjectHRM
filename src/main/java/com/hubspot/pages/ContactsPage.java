package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.homepage.base.BasePage;
import com.hubspot.util.ElementUtil;

public class ContactsPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	By employeename = By.id("systemUser_employeeName_empName");
	By username = By.id("systemUser_userName");
	By password = By.id("systemUser_password");
	By confipassword = By.id("systemUser_confirmPassword");
	// By save = By.id("btnSave");
	By save = By.xpath("//input[@type='button' and @name='btnSave']");
	By pim = By.xpath("//b[text()='PIM']");
	By custome = By.linkText("Custom Fields");

	public ElementUtil filling(String empname, String usernam, String passwod, String confpassword) {

		elementUtil.doSendKeys(employeename, empname);
		elementUtil.doSendKeys(username, usernam);
		elementUtil.doSendKeys(password, passwod);
		elementUtil.doSendKeys(confipassword, confpassword);
		elementUtil.waitForElementToBeClickable(save, 20).click();

		return elementUtil;

	}

	

}
