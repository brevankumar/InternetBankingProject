package com.internetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.internetbanking.pageObjects.AddCustomerPage;
import com.internetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException,IOException
	{

	LoginPage lp=new LoginPage (driver);

	lp.setusername (username); 
	logger.info("username is provided");
	lp.setpassword(password);
	logger.info("password is provided");
	lp.clickSubmit();

	Thread.sleep(3000);

	AddCustomerPage addcust=new AddCustomerPage(driver);

	addcust.clickAddNewCustomer();

	logger.info("providing the customer details......");

	addcust.custName("Pavan");
	addcust.custgender("male");
	addcust.custdob("10","15", "1985"); 
	Thread.sleep(3000);
	addcust.custaddress ("INDIA"); 
	addcust.custcity("HYD");
	addcust.custstate("AP");
	addcust.custpinno("5000074"); 
	addcust.custtelephoneno("987890091");

	String email = randomString()+"@gmail.com";
	addcust.custemailid(email);
	addcust.custpassword("abcedef");
	addcust.custsubmit();

	Thread.sleep(3000);

	logger.info("Validation is Started......");
	boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

	if(res==true)
	{
	Assert.assertTrue(true);
	logger.info("test case is passed......");
	}
	else
	{
	logger.info("test case is failed......");
	captureScreen(driver,"addNewCustomer"); 
	Assert.assertTrue(false);
	}
	}
}



	






	
	
	
	
	
	
	
	
	

