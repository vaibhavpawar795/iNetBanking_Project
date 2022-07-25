package com.netbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadingConfig {
	
	Properties pro;
	
	public ReadingConfig()
	{	File src = new File("./configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	public String getApplicationURL() {
		  String url = pro.getProperty("baseURL");
		  return url;
	}
	public String getUsername() {
		  String username = pro.getProperty("userName");
		  return username;
	}
	public String getPassword() {
		  String password = pro.getProperty("password");
		  return password;
	}
	public String getchromepath() {
		  String chromepath = pro.getProperty("chromepath");
		  return chromepath;
	}
	public String getedgepath() {
		  String edgepath = pro.getProperty("edgepath");
		  return edgepath;
	}

}
