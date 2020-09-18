package SeleniumCorePractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Adding {
	
	WebDriver driver;
	By admin=By.xpath("//b[text()='Admin']"); 
	By add=By.id("btnAdd");
	By empname=By.id("systemUser_employeeName_empName");  
	By username=By.id("systemUser_userName");
	By pwd=By.id("systemUser_password");
	
	
	
	By usernam = By.id("txtUsername");
	By password = By.id("txtPassword");
	By login = By.id("btnLogin");
	
	
	By confipwd=By.id("systemUser_confirmPassword");
	By save=By.id("btnSave");
	
	@Test
	public void gettingData()
	
	{
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(usernam).sendKeys("Admin");
		driver.findElement(password).sendKeys("admin123");
		driver.manage().window().maximize();		
		driver.findElement(login).click();
		
		driver.findElement(admin).click();
		driver.findElement(add).click();
		driver.findElement(empname).sendKeys("Anna Hamilton");  
		driver.findElement(username).sendKeys("msrangandhv234");
		driver.findElement(pwd).sendKeys("suresh1234567");
		driver.findElement(confipwd).sendKeys("suresh1234567");
		driver.findElement(save).click();
	
		
		
	}

}
