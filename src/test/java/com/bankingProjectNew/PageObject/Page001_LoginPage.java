package com.bankingProjectNew.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page001_LoginPage {
	
	WebDriver driver;
	
	public Page001_LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='uid']")
	@CacheLookup
	WebElement userId;
	public WebElement SetUsername()
	{
		return userId;
		
	}
	
	@FindBy(name="password")
	@CacheLookup
	WebElement passw;
	public WebElement SetPassword()
	{
		return passw;
	}
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement Lbutton;
	public WebElement ClickLoginButton()
	{
		return Lbutton;
	}
	
	@FindBy(name="btnReset")
	@CacheLookup
	WebElement RButton;
	public WebElement ClickResetButton()
	{
		return RButton;
	}
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logout;
	public WebElement logoutClick()
	{
		return logout;
	}
}
