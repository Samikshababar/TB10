package com.Task.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.Listners.Tasks.Methods.ITestTask.class)
public class AlertSample {
	
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
		driver.get("https://demoqa.com/alerts");
	}
	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	
	@Test
	public void alert() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"alertButton\"]")).click();
		driver.switchTo().alert().accept();
		
		
		
		driver.findElement(By.xpath("//*[@id=\"timerAlertButton\"]")).click();
		
		
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(6000);
		
		driver.switchTo().alert().accept();
		
	
		
		
		driver.findElement(By.xpath("//*[@id=\"confirmButton\"]")).click();
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.xpath("//*[@id=\"promtButton\"]")).click();
		driver.switchTo().alert().sendKeys("Samiksha");
		driver.switchTo().alert().accept();
	}
	
	

}
