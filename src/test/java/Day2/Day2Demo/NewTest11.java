


package Day2.Day2Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest11 {
	
	WebDriver driver;
	@BeforeClass
	public void beforeMethod()
	{
		System.setProperty("webdriver.chrome.driver","C://Selenium//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com/login");
	}
	@AfterClass
	public void afterMethod()
	{
		driver.close();
	}
	@Test(dataProvider="dp2")
	public void testDemoWebShop(String username,String password)
	{
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		if(driver.findElement(By.linkText("Log out")).isDisplayed())
		{
			Assert.assertEquals(driver.getTitle(),"Demo Web Shop");
			driver.findElement(By.linkText("Log out")).click();
			driver.findElement(By.linkText("Log in")).click();
		}
		else
		{
			Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Login");
		}
		
	}
	@DataProvider(name="dp1")
	public Object[][] getData()
	{
		Object[][] obj= {
							{"askmail@email.com","abc123"},
							{"askmail@gmail.com","abc123"},
							{"askmail@ymail.com","abc123"},
						};
		return obj;
	}
	
	@DataProvider(name="dp2")
	public Object[][] getDataFromExcel()
	{
		return ExcelReader.readExcel();
	}
	

}
