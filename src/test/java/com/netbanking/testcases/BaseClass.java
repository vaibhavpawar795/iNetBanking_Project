package com.netbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.netbanking.utilities.ReadingConfig;

public class BaseClass {
	ReadingConfig readconfig =  new ReadingConfig();
	
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password =  readconfig.getPassword();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void setup(String browser) 
	{		
		logger= Logger.getLogger("ebanking");
		PropertyConfigurator.configure("D:\\photon eclipse\\iNetBanking_Project\\log4j.properties");
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
			driver = new ChromeDriver();	
		} else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getchromepath());
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.edge.driver", readconfig.getedgepath());
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
    }
	@AfterClass(alwaysRun = true)
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/screenshots/"+ tname +".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
	}
	
	//Dynamically generate random data
	//generate email id dynamically
	public String randomestring()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum()
	{
		String generatedstring2 = RandomStringUtils.randomNumeric(4);
		return(generatedstring2);
	}
	
	
}
