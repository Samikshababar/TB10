package com.Task.practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Listeners(com.Listners.Tasks.Methods.ITestTask.class)
public class Opencart {

	
	WebDriver driver;
	@BeforeSuite
	public void browser()
	{

		System.setProperty("webdriver.chrome.driver","C:\\Users\\samiksha\\Desktop\\testing\\chromedriver_win32\\chromedriver.exe");// fully qualified name of chrome path
		driver=new ChromeDriver();
	
	}
	
	@BeforeTest
	public void url() throws InterruptedException
	{
		
		driver.get("https://www.opencart.com/index.php?route=account/register");
	//	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Thread.sleep(8000);
	}
	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void cookie()
	{
		System.out.println("-----------Add cookie----------");
	}
	
	@Test
	@Parameters({"A","B","C","D","E","F"})
	//@Parameters({"user","name","lname","email","country","pass"})
	public void register(String A,String B,String C,String D,String E,String F)
	{
		driver.findElement(By.xpath("//*[@id=\"input-username\"]")).sendKeys(A);
		driver.findElement(By.cssSelector("input#input-firstname")).sendKeys(B);
		driver.findElement(By.cssSelector("input#input-lastname")).sendKeys(C);
		driver.findElement(By.xpath("input[name^=\"em\"]")).sendKeys(D);
		driver.findElement(By.xpath("//*[@id=\"input-country\"]")).sendKeys(E);
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(F);
		driver.findElement(By.xpath("//*[@id=\"button-register\"]/button[1]")).click();
		
		System.out.println("register sucess");
		
	}
//	@Test(priority = 1)
//	public void login(String email,String pass)
//	{
//		driver.get("https://www.opencart.com/index.php?route=account/login");
//		
//		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(email);
//
//		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(pass);
//
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[2]/div/div[1]/form/div[3]/div[1]/button[1]")).click();
//	System.out.println("Login success");
	
//	}
	

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
		System.out.println("-----delet cooike-----");
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
				//driver.quit();
			}
	
}
