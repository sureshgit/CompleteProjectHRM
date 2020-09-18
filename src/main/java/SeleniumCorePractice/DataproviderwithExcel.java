package SeleniumCorePractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hubspot.util.ExcelUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataproviderwithExcel {
	WebDriver driver;

	By emailid = By.id("email_create");
	By pwd = By.id("passwd");
	By submit = By.id("SubmitLogin");
	By firstname = By.id("customer_firstname");
	By lastname = By.id("customer_lastname");
	By radio = By.id("id_gender1");
	By buttion = By.id("SubmitCreate");
	By password = By.id("passwd");
	// WebElement day=(WebElement) By.id("days");

	@DataProvider
	public Object[][] getLoginInvalidData() {
		Object data[][] = ExcelUtil.getTestData("DataTest");
		return data;
	}

	@Test(dataProvider = "getLoginInvalidData")
	public void filledByDataprovider(String st, String stt, String pwd,String firstnam,String lastna,String company,String address,String address2 ,String city,String zipcode,String additionalinf,String phonenumber,String mobilenumber) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();

		driver.findElement(emailid).sendKeys("msuresh5226@gmail.com");
		driver.findElement(buttion).click();
		driver.findElement(radio).click();
		driver.findElement(firstname).sendKeys(st);
		driver.findElement(lastname).sendKeys(stt);
		driver.findElement(password).sendKeys(pwd);
		WebElement days = driver.findElement(By.id("days"));

		Select s = new Select(days);
		s.selectByIndex(3);

		WebElement month = driver.findElement(By.id("months"));
		Select months = new Select(month);
		//months.selectByVisibleText("February");
		months.selectByValue("4");

		WebElement years = driver.findElement(By.id("years"));
		Select yearss = new Select(years);
		yearss.selectByValue("2018");
		driver.findElement(By.id("newsletter")).click();  
		driver.findElement(By.id("optin")).click(); 
		driver.findElement(By.id("firstname")).sendKeys(firstnam);
		driver.findElement(By.id("lastname")).sendKeys(lastna);  
		driver.findElement(By.id("company")).sendKeys(company);  
		driver.findElement(By.id("address1")).sendKeys(address);  
		
		driver.findElement(By.id("address2")).sendKeys(address2);
		driver.findElement(By.id("city")).sendKeys(city);
		
		WebElement state=driver.findElement(By.id("id_state"));
		Select sat=new Select(state);
		sat.selectByVisibleText("Arizona");
		driver.findElement(By.id("postcode")).sendKeys(zipcode); 
		driver.findElement(By.id("other")).sendKeys(additionalinf);
		driver.findElement(By.id("phone")).sendKeys(phonenumber);
		driver.findElement(By.id("phone_mobile")).sendKeys(mobilenumber);

	}

}
