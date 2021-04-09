package com.bankingProjectNew.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.bankingProjectNew.PageObject.Page001_LoginPage;
import com.bankingProjectNew.PageObject.Page002_AddNewCustomerPage;

public class TC004_AddNewCustomerTest extends BaseClass {
	
	
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		Page001_LoginPage lg = new Page001_LoginPage(driver);
		lg.SetUsername().sendKeys("mngr318468");
		lg.SetPassword().sendKeys("ajYsupE");
		lg.ClickLoginButton().click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		logger.info("Loggin successfully into the application");
		
		//driver.switchTo().alert().accept();
		//logger.info("Accept the alert message");
	//	driver.switchTo().defaultContent();
		//logger.info("Control is back to the default window");
		
		Page002_AddNewCustomerPage ac = new Page002_AddNewCustomerPage(driver);
		
		ac.addNewCustomerLink().click();
		logger.info("click on Add New Customer Link");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		
		ac.setCustomerName().sendKeys("Marie Kamo");
		logger.info("Enter customer name");
		
		ac.femaleRadioCheck().click();
		logger.info("click of gender");
		
		ac.setDateOfBirth().clear();
		logger.info("Clear birthday field");
		ac.setDateOfBirth().sendKeys("02122021");
		logger.info("Enter customer birthday");
		
		ac.setCustomerAddress().sendKeys("12 kent st");
		ac.setCustomerCity().sendKeys("Manassas");
		ac.setCustomerState().sendKeys("VA");
		ac.setCustomerPinNumber().sendKeys("123654");
		logger.info("Enter customer address info");
		ac.setCustomerPhoneNumber().sendKeys("5712362514");
		logger.info("Enter customer phone number");
		
		
		
		//Here there is restriction on the email address. Every customer has unique email address. So whenever I enter a new customer
		//every time I have to pass an unique email id. Now here in my test case I have to call the user defined method below that generate 
		//a random string and I use this random string here to make the random email and use it in the sendKeys() method.
		String email=randomestring()+"@gmail.com";
		ac.setCustomerEmail().sendKeys(email);
		logger.info("Enter random email");
		
		
		ac.setPassword().sendKeys("test123");
		logger.info("Enter password");
		
		ac.submitButton().click();
		
		Thread.sleep(3000);
		
		
		
		String addCustSuccessMessage = "Customer Registered Successfully!!!";
		
		if(driver.getPageSource().contains(addCustSuccessMessage))
		{
			Assert.assertTrue(true);
			logger.info("Adding new customer was successful");
		}
		else 
		{
			getScreenShotPath("addNewCustomer", driver);                         //Take Screenshot if the message not present
			Assert.assertTrue(false);
			logger.info("Adding new customer was not successful");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	
	
	//to generate randomly an unique email id, let's create this separate user defined method. This method will return a random string
	//In Java we have a predefined class called RandomStringUtils. And that class has a method randomAlpabetic to generate random character
	//string and randomAlphaNumeric used to generate random numbers. So there are 2 methods.
	public String randomestring()
	{
		RandomStringUtils.randomAlphabetic(5);  //This will generate 5 characters string. Now whatever this statement return I will store that
												//in variable and then I return the variable.
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		
	
	}
		
}
