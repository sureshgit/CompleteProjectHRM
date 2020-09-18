package com.homepage.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties properties;

	public WebDriver driver_init(String browsername) {
		System.out.println("browsername is "+browsername);
		if (browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			if(properties.getProperty("headless").equals("yes"))
			{
				ChromeOptions co = new ChromeOptions();
				co.addArguments(".....headless");
				driver = new ChromeDriver(co);
			}
			else
			{
				driver = new ChromeDriver();
			}
		}
			
		else if (browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if(properties.getProperty("headless").equals("yes"))
			{
				ChromeOptions co=new ChromeOptions();
				co.addArguments("headless");
				driver = new FirefoxDriver(co);
			}
			else 
			{
				driver = new FirefoxDriver();
			}
			
		} else if (browsername.equals("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		} else {
			System.out.println("need a browser and ");
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

	public Properties driverProperties() {
		properties = new Properties();

		String path = ".\\src\\main\\java\\com\\hubspot\\config\\confi.properties";

		try {
			FileInputStream file = new FileInputStream(path);
			properties.load(file);

		} catch (FileNotFoundException e) {

			System.out.println("some issue with configuration properties ...please correct your config");

		} catch (IOException e) {

			e.printStackTrace();
		}

		return properties;
	}

}
