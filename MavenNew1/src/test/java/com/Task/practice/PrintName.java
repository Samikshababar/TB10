package com.Task.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PrintName {
	
	WebDriver driver;
	@BeforeSuite
	public void browser()
	{

		System.setProperty("webdriver.chrome.driver","C:\\Users\\samiksha\\Desktop\\testing\\chromedriver_win32\\chromedriver.exe");// fully qualified name of chrome path
		driver=new ChromeDriver();
	
	}
	
//	@BeforeTest
//	public void url()
//	{
//		// get method
//		driver.get("https://the-internet.herokuapp.com/nested_frames");
//	}
//	@BeforeClass
//	public void maximize()
//	{
//		driver.manage().window().maximize();
//	}
//	
	@Test
	public void left() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		//driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		WebElement frame1Heading = driver.findElement(By.xpath("/html/body"));

		// Finding the text of the frame1 heading
		String frame1Text = frame1Heading.getText();

		// Print the heading
		System.out.println("Text of the frame1 heading is:" + frame1Text);

	}
	

	@Test
	public void middle() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		//driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		WebElement frame1Heading = driver.findElement(By.xpath("/html/body"));

		// Finding the text of the frame1 heading
		String frame1Text = frame1Heading.getText();

		// Print the heading
		System.out.println("Text of the frame1 heading is:" + frame1Text);

	}


}
