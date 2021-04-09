package com.bankingProjectNew.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bankingProjectNew.PageObject.Page001_LoginPage;
import com.bankingProjectNew.Utilities.XLUtils;

public class TC002_LoginDataDrivenWithExcel extends BaseClass {
	
	//1- Valid scenario: valid username and valid password, User should navigate to the home page---> title: "Guru99 Bank Manager HomePage"
	//2- Invalid scenario: invalid username and invalid password, system should display alert popup saying ------> "User and Password not valid"
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String username, String password) throws InterruptedException
	{
		Page001_LoginPage lp = new Page001_LoginPage(driver);
		lp.SetUsername().sendKeys(username);
		logger.info("Enterred username");
		lp.SetPassword().sendKeys(password);
		logger.info("Enterred password");
		lp.ClickLoginButton().click();
		
		Thread.sleep(5000);
		
		if (isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			logger.warn("Test failed");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Loggin successfully");
			lp.logoutClick().click();
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
		
		
		public boolean isAlertPresent()   //simple user defined method created to check alert is present or not.Suppose in the future we have few 
		{								   //more test cases where we have to verify if alert is present or not, then we have to make this method  
			try								//part of our BaseClass
			{
			driver.switchTo().alert();
			return true;
			}
			catch(NoAlertPresentException e)
			{
				return false;
			}
		}
	
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		//path of our excel file in the project
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\bankingProjectNew\\TestData\\data1.xlsx";
		
		//Now here we need to get the data from the excel file. And store the data in 2 dimensions array. And return the data from 2 dimensions array
		//to the actual test method to use it. To do that we need to read XUtils method. We need to count number of rows
		//and number of columns. Since the XLUtils methods are declared static, we can call the methods with class name and method. 
		////Since the method is static to call the method -------> ClassName.Method
		int rownum = XLUtils.getRowCount(path, "sheet1");        
		int colcount = XLUtils.getCellCount(path, "sheet1", 1);
		
		//Now we need to create 2 dimension array to read the data from excel because the data need to be stored in 2 dimension array.
		String logindata[][] = new String[rownum][colcount];
		
		//we know the number of rows rownum and number of columns colcount, now we need to write a For loop to get the data
		for(int i=1; i<rownum; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
				
			}
			
			
			
			
		}
		return logindata;                     //By the time this for loop is completed the logindata contains all the data from excel sheet
										      //then we have to return logindata so our test case can use it.
		//Now go to the @test and write our test
		
	}

}
