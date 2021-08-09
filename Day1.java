package Guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day1 {

	public static void main(String[] args) {
		
		/*UserID = //label[@id="message23"]
				Password =//input[@name="password"]
				Login = //input[@name="btnLogin"]
				Reset = //input[@name="btnReset"]
				Title = //h2[@class='barone'] */
		
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\indir\\eclipse-workspace\\SeleniumProject\\src\\WebDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/V4/");
		
		System.out.println(driver.findElement(By.xpath("//h2[@class='barone']")).getText());
		System.out.println(driver.getTitle());
		driver.findElement(By.name("uid")).sendKeys("mngr340158");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("upEjEvu");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

	}

}
