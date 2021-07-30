package com.Task.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Goibibo {
	
	
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
	driver.get("https://www.goibibo.com/hotels/");
}
@BeforeClass
public void maximize()
{
	driver.manage().window().maximize();
}
@Test
public void m1() throws InterruptedException
{
	
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/section[1]/div[1]/div/div[1]/div[1]/input")).click();
	  driver.findElement(By.xpath("//*[@id=\"downshift-1-input\"]")).click();
	  driver.findElement(By.xpath("//*[@id=\"downshift-1-menu\"]/div/ul/li[1]/div")).click();
	  
	  driver.findElement(By.xpath("//*[@id='search-widget-checkin-input']")).click();

		String month = "September 2021";

		while (!driver.findElement(By.xpath("//*[@id='search-widget-calendar-element']/div[2]/div/div/div[1]/div/p"))
				.getText().equals(month)) {

			driver.findElement(
					By.xpath("//*[@id='search-widget-calendar-element']/div[2]/div/div/div[1]/div/div[2]/div")).click();
		}

		List<WebElement> ls = driver.findElements(By.xpath(

				"//*[@id='search-widget-calendar-element']/div[2]/div/div/div[2]/div/div/ul[2]/li/span"));
		Thread.sleep(3000);
		for (WebElement s : ls) {
			if (s.getText().equals("12")) {
				s.click();

			}
			Thread.sleep(3000);
			if (s.getText().equals("16")) {
				s.click();
			}

		}

	}
}