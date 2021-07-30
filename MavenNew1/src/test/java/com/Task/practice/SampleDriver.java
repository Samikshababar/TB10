package com.Task.practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



//#Use possible  webdriver metods on any websites(Create a seprate class for webdriver methods)

@Listeners(com.Listners.Tasks.Methods.ITestTask.class)
public class SampleDriver {
	WebDriver driver;
	@BeforeSuite
	public void browser()
	{

		System.setProperty("webdriver.chrome.driver","C:\\Users\\samiksha\\Desktop\\testing\\chromedriver_win32\\chromedriver.exe");// fully qualified name of chrome path
		driver=new ChromeDriver();
	
	}
	
	@BeforeTest
	public void url()
	{
		// get method
		driver.get("http://demowebshop.tricentis.com/login");
	}
	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	@Test(dataProvider = "logindata")
	public void login(String uname,String pass)
	{
		// getTitle method
		String s=driver.getTitle();
		System.out.println("Title:: "+s);
		
		//get current url method
		String s1=driver.getCurrentUrl();
		System.out.println("CurrentUrl:: "+s1);
		
		//getpage source method
		String s2=driver.getPageSource();
		System.out.println(s2);
		
		Assert.assertEquals("http://demowebshop.tricentis.com/login", s1);
		
		// findElement method
		driver.findElement(By.xpath("//input[@class='email']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@class='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	}
	@DataProvider(name="logindata")
	public Object[][] demo()
	{		
		return new Object[][]
		{
			{"Sam@123gmail.com","123456"}
		};
	}
	
	@AfterMethod
	public void screenshot()throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(src, new File("C:\\Users\\samiksha\\Desktop\\testing\\Screenshot\\mercury.jpj"));
		//  FileUtils.copyDirectoryToDirectory(src, new File("C:\\\\Users\\\\samiksha\\\\Desktop\\\\testing\\\\Screenshot\\\\"));
		  System.out.println("Screenshot taken successfully....");
	}
	@AfterClass
	public void deletcookie()
	{
		System.out.println("delet cooike");
	}
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
