package com.Listners.Tasks.Methods;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestTask implements ITestListener {
	

	public void onStart(ITestContext context)
	{
		System.out.println("This is Onstart----");
	}
	public void onFinish(ITestContext context)
	{
		System.out.println("This is OnFinish");
	}
	public void onTestStart(ITestResult result)
	{
		System.out.println("This is onTestStart");
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("This is onTestSuccess");
	}
	public void onTestFailure(ITestResult result)
	{
		System.out.println("This is onTestFailure");
	}
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("This is onTestSkipped");
	}
	public void failedButWithinSucessPercentage(ITestResult result)
	{
		System.out.println("This is failedButWithinSucessPercentage ");
	}

}
