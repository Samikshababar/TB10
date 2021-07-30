package com.Listners.Tasks;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners( com.Listners.Tasks.Methods.ITestTask.class)
public class JpetRegister {
	
	WebDriver driver;
	@BeforeSuite
	public void chrome()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Samiksha\\Desktop\\testing\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
	}
	@BeforeTest
	public void url()
	{
		driver.get("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
	}
	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void getcookie()
	{
		Set<Cookie>s=driver.manage().getCookies();
		System.out.println("Count of cookies:: "+s.size());
	}
	@Test(dataProvider = "registerdata")
	public void register(String uname,String pass,String cpass,String name,String lname,String email,String phone,String add1,String add2,String city,String state,String zip,String country,String lang,String catagory)
	{
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		Assert.assertEquals("https://petstore.octoperf.com/actions/Account.action?newAccountForm=", url);
		
		 driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr/td[2]/input[1]")).sendKeys(uname);;
	      
	     driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(pass);;
	      
	      driver.findElement(By.xpath("//input[@name=\"repeatedPassword\"]")).sendKeys(cpass);;
	      
	      driver.findElement(By.xpath("//input[@name=\"account.firstName\"]")).sendKeys(name);;
	      driver.findElement(By.xpath("//input[@name=\"account.lastName\"]")).sendKeys(lname);;
	      driver.findElement(By.xpath("//input[@name=\"account.email\"]")).sendKeys(email);;
	      
	      driver.findElement(By.xpath("//input[@name=\"account.phone\"]")).sendKeys(phone);;
	      driver.findElement(By.xpath("//input[@name=\"account.address1\"]")).sendKeys(add1);;
	      driver.findElement(By.xpath("//input[@name=\"account.address2\"]")).sendKeys(add2);;
	      driver.findElement(By.xpath("//input[@name=\"account.city\"]")).sendKeys(city);;
	      driver.findElement(By.xpath("/html/body/div[2]/div/form/table[2]/tbody/tr[8]/td[2]/input[1]")).sendKeys(state);;
	      driver.findElement(By.xpath("//input[@name=\"account.zip\"]")).sendKeys(zip);;
	      driver.findElement(By.xpath("//input[@name=\"account.country\"]")).sendKeys(country);;
	      
	      WebElement sel=driver.findElement(By.xpath("//select[@name=\"account.languagePreference\"]"));
			 Select s=new Select( sel);
			 s.selectByVisibleText(lang);;
			 
			 WebElement sel1=driver.findElement(By.xpath("//select[@name=\"account.favouriteCategoryId\"]"));
			 Select s1=new Select( sel1);
			 s1.selectByVisibleText(catagory);
			 
			 
			 driver.findElement(By.xpath("//input[@name=\"account.listOption\"]")).click();;
			 driver.findElement(By.xpath("//input[@name=\"account.bannerOption\"]")).click();;;
			 
			 
			 driver.findElement(By.xpath("//input[@name=\"newAccount\"]")).click();;;
	      
	     
	}
	@DataProvider(name="registerdata")
	public Object[][] demo()
	{
		return new Object[][]
				{
			{"Sam@123","12345678","12345678","Samiksha","Babar","Sam@gmail.com","9850549906","hadapsar","pune","pune","Maharashtra","411028","India","english","CATS"}
				};
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
