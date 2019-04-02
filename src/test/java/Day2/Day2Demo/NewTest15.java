package Day2.Day2Demo;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest15 {
	
	@Test
	public void testJS()
	{
		System.setProperty("webdriver.chrome.driver","C://Selenium//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		/*
		 * driver.get("http://www.hdfcbank.com/"); driver.manage().window().maximize();
		 * //driver.findElement(By.id("netsafe")).click(); JavascriptExecutor
		 * js=(JavascriptExecutor) driver;
		 * js.executeScript("document.getElementById('netsafe').click()");
		 * js.executeScript("window.scrollBy(0,1000)");
		 */
		driver.get("http://demowebshop.tricentis.com/login");
		WebElement email=driver.findElement(By.id("Email"));
		int j=10;
		js.executeScript("arguments[0].value='askmail@email.com'",new Object[] {email,j});
		driver.findElement(By.id("Password")).sendKeys("abc123");
		String title=(String) js.executeScript("return document.title");
		System.out.println(title);
		//js.executeScript("var email=document.getElementById('Password').value;alert(email)");
	}

}