package com.bankingProjectNew.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.bankingProjectNew.Utilities.ExtentReporterNG;

//for the method getScreenShotPath() to work in this class Listeners, Listeners class has to inherent BaseClass
public class Listeners extends BaseClass implements ITestListener{            
	
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	
	public void onTestStart(ITestResult result) {
		// Before the test start the control come to this method and this bloc of code in this method gets executed
		test = extent.createTest(result.getMethod().getMethodName());   
		
	}


	public void onTestSuccess(ITestResult result) {
		// Whenever there is success in the test execution control come to this method and this bloc of code gets executed
		WebDriver driver = null;
		test.log(Status.PASS, "Test passed");
		
		
	}

	
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());       //failure log will be retrieved and will be sent to this method so that in your report U see all the failure
		
		//Before taking the screenshot we just have to capture the name of the failed test name dynamically 
		String testMethodName =result.getMethod().getMethodName();  
		
		
		//The driver in getScreenShotPath() method does not have any life. That's the driver we just assign in number 33 of BaseClass
		//But the real life of driver is having in the real test (that failed). To take the screenshot we should have access to that 
		//driver which is present in that failed test method. Then screenshot will be taken for that specific browser which is opened
		//So we need to capture that driver and send that driver as input to getScreeenShotPath() method below. 
		//This driver is nothing but one of the field of that class that contains the failed test.
		//In TestNG there is a step to get access to the fields of class where your test got failed. following is code I just copy and 
		//paste here. It's just one time code. result.getTestClass().getRealClass().getDeclaredField("fieldName").get(result.getInstance());
		// where fieldName is driver (in the failed test). And that you need to cast the all code with (WebDriver). 
		//This way you can create a dummy webdriver which does not a real life ------> WebDriver driver = null; see above in onTestStart() method
		//And then you give a real life to that dummy driver by making it equal to the all code driver=(webDriver)result.getT......
		//And then you surround everything with try/catch bloc. Many try/catch blocs but you need to erase everything and to keep only one
		//standard exception e.
		try 
		{
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (Exception e)
		{
		
		}
		
	
		try 
		{
			//Initially, we take the screenshot by calling the method below the BaseClass where testCaseName=testMethodName=result.getMethod.getMethodName above
			//getScreenShotPath(testMethodName, driver)
			//As String imagePath in addScreenCaptureFromPath() method, in the BaseClass we have to return the destinationPath. Then the return type of 
			//getScreenShotPath() become String. And then we just have to call the method getScreenShotPath() in below code in lieu of argument String ImagePath
			test.addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver) , result.getMethod().getMethodName());
			
			
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	public void onTestSkipped(ITestResult result) {
		// Whenever there is skip in the test execution control come to this method and this bloc of code gets executed


		
		
	}


	public void onFinish(ITestContext context) {
		extent.flush();
		
	}


	

}
