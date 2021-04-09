package com.bankingProjectNew.TestCases;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.bankingProjectNew.PageObject.Page001_LoginPage;
import com.bankingProjectNew.PageObject.Page003_AddNewAccount;

public class TC005_AddNewAccount extends BaseClass {
	
	
	@Test
	public void addNewCustomerAccountTest() throws InterruptedException
	{
		
		Page001_LoginPage ld = new Page001_LoginPage(driver);
		ld.SetUsername().sendKeys(username);
		ld.SetPassword().sendKeys(password);
		ld.ClickLoginButton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Log successfully into the application");
		
		//Fill out the Add New Account form
		Page003_AddNewAccount newAcctg = new Page003_AddNewAccount(driver);
		
		newAcctg.clickOnNewAccountLink().click();
		logger.info("Navigate to the New Account Page");
		Thread.sleep(5000);
		
		newAcctg.setCustomerID().sendKeys("802");
		logger.info("Enter customer ID");
		
		newAcctg.selectAccountType().selectByIndex(1);
		logger.info("Select the account type");
		
		String number = randomInitialDeposit();                 //Here call the random numerical number method below
		newAcctg.setInitialDeposit().sendKeys(number);
		logger.info("Enter a random initial deposit");
		
		Thread.sleep(5000);
		
		newAcctg.clickOnSubmitButton().click();
		logger.info("Submit the new account form");
		
		Thread.sleep(10000);
		
		String NewAccountSuccessfullyMessage="Account Generated Successfully!!!";
		
		if (driver.getPageSource().contains(NewAccountSuccessfullyMessage))
		{
			Assert.assertTrue(true);
			logger.info("Addition of an account was successful");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Addition of an account was not successful");
		}
		
		
		
		
		
	}
	
	
	//user defined method to generate random initial deposit. Class RandomStringUtils from Apache Commons and its method 
	//randomAlphanumeric. We store this random number in a variable generatedString. And we return this variable to be use
	//in the above method
	public String randomInitialDeposit()
	{
		String generatedInteger=RandomStringUtils.randomNumeric(4);
		
		
		return generatedInteger;
	}
		
					
}
	
	
	
	
	


