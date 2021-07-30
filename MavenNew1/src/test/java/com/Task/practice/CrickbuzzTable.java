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
public class CrickbuzzTable {
	
	//# Print the name And runs of player
	//#Print Balls ,fours & Six
	//https://www.cricbuzz.com/live-cricket-scorecard/36272/wi-vs-aus-5th-t20i-australia
	
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
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/36272/wi-vs-aus-5th-t20i-australia");
	}
	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void m1()
	{
	WebElement in1=driver.findElement(By.xpath("//*[@id=\"innings_1\"]/div[1]"));
	
	//Total no of inning
	List<WebElement> totalin = driver.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']"));

	System.out.println("Total count" + totalin.size());

	//first In

	 	List<WebElement> indata=in1.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']"));
	 	
	 	
	 	int count1=indata.size();
	 	
	 	System.out.println("In 1--"+indata.size());
	 	
	 	//Run
	 	int sum=0;
	 	int x=0;
	 	for(int i=1;i<count1-3;i++)
	 	{
	 		String value1=in1.findElements(By.cssSelector("div[class=\"cb-col cb-col-100 cb-scrd-itms\"] :nth-child(4)")).get(i).getText();
	 		String Svalue2 = in1.findElements(By.xpath("//*[@id='innings_2']/div[1]/div/div[1]/a")).get(x)
			.getText();
	 		
	 		x++;

			int Srunvalue = Integer.parseInt(value1);

			System.out.println(Svalue2+" : " + Srunvalue);

			sum = sum + Srunvalue;
	 	
	 	
	 	}
	 	System.out.println("Sum of total run:: "+sum);
	 	
	}
	@Test(priority = 2)
	public void m2()
 	{
		
		WebElement in1=driver.findElement(By.xpath("//*[@id=\"innings_1\"]/div[1]"));
		
		//Total no of inning
		List<WebElement>totalin=driver.findElements(By.xpath("div[class=\"cb-col cb-col-100 cb-scrd-itms\"]"));
		//System.out.println("Total no of inning:: "+totalin.size());
		
		  
		   //first In

		 	List<WebElement> indata=in1.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']"));
		 	
		 	
		 	int count1=indata.size();
		 	
	
 		//balls
		int sum1=0;
		for(int i=1;i<count1-3;i++)
		{
			String value1=in1.findElements(By.cssSelector("div[class=\"cb-col cb-col-100 cb-scrd-itms\"] :nth-child(4)")).get(i).getText();
			int ballvalue = Integer.parseInt(value1);
			System.out.println("Ball:: "+ballvalue);
			sum1 = sum1 + ballvalue;
		}
		System.out.println("Total no of ballcount:: "+sum1);
 	}
	
	@Test(priority = 3)
	public void m3()
	{
		WebElement in1=driver.findElement(By.xpath("//*[@id=\"innings_1\"]/div[1]"));
		
		//Total no of inning
		List<WebElement>totalin=driver.findElements(By.xpath("div[class=\"cb-col cb-col-100 cb-scrd-itms\"]"));
		//System.out.println("Total no of inning:: "+totalin.size());
		
		  
		   //first In

		 	List<WebElement> indata=in1.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']"));
		 	
		 	
		 	int count1=indata.size();
		 	
	
 		//4s
		int sum1=0;
		for(int i=1;i<count1-3;i++)
		{
			String value1=in1.findElements(By.cssSelector("div[class=\"cb-col cb-col-100 cb-scrd-itms\"] :nth-child(5)")).get(i).getText();
			int Svalue = Integer.parseInt(value1);
			System.out.println("4S:: "+Svalue);
			sum1 = sum1 + Svalue;
		}
		System.out.println("Total no of 4S:: "+sum1);
	}
	
	@Test(priority = 4)
	public void m4()
	{

		WebElement in1=driver.findElement(By.xpath("//*[@id=\"innings_1\"]/div[1]"));
		
		//Total no of inning
		List<WebElement>totalin=driver.findElements(By.xpath("div[class=\"cb-col cb-col-100 cb-scrd-itms\"]"));
		//System.out.println("Total no of inning:: "+totalin.size());
		
		  
		   //first In

		 	List<WebElement> indata=in1.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']"));
		 	
		 	
		 	int count1=indata.size();
		 	
	
 		//6S
		int sum1=0;
		for(int i=1;i<count1-3;i++)
		{
			String value1=in1.findElements(By.cssSelector("div[class=\"cb-col cb-col-100 cb-scrd-itms\"] :nth-child(6)")).get(i).getText();
			int Svalue = Integer.parseInt(value1);
			System.out.println("6S:: "+Svalue);
			sum1 = sum1 + Svalue;
		}
		System.out.println("Total no of 6S:: "+sum1);
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
