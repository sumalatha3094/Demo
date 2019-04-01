package Day2.Day2Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromdriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
    }
}
