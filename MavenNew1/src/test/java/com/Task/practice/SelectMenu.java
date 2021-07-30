 package com.Task.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectMenu {
	
	
		
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
		driver.get("https://jqueryui.com/selectmenu/");
	}
	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	
	@Test
	public void m1()
	{
	driver.switchTo().frame(0);
//		WebElement medium=driver.findElement(By.xpath("//*[@id=\"speed-button\"]"));
//		Select s=new Select(medium);
//		s.selectByIndex(3);
		
	WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"speed-button\"]/span[2]")));
		dropdown.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ui-id-4']"))).click();

		WebElement selectafile = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='files-button']/span[1]")));
		selectafile.click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ui-id-7']"))).click();

		WebElement number = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='number-button']/span[1]")));
		number.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ui-id-12']"))).click();
		
		
		WebElement title = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='salutation-button']/span[1]")));
		title.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ui-id-30']"))).click();
	}
	
	
	

}
