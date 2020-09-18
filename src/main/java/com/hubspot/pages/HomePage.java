package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.homepage.base.BasePage;
import com.hubspot.util.ElementUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	By buz = By.xpath("//b[text()='Buzz']");
	By Admin = By.xpath("//b[text()='Admin']");
	By Info = By.xpath("//b[text()='My Info']");
	By add = By.xpath("//input[@type='button' and  @id='btnAdd']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	public boolean doWelcome() {

		return elementUtil.elementIsdisplayed(buz);
	}

	public boolean doAdmin() {
		return elementUtil.elementIsdisplayed(Admin);
	}

	public boolean doInfo() {
		return elementUtil.elementIsdisplayed(Info);

	}

	public void clickOContacts() {
		elementUtil.elementClick(Admin);
		elementUtil.elementClick(add);

	}

	public ContactsPage gotContactsPage() {
		clickOContacts();
		return new ContactsPage(driver);
	}

}
