package com.internetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	 public LoginPage (WebDriver rdriver)
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement txtusername;
	
    
	@FindBy(name="password")
	WebElement txtpassword;
	
    
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement lnklogout;
	
	
	
	
	public void setusername(String uname)
	{
		txtusername.sendKeys(uname);
	}
	
	public void setpassword(String password)
	{
		txtpassword.sendKeys(password);
	}
	
	public void clickSubmit() 
	{
		btnLogin.click();
		
	}
	
	public void clicklogout()
	{
		lnklogout.click();
	}
	
}
