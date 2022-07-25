package com.netbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netbanking.pageobjects.AddCustomerPage;
import com.netbanking.pageobjects.LoginPage;

public class TC_AddNewCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clicksubmit();
		
		AddCustomerPage cp = new AddCustomerPage(driver);
		cp.clickAddNewCustomer();
		Thread.sleep(3000);
		
		logger.info("Providing customer details---- ");
		
		cp.custName("vaibhav");
		cp.DOB("12", "15", "1998");
		Thread.sleep(3000);
		cp.Address("India");
		cp.City("pune");
		cp.State("maha");
		cp.Pin("411005");
		cp.Mobno("9585754862");
		
		//generate email id dynamically
		String email = randomestring()+"@gmail.com";
		cp.Emailid(email);
		cp.Submit();
		
		Thread.sleep(3000);
		
		logger.info("validation started---- ");
	/*	
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("test case passed");
		}
		else {
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("test case failed");
		} */
	}
	
	//Dynamically generate random data
	//generate email id dynamically
	
}
