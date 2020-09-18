package SeleniumCorePractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MovetoElementMouse {
	
	
	WebDriver driver;
	@Test
	public void MoveToElement()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/how-to-create-menu-with-submenu-using-css-html/26146#");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		WebElement link=driver.findElement(By.className("menulink"));
		Actions action= new Actions(driver);
		action.moveToElement(link).build().perform();
		driver.findElement(By.linkText("Single Videos")).click();
		System.out.println("scuess");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
