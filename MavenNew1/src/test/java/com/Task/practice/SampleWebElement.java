package com.Task.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
@Listeners(com.Listners.Tasks.Methods.ITestTask.class)
public class SampleWebElement {
	
	WebDriver driver;
	  @BeforeSuite
	  public void openBrowser()
	  {
		    System.setProperty("webdriver.chrome.driver","C:\\Users\\samiksha\\Desktop\\testing\\chromedriver_win32\\chromedriver.exe");
		    driver=new ChromeDriver();
	  }
	  
	  @BeforeTest
	  public void ApplicationURL()
	  {
		 
			driver.get("http://demowebshop.tricentis.com/login");
			
	  }


	        //Assertion
		    Assertion as=new Assertion();
			   
		@BeforeClass
		public void minimizeBrowser()
		{
			driver.manage().window().maximize();
		}
		@Test
		public void loginData() 
		{
		    //driver.get("http://demo.guru99.com/test/newtours/");
			//driver.navigate().to("http://demowebshop.tricentis.com/");
			
			driver.get("http://demowebshop.tricentis.com/login/");
			
			String url=driver.getTitle();
			System.out.println("URL is :- " +url);
			 
			//getText
			String gettext=driver.getTitle();
			System.out.println("URL is :- " +gettext);
			
			
			as.assertEquals("Demo Web Shop. Login", url);
			  
			driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("bhavi@gmail.com");
			driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("abc123");
			driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
			System.out.println("login sucefully");
			driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a")).click();

			//getLocation()
			//  Point location = driver.findElement(By.id("Email")).getLocation();
			//  System.out.println("Location of X :"+ location.getX()+ "," +"Location of Y :" +location.getY());
		  
			  //getEnabled()
			 // driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).isEnabled();	
	    }
		//isDisplayed() 
		@Test
		public void Book()
		{
			driver.get("http://demowebshop.tricentis.com/books");
			
			driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input")).click();
		
			WebElement bookpic=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[1]/a/img"));
			Boolean pic=bookpic.isDisplayed();
			System.out.println(pic);
			
			
			SoftAssert sf=new SoftAssert();
			Boolean b=true;
		    sf.assertEquals(pic,b);
		    System.out.println("Display sucessfully");
	      	sf.assertAll();
	      	
		}

}
