package SeleniumCorePractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableConcept {
	
	WebDriver driver;

	public static void main(String[] args) {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.abhibus.com/");
		
		
	List<WebElement> dates=driver.findElements(By.className("ui-datepicker-days-cell-over  ui-datepicker-today"));
	System.out.println(dates.size());
	
	for(int i=0;i<dates.size();i++)
	{
		System.out.println(dates.get(i).getText());
		if(dates.get(i).getText().contains("14")){ 
			dates.get(i).click();
			break;
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//WebDriverWait wait=new WebDriverWait(driver, 20);
	//wait.until(ExpectedConditions.visibilityOf(date));
	
	}

}
