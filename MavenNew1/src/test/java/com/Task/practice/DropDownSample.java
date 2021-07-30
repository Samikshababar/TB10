package com.Task.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownSample {
	
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
	public void m1()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,500)");
        
      driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div/div[1]")).click();
//        
//        driver.findElement(By.xpath("//*[@id=\"item-0\"]")).click();
//        
//        driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("Samiksha");
//        
//        driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("sam@gmail.com");
//        
//        driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("Hadapsar");
//        
//        driver.findElement(By.xpath("//*[@id=\"permanentAddress\"]")).sendKeys("Pune");
        
      //  driver.findElement(By.xpath("//*[@id='submit']")).click();
	
        
        driver.findElement(By.xpath("//*[@id=\"item-1\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label/span[1]")).click();
		
	}

}
