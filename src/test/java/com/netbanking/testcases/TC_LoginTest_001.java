package com.netbanking.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netbanking.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass 
{	@Test
	public void loginTest() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clicksubmit();
		
	}

}
