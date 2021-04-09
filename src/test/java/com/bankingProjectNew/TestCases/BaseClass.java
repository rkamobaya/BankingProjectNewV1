package com.bankingProjectNew.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.bankingProjectNew.Utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	//This BaseClass will contain all the methods and variable that are common to all the test cases
	//Ex: Driver initialization, login credential for the application, setup method, tearDown method, etc ......
	
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;                               //Why make WebDriver static???????
	
	Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver = new ChromeDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", readconfig.getInternetExplorerPath());
			driver = new InternetExplorerDriver();
		}
		else if (br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
			driver = new EdgeDriver();
		}
		else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getGeckoPath());
			driver = new FirefoxDriver();
		}
		
		driver.get(readconfig.getApplicationURL());
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		logger.info("Url is opened");
	
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	//This a user defined method. We don't put any testNG annotation for that. We will call this method in our test case only in case of test failure
	//We will need to pass argument driver and test name. 
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		//Convert webdriver object of TakeScreenshot. We change the type of driver to takescreenshot
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		//Call getScreenshotAs method to take the screenshot. This method will take the screenshot and save it in the format of file
		//And the file is saved at the location source which is a virtual location. source is a dummy location. We are not able to access 
		//this location because it is a vertual location. We have to transfer that screenshot from source location to our desired 
		//location ie target location
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destinationPath = System.getProperty("user.dir")+"\\Screenshots\\"+testCaseName+".png";
		
		//we create the target file (desired location)
		//testCaseName is the name of the screenshot which is generally the name of the test. This name is created dynamically in the onTestFailure
		//method in the Listeners class. 
		//File DestinationPath = new File(target);
		
		//And we copy the screenshot image from source file (virtual location) to target file (desired location) and store in the system
		//In the latest version of Selenium U will get an error when U write FileUtils. In that case U have to import a package 
		//called apache commons io Jar. In earlier version Selenium had this dependencies but in the latest version not. So you have to 
		//separately download these dependencies into your project
		FileUtils.copyFile(source, new File(destinationPath));
		System.out.println("Screenshot taken");
		
		return destinationPath;
		
		
		
		
	}
}
