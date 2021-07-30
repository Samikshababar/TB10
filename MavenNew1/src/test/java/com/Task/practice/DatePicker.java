package com.Task.practice;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.Listners.Tasks.Methods.ITestTask.class)
public class DatePicker {
	
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
		driver.get("https://jqueryui.com/datepicker/");
	}
	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	
	@Test
	public void pick()
	{
		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("input[id=\"datepicker\"]")).click();
		while(!driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div")).getText().equals("August 2021"))
		{
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
		}
		
		List<WebElement>l=driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td"));
		for(WebElement s:l)
		{
			if(s.getText().equals("20"))
	 		{
				s.click();
			}
			
		}
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
