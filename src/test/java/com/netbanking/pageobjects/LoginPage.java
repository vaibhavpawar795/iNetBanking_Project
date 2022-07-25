package com.netbanking.pageobjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
User ID :	mngr426413
Password :	epEqabu
*/

public class LoginPage {  
	WebDriver ldriver; 
	public LoginPage(WebDriver rdriver) 
	{	ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	/*
	@FindBy(xpath ="//a[@href='Logout.php']")
	@CacheLookup
	WebElement lnklogout;
	*/
	public void setUserName(String uname)
	{
		txtUsername.sendKeys(uname);
	}
	public void setPassword(String pwd) 
	{
		txtPassword.sendKeys(pwd);
	}
	public void clicksubmit() 
	{
		btnLogin.click();
	}
	/*
	public void clicklogout() 
 	{
		lnklogout.click();
	}
   */

}
