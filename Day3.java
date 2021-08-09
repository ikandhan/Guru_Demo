package Guru99;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Day3 {
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
/*	public String getUserID() {
		return prop.getProperty("UserID");
	}
	public String getPassword() {
		return prop.getProperty("Password");
	}*/


			public static void main(String[] args) throws IOException {
				FileInputStream fis = new FileInputStream("C:\\Users\\indir\\OneDrive\\Desktop\\TestCase\\Guru1.xlsx");
				XSSFWorkbook workbook=new XSSFWorkbook(fis);
				XSSFSheet sheet= workbook.getSheet("User Credential");
				int rowCount=sheet.getLastRowNum();
				System.out.println(rowCount);
				int columnCount= sheet.getRow(1).getLastCellNum();
				System.out.println(columnCount);
				
			/*	for(int r=0; r<=rowCount; r++)
				{
					XSSFRow row=sheet.getRow(r);
					for(int c=0; c<columnCount; c++)
					{
						XSSFCell cell= row.getCell(c);
						switch(cell.getCellType())
						{
						case STRING: System.out.println(cell.getStringCellValue()); break;
						case NUMERIC: System.out.println(cell.getNumericCellValue()); break;
						case BOOLEAN: System.out.println(cell.getBooleanCellValue()); break;
						}
						System.out.println("|");
						
					}
					System.out.println();
				}
			*/
			/*	Iterator<Row> rowIterator= sheet.iterator();
				while(rowIterator.hasNext())
				{
					XSSFRow row=(XSSFRow) rowIterator.next();
					Iterator<Cell> cellIterator= row.cellIterator();
					while(cellIterator.hasNext())
					{
						XSSFCell cell =(XSSFCell) cellIterator.next();
						switch(cell.getCellType())
						{
						case STRING: System.out.println(cell.getStringCellValue()); break;
						case NUMERIC: System.out.println(cell.getNumericCellValue()); break;
						case BOOLEAN: System.out.println(cell.getBooleanCellValue()); break;
						
						}
					}
				}
				System.out.println(String);
					*/
				System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());
				System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
				
				Day3 init= new Day3();
				init.initializeDriver();
				driver.get(init.getURL());
				driver.findElement(By.name("uid")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
				driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
				String text=driver.findElement(By.xpath("//td[contains(text(),'Manger Id : mngr340158')]")).getText();
				String New="Manger Id : mngr340158";
				//td[contains(text(),'Manger Id : mngr340158')]
				//assert.assertEquals(text, Manger Id : mngr340158);
				while(text.equalsIgnoreCase(New))
				{
					System.out.println("No Problem");
					break;
				}
				
				driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
				driver.switchTo().alert().accept();
				System.out.println("Start of second test case");
				driver.findElement(By.name("uid")).sendKeys(sheet.getRow(2).getCell(0).getStringCellValue());
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys(sheet.getRow(2).getCell(1).getStringCellValue());
				driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
				driver.switchTo().alert().accept();
				System.out.println("End of second test case");
				System.out.println("------------------------");
				System.out.println("Start of Third test case");
				driver.findElement(By.name("uid")).sendKeys(sheet.getRow(3).getCell(0).getStringCellValue());
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys(sheet.getRow(3).getCell(1).getStringCellValue());
				driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
				driver.switchTo().alert().accept();
				System.out.println("End of Third test case");
				System.out.println("------------------------");
				System.out.println("Start of Forth test case");
				driver.findElement(By.name("uid")).sendKeys(sheet.getRow(4).getCell(0).getStringCellValue());
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys(sheet.getRow(4).getCell(1).getStringCellValue());
				driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
				driver.switchTo().alert().accept();
				System.out.println("End of Forth test case");
				System.out.println("------------------------");
			driver.close();
			}

		

}
