package com.bankingProjectNew.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page002_AddNewCustomerPage {
	
	WebDriver driver;
	
	
	public Page002_AddNewCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="New Customer")
	WebElement newcustLink;
	public WebElement addNewCustomerLink()
	{
		return newcustLink;
	}
	
	@FindBy(name="name")
	WebElement custName;
	public WebElement setCustomerName()
	{
		return custName;
	}
	
	@FindBy(xpath="//input[@name='rad1' and @value='m']")
	WebElement radio1;
	public WebElement maleRadioCheck()
	{
		return radio1;
	}
	
	@FindBy(xpath="//input[@name='rad1' and @value='f']")
	WebElement radio2;
	public WebElement femaleRadioCheck()
	{
		return radio2;
	}
	
	@FindBy(id="dob")
	WebElement dbirth;
	public WebElement setDateOfBirth()
	{
		return dbirth;
	}
	
	@FindBy(name="addr")
	WebElement address;
	public WebElement setCustomerAddress()
	{
		return address;
	}
	
	@FindBy(name="city")
	WebElement city;
	public WebElement setCustomerCity()
	{
		return city;
	}
	
	@FindBy(name="state")
	WebElement state;
	public WebElement setCustomerState()
	{
		return state;
	}
	
	@FindBy(name="pinno")
	WebElement pin;
	public WebElement setCustomerPinNumber()
	{
		return pin;
	}
	
	@FindBy(name="telephoneno")
	WebElement phone;
	public WebElement setCustomerPhoneNumber()
	{
		return phone;
	}
	
	@FindBy(name="emailid")
	WebElement email;
	public WebElement setCustomerEmail()
	{
		return email;
	}
	
	@FindBy(name="password")
	WebElement passw;
	public WebElement setPassword()  
	{
		return passw;
	}
	
	@FindBy(name="sub")
	WebElement submit;
	public WebElement submitButton()
	{
		return submit;
	}
	
	
	
	
	
	
	
	

}
