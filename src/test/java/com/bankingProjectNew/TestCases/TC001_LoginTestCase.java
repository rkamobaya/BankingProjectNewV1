package com.bankingProjectNew.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankingProjectNew.PageObject.Page001_LoginPage;

public class TC001_LoginTestCase extends BaseClass{              
	//Whenever we create a new Test case, we must extend the BaseClass because the BaseClass contains commons resources which 
	//are required for every test case.
	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
	
		Page001_LoginPage lg = new Page001_LoginPage(driver);
		lg.SetUsername().sendKeys(username);
		logger.info("Enterring the userID");
		lg.SetPassword().sendKeys(password);
		logger.info("Enterring the password");
		Thread.sleep(3000);
		lg.ClickLoginButton().click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Guru99 Bank Manager HomePage";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void validateHomePageTitle() throws IOException
	{
		//captureScreen(driver, "validateHomePageTitle");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Guru99 Bank Manager HomePage";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
}
