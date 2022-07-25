package com.netbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.*;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reportings extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext)
	{
		String timestamp = new SimpleDateFormat("dd.mm.yyyy.mm.ss").format(new Date()); //time stamp
		String reportName="Test-Report-"+ timestamp +".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/" +reportName +".html");
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/extentx-config.xml");
		//htmlReporter.loadConfig(System.getProperty("user.dir")+"/test-output/" +reportName +".html");
				
		htmlReporter.config().setDocumentTitle("iNetBanking Test Project"); //Title of Report
	    htmlReporter.config().setReportName("Functional Test Report"); //name of the report
	   // htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
	    htmlReporter.config().setTheme(Theme.DARK);
	    
        extent =  new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Host name", "LocalHost");  
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "vaibhav");

	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger = extent.createTest(tr.getName()); //create new entry in report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); //sent the passed information to report
		
		String screenshotPath=System.getProperty("user.dir")+"\\screenshots\\"+tr.getName()+".png";
		
		File f = new File(screenshotPath);
		
		if(f.exists()) 
		{
		try {
			logger.fail("Screenshot is below: " + logger.addScreenCaptureFromPath(screenshotPath));
		    }
		catch (IOException e)
		    {
			e.printStackTrace();
		    }
		}
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
}
