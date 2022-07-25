package com.netbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath ="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(name = "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(name = "rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(name = "dob")
	@CacheLookup
	WebElement txtDateofbirth;
	
	@FindBy(name = "addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(name = "city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(name = "state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(name = "pinno")
	@CacheLookup
	WebElement txtPin;
	
	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement txtTelephoneno;
	
	@FindBy(name = "emailid")
	@CacheLookup
	WebElement txtEmailid;
	
	@FindBy(name = "sub")
	@CacheLookup
	WebElement btnSubmit;
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}
	
	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void Gender(String gender) {
		rdGender.click();
	}
	
	public void DOB(String mm, String dd, String yyyy) {
		txtDateofbirth.sendKeys(mm);
		txtDateofbirth.sendKeys(dd);
		txtDateofbirth.sendKeys(yyyy);
	}
	
	public void Address(String custadd) {
		txtAddress.sendKeys(custadd);
	}
	public void City(String city) {
		txtCity.sendKeys(city);
	}
	public void State(String state) {
		txtState.sendKeys(state);
	}
	public void Pin(String pinno) {
		txtPin.sendKeys(String.valueOf(pinno));
	}
	public void Mobno(String mono) {
		txtTelephoneno.sendKeys(mono);
	}
	public void Emailid(String emailid) {
		txtEmailid.sendKeys(emailid);
	}
	public void Submit() {
		btnSubmit.click();
	}
}
