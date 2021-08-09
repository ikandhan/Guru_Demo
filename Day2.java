package Guru99;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day2 {
	public static WebDriver driver;
	public Properties prop;
	
	public void initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\indir\\eclipse-workspace\\SeleniumProject\\src\\Guru99\\Util.properties");
		prop.load(fis);
		String BrowserName= prop.getProperty("Browser");
		
		if(BrowserName.equals("Firefox")) {
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\indir\\Downloads\\geckodriver-v0.28.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
		}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public String getURL() {
		return prop.getProperty("URL");
	}
	public String getUserID() {
		return prop.getProperty("UserID");
	}
	public String getPassword() {
		return prop.getProperty("Password");
	}


	public static void main(String[] args) throws IOException {
		
		Day2 init= new Day2();
		init.initializeDriver();
		driver.get(init.getURL());
		driver.findElement(By.name("uid")).sendKeys(init.getUserID());
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(init.getPassword());
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		driver.close();
		
	/*	prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\indir\\eclipse-workspace\\SeleniumProject\\src\\Guru99\\Util.properties");
		prop.load(fis);
		prop.getProperty("Browser");
		prop.getProperty("URL");
		
		//driver.manage().window().maximize();
		

		driver.findElement(By.name("uid")).sendKeys(UserID);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
*/
	}

}
