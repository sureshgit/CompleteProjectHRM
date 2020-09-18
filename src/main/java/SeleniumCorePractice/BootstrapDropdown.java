package SeleniumCorePractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropdown {
	
	WebDriver driver;
	@Test
	public void bootdropDown()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='multiselect-selected-text']")).click();
		List<WebElement> listofdropdowns=driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li//a//label"));
		int countofdropdown=listofdropdowns.size();
		System.out.println("count of dropdown "+ countofdropdown);
		//============================================================selecting  checkbox particular dropdown
		/**
		for(int i=0;i<listofdropdowns.size();i++)
		{
			String text=listofdropdowns.get(i).getText();
			System.out.println(text);
			if(listofdropdowns.get(i).getText().contains("HTML"))
			{
				listofdropdowns.get(i).click();
				break;
			}
		}
		//==================================================================
		 * 
		 */
		//clicking allchckbox  dropdown values
		for(int i=0;i<listofdropdowns.size();i++)
		{
			String text=listofdropdowns.get(i).getText();//displaying all dropdown 
			System.out.println(text);
			listofdropdowns.get(i).click();//clciking all dropdown values 
			
		
	}

}
}
