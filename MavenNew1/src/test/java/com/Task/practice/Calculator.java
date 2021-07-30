package com.Task.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.Listners.Tasks.Methods.ITestTask.class)
public class Calculator {
	
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
		driver.get("https://testsheepnz.github.io/BasicCalculator.html");
	}
	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	@Test(priority = -1)
	public void add()
	{
		
		driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("10");
		driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("10");
		
		WebElement sel=	driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
		Select s=new Select(sel);
		s.selectByIndex(0);
		
		driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
		
		WebElement ans= driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
		String val=ans.getAttribute("value");
		System.out.println("Total of addition:: "+val);
		
	}
	@Test(priority = 1)
	public void sub() throws InterruptedException
	{
		
		Thread.sleep(3000);
		driver.get("https://testsheepnz.github.io/BasicCalculator.html");
		driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("20");
		driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("10");
		
		WebElement sel1=	driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
		Select s1=new Select(sel1);
		s1.selectByIndex(1);
		
		driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
		
		//driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).clear();
		WebElement ans1= driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
		String val1=ans1.getAttribute("value");
		System.out.println("Total of sub:: "+val1);
	}
	@Test(priority = 2)
	public void mul() throws InterruptedException
	{
		
		Thread.sleep(3000);
		driver.get("https://testsheepnz.github.io/BasicCalculator.html");
		driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("20");
		driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("10");
		
		WebElement sel1=driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
		Select s1=new Select(sel1);
		s1.selectByIndex(2);
		
		driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
		
		//driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).clear();
		WebElement ans1= driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
		String val1=ans1.getAttribute("value");
		System.out.println("Total of multiplication:: "+val1);
	}
	@Test(priority = 3)
	public void div() throws InterruptedException
	{
		
		Thread.sleep(3000);
		driver.get("https://testsheepnz.github.io/BasicCalculator.html");
		driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("20");
		driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("10");
		
		WebElement sel1=driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
		Select s1=new Select(sel1);
		s1.selectByIndex(3);
		
		driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
		
		//driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).clear();
		WebElement ans1= driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
		String val1=ans1.getAttribute("value");
		System.out.println("Total of div:: "+val1);
	}
	
	@Test(priority = 4)
	public void concate() throws InterruptedException
	{
		
		Thread.sleep(3000);
		driver.get("https://testsheepnz.github.io/BasicCalculator.html");
		driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("20");
		driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("10");
		
		WebElement sel1=driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
		Select s1=new Select(sel1);
		s1.selectByIndex(4);
		
		driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
		
		//driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).clear();
		WebElement ans1= driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
		String val1=ans1.getAttribute("value");
		System.out.println("Concatination:: "+val1);
	}

}
