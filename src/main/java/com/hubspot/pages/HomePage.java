package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.homepage.base.BasePage;
import com.hubspot.util.ElementUtil;
import com.hubspot.util.JavaScriptUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;

	By buz = By.xpath("//b[text()='Buzz']");
	By Admin = By.xpath("//b[text()='Admin']");
	
	
	By MyInfo = By.xpath("//b[text()='My Info']");
	By add = By.id("btnAdd");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil=new JavaScriptUtil(driver);

	}

	public String doWelcome() {

		 elementUtil.waitForElementToBeClickable(buz, 20).click();
		//javaScriptUtil.flash(buz);
		return elementUtil.doGetText(buz);
	}

	public boolean doAdmin() {
		elementUtil.doClick(Admin);
	//	javaScriptUtil.
		
		return elementUtil.doIsDisplayed(Admin);

	}

	public String doInfo() {
		elementUtil.doClick(MyInfo);
		return elementUtil.doGetText(MyInfo);

	}

	public ContactsPage getContactsPage() {
		clickOContacts();
		return new ContactsPage(driver);

	}

	private void clickOContacts() {

		elementUtil.doClick(Admin);
		elementUtil.doClick(add);
		

	}

}
