package com.bankingProjectNew.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.bankingProjectNew.PageObject.Page001_LoginPage;

public class TC003_LoginTestDataProvider extends BaseClass{
	
	
	

	@Test(dataProvider="LoginData")
	public void loginTest(String username, String password) throws InterruptedException
	 {
		Page001_LoginPage lp = new Page001_LoginPage(driver);
		lp = new Page001_LoginPage(driver);
		lp.SetUsername().sendKeys(username);
		logger.info("Enterred username");
		lp.SetPassword().sendKeys(password);
		logger.info("Enterred password");
		lp.ClickLoginButton().click();
		
		Thread.sleep(5000);
		
		String welcomeLoginURL= "http://demo.guru99.com/v4/manager/Managerhomepage.php";
		String actualLoginURL = driver.getCurrentUrl();
		
		if (actualLoginURL.equals(actualLoginURL))
		{
			logger.info("Login is successful");
			lp.logoutClick().click();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		else
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.warn("login unsucessful");
			
		}
	
	  }
	
	
	
	
	
	@DataProvider(name="LoginData")
	public Object[][] logindata()
	{
	
	//We need to create Object type array in which we are going to store our input data
	Object[][] data = new Object[4][2];
	data[0][0] = "mngr318468";
	data[0][1] = "ajYsupE";
	data[1][0] = "jean235s";
	data[1][1] = "adumYsa";
	data[2][0] = "lpo625k";
	data[2][1] = "sial;a";
	data[3][0] = "mngr318468";
	data[3][1] = "ajYsupE";
	
	return data;
	}

}



