package com.Listners.Tasks;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners( com.Listners.Tasks.Methods.ITestTask.class)
public class AddToCartFish {
	

	WebDriver driver;
	@BeforeSuite
	public void chrome()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Samiksha\\Desktop\\testing\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
	}
	@BeforeTest
	public void url()
	{
		driver.get("https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH");
	}
	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void getcookie()
	{
		Set<Cookie>s=driver.manage().getCookies();
		System.out.println("Count of cookies:: "+s.size());
	}
	
	@Test
	public void addtocart()
	{
		String title=driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals("JPetStore Demo", title);
		
		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[7]/td/a")).click();
	}
	
	
	@AfterMethod
	public void screenshot()throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(src, new File("C:\\Users\\samiksha\\Desktop\\testing\\Screenshot\\mercury.jpj"));
		// FileUtils.copyDirectoryToDirectory(src, new File("C:\\Users\\samiksha\\Desktop\\testing\\Screenshot\\"));
		  System.out.println("Screenshot taken successfully....");
	}
//	@AfterClass
//	public void deletcookie()
//	{
//		System.out.println("delet cooike");
//	}
	  @AfterTest
			public void conclose()
			{
				System.out.println("close...");
			}

		@AfterSuite
			public void closedriver()
			{
				System.out.println("Success..");
				driver.quit();
			}
}
