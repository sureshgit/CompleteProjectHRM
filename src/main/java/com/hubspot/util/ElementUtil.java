package com.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ElementUtil {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement getElement(By locator) {
		//waitForElementPresent(locator);

		WebElement element = null;
		try {
			element = driver.findElement(locator);
			//if (flash.equalsIgnoreCase("yes")) {
				//JavaScriptUtil.flash(element, driver);
			//}
		} catch (Exception e) {
			System.out.println("Some exception occurred while creating webelement " + locator);
		}
		return element;
	}
	
	

	public void elementClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("exception occured while clicking  element");
		}
		
	}

	public void elementSendkeys(By locator, String value) {
		try {
			WebElement ele=getElement(locator);
			ele.clear();
			ele.sendKeys(value);
		} catch (Exception e)

		{
			System.out.println("exception occured while passing svalue by sendkeys element");
		}
	}

	public String elementText(By locator) {
		try {
			return getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("exception occured while finding text");
		}
		return null;
	}

	public boolean elementIsdisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("exception occured while checking disolayed text");
		}
		return false;

	}
	
	public String elementGetTitle()
	{
		return driver.getTitle();
	}

}
