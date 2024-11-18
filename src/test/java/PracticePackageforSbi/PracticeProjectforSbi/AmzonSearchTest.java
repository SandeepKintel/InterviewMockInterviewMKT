package PracticePackageforSbi.PracticeProjectforSbi;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmzonSearchTest 

{
	@Test
	public void searchTest()
	{
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("shoe"+Keys.ENTER);
		//driver.findElement(By.xpath("//span[@class='rush-component s-latency-cf-section']/div/div[3]")).click();
		driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).click();
		
		Set<String> windowhandle = driver.getWindowHandles();
		Iterator i1 = windowhandle.iterator();
		String ParentWindow=(String) i1.next();
		String ChildWindow = (String) i1.next();
		driver.switchTo().window(ChildWindow);
		driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("9716250778");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Intel@22August");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
		
		
		
		
	}

}
