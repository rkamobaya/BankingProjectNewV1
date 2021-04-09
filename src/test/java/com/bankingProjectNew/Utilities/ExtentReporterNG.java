package com.bankingProjectNew.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReporterNG {
	
	static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
	
	String path = System.getProperty("user.dir")+"\\Reports\\index.html";
	ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
	reporter.config().setReportName("Web Automation Results");
	reporter.config().setDocumentTitle("Test Results");
	
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Rene Kamobaya");
	extent.setSystemInfo("Environment", "QA");
	extent.setSystemInfo("Host", "Localhost");
	
	return extent;        //Basically all your test cases need this extent object. That's why we need to return it so all the test cases can use it
	
	
	//Now in every test when the execution starts, initially in the 1st step we are creating test----> extent.createTest("testName");
	//That way in your reporting file one entry is created for your test method. And that reporting file will be listening to 
	//your results. If it is passed then that entry of test case will be marked as PASS. If not it will report as FAIL
	//So for any test you have to create that entry (extent.createTest(testName)) and give that knowledge to your extent report.
	//Let say we have 500 test cases, it will be difficult to write this entry (Extent test = extent.createTest(testName)) in the 
	//beginning of each of test cases. We will write just at one place in Listeners class, in onTestStart() method so it can work for 
	//every test case. And every test can have one entry.
	
	}
			

}
