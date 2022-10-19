package com.internetbanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.internetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void logintest() throws IOException 
	{
		logger.info("URL is opened");
		
		
		LoginPage lp = new LoginPage(driver);
		lp.setusername(username);
		logger.info("Enter Username");
		
		lp.setpassword(password);
		logger.info("Enter password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("login test failed");

		}
		
	}
}
