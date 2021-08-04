package com.log4j.Task;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class MercuryTour {

	static Logger log=Logger.getLogger(MercuryTour.class.getName());
	public WebDriver driver;
	Properties p=new Properties();
	@BeforeSuite
	public void browser() throws IOException
	{
		FileInputStream file=new FileInputStream("");
		p.load(file);
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\samiksha\\Desktop\\testing\\chromedriver_win32\\chromedriver.exe");// fully qualified name of chrome path
		 driver=new ChromeDriver();
		log.debug("Open Browser");
	}
	@BeforeTest
	public void url()
	{
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		log.info("Open Url");
		
	}
	@BeforeClass
	public void max()
	{
		driver.manage().window().maximize();
	}
	
	@Test
	public void register()
	{
 driver.findElement(By.xpath("//input[@name=\"firstName\"]")).sendKeys("Samiksha");;
         
         driver.findElement(By.xpath("//input[@name=\"lastName\"]")).sendKeys("Babar");;
         
         
         driver.findElement(By.xpath("//input[@name=\"phone\"]")).sendKeys("7385684859");;
        
         driver.findElement(By.xpath("//input[@name=\"userName\"]")).sendKeys("Samiksha@hotmail.com");;
         
       driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("hadapsar");;
        
        driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td[2]/input")).sendKeys("pune");;
        
        driver.findElement(By.xpath("//input[@name=\"state\"]")).sendKeys("pune");;
       
        driver.findElement(By.xpath("//input[@name=\"state\"]")).sendKeys("Maharashtra");;
        
        driver.findElement(By.xpath("//input[@name=\"postalCode\"]")).sendKeys("411028");;
        
        WebElement country=driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/select"));
		 
		 Select s1=new Select(country);
		 s1.selectByIndex(2);
		 
		  driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("Samiksha@123");;
		  
		  
		  driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("12345678");;
		  driver.findElement(By.xpath("//input[@name=\"confirmPassword\"]")).sendKeys("12345678");;
        
		  driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();;
	}
	
}
