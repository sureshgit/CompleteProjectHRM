package SeleniumCorePractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Synchronization {
	
	WebDriver driver;
	//static WebDriverWait rwait ;
	@Test
	public void handleSynchronization()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		WebElement email=driver.findElement(By.id("email"));
		//driver.switchTo().frame(index)
		
		
		
		Explicicttlywait(driver, 20, email, "suresh@gmail.com");
		
}
	
	public    void Explicicttlywait(WebDriver driver,int time,WebElement element1,String value)
	{
		WebDriverWait rwait ;
		
		rwait=new WebDriverWait(driver, 20);
		rwait.until(ExpectedConditions.visibilityOf(element1));
		element1.sendKeys(value);
	}

}
