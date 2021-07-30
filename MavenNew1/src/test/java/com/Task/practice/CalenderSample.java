package com.Task.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalenderSample {
	
	
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
	@Test
	public void calender()
	{
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[2]/div/div/div[4]/div/div/div/div[1]/div/div/div")).click();
		
		while(!driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]")).getText().equals("July 2021"))
				{
			driver.findElement(By.xpath("")).click();
				}
		
		//List<WebElement>l=driver.findElement(By.xpath("/html/body/div[4]/div/div[3]"))
	}

}
