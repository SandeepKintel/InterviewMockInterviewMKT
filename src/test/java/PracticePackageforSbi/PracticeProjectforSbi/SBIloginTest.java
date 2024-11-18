package PracticePackageforSbi.PracticeProjectforSbi;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SBIloginTest
{
	@Test(dataProvider = "inputs")
	public void TestSBIlogin(String username , String password) throws InterruptedException
	{

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://retail.onlinesbi.sbi/retail/login.htm");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//a[contains(text(),'CONTINUE TO LOGIN')])[1]")).click();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
	}
	
	@DataProvider(name="inputs")
	public Object[][] dataset() throws EncryptedDocumentException, IOException
	{
		FileInputStream f1 = new  FileInputStream("C:\\Users\\sandeep.kumar\\eclipse-workspace\\PracticeProjectforSbi\\Credentials.xlsx");
		Workbook w1 = WorkbookFactory.create(f1);
		String username = w1.getSheet("creds").getRow(1).getCell(0).getStringCellValue();
		String password = w1.getSheet("creds").getRow(1).getCell(1).getStringCellValue();
		String username02 = w1.getSheet("creds").getRow(2).getCell(0).getStringCellValue();
		String password02 = w1.getSheet("creds").getRow(2).getCell(1).getStringCellValue();
		
		Object[][] obj = new Object[2][2];
		obj[0][0]= username;
		obj[0][1]= password;
		obj[1][0]= username02;
		obj[1][1]= password02;
		
		return obj;
	}

	
	
	

}
