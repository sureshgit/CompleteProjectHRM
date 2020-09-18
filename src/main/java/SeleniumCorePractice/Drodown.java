package SeleniumCorePractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drodown {
	WebDriver driver;

	@Test
	public void selectDateDroDown() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/r.php");
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement daydropdown = driver.findElement(By.id("day"));
		WebElement monthdrodpwn = driver.findElement(By.id("month"));
		WebElement yeardrodown = driver.findElement(By.id("year"));

		Select selectday = new Select(daydropdown);
		Select selectmonth = new Select(monthdrodpwn);
		Select selectyear = new Select(yeardrodown);

		List<WebElement> listofmonths = selectmonth.getOptions();
		int count = listofmonths.size();
		
		Assert.assertEquals(listofmonths, 13);
		
		
		System.out.println(count);

		for (WebElement ele : listofmonths) {
			String text = ele.getText();
			System.out.println(text);
		}

		System.out.println("===================================================");

		List<WebElement> listofday = selectday.getOptions();
		int countofdays = listofday.size();
		System.out.println(countofdays);

		for (WebElement ele : listofday) {
			String text = ele.getText();
			System.out.println(text);
		}

		System.out.println("=============================================");
		List<WebElement> listofyear = selectyear.getOptions();
		int countofyears = listofday.size();
		System.out.println(countofyears);

		for (WebElement ele : listofyear) {
			String text = ele.getText();
			System.out.println(text);
		}

		selectday.selectByIndex(4);
		selectmonth.selectByValue("5");
		selectyear.selectByValue("2017");

	}

}
