package com.netbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netbanking.pageobjects.LoginPage;
import com.netbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider = "iNetBanking-Data")
	public void LoginDDT(String user,String pwd) throws InterruptedException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clicksubmit();
		
		Thread.sleep(3000);
		
/*		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("login passed");
			JavascriptExecutor jex = (JavascriptExecutor)driver;
			jex.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			lp.clicklogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //close the logout alert
			driver.switchTo().defaultContent();
		}
	}
	
	
	public boolean isAlertPresent() //user defined method created to check alert present or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	*/
	}
	
	@DataProvider(name ="iNetBanking-Data")
	String [][] getData() throws IOException 
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/netbanking/testdata/iNetBanking-Data.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j); //1,0
			}
		}
		return logindata;
	}

}
