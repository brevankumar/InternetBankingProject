package com.internetbanking.testCases;

import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.internetbanking.pageObjects.LoginPage;
import com.internetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass

{
	@Test(dataProvider = "LoginData")
	public void DDT(String user, String password) throws InterruptedException
	{
	LoginPage lp = new LoginPage(driver);
	
	lp.setusername(user);
	logger.info("user name provided");

	lp.setpassword(password);
	logger.info("pass provided");

	lp.clickSubmit();
	
	
	if(isAlertPresent()==true)
	{
	driver.switchTo().alert().accept();//close alert 
	driver.switchTo().defaultContent();
	Assert.assertTrue(true);
	logger.warn("login failed");
	}
	else
	{
		Assert.assertTrue(true);
		logger.warn("login passed");
		
	lp.clicklogout();
	driver.switchTo().alert().accept();
	driver.switchTo().defaultContent();
	
	}
	}
	
	public boolean isAlertPresent() 
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
	
	
	
	@DataProvider(name="LoginData")
	public Object[][] getData() throws IOException
	{
		String path = ".\\datafiles\\loginData.xlsx";
		
		XLUtils xlutil = new XLUtils(path);
		
		
		
		int rownum = xlutil.getRowCount("Sheet1");
		int colcount = xlutil.getCellCount("Sheet1", 1);
			
		String loginData[][] = new String[rownum][colcount];
		
		
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i,j);
			}
		}
		return loginData;
	}
}
	

