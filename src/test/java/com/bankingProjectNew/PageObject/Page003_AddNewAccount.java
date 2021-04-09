package com.bankingProjectNew.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Page003_AddNewAccount {
	
	WebDriver driver;
	
	public Page003_AddNewAccount(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='New Account']")
	WebElement newAcct;
	public WebElement clickOnNewAccountLink()
	{
		return newAcct;
	}
	
	@FindBy(name="cusid")
	WebElement custID;
	public WebElement setCustomerID() 
	{
		return custID;
	}
	
	@FindBy(name="selaccount")
	public WebElement acctgT;
	public Select selectAccountType()
	{
		return new Select(acctgT);
	}
	
	@FindBy(name="inideposit")
	WebElement initdep;
	public WebElement setInitialDeposit()
	{
		return initdep;
	}
	
	@FindBy(name="button2")
	WebElement submit;
	public WebElement clickOnSubmitButton()
	{
		return submit;
	}
	
	@FindBy(name="reset")
	WebElement res;
	public WebElement cliclOnResetButton()
	{
		return res;
	}
	

}
