package com.internetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import com.internetbanking.utilities.ReadConfig;

public class BaseClass {

	
	ReadConfig readconfig=new ReadConfig();

	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername(); 
	public String password=readconfig.getPassword(); 
	public static WebDriver driver;

	public static Logger logger;


	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		 logger = Logger.getLogger("ebanking");
		 PropertyConfigurator.configure("Log4j.properties");
	 
		
		 if(br.equals("chrome"))
		 {
		 System.setProperty("webdriver.chrome.driver", readconfig.getChromePath()); 
		 driver=new ChromeDriver();
		 }


		 else if(br.equals("ie"))

		 {
		 System.setProperty("webdriver.ie.driver", readconfig.getIEPath()); 
		 driver = new InternetExplorerDriver();
		 }
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get(baseURL);		 
		 }
	 


	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public void captureScreen (WebDriver driver, String tname) throws IOException 
	
	{ 
	
	TakesScreenshot ts = (TakesScreenshot) driver; 
	File source = ts.getScreenshotAs (OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/"+tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
}
	
	public String randomString()
	{
	String generatedstring = RandomStringUtils.randomAlphabetic(8);
	return(generatedstring);
	}

	public static String randomNum()
	{
	String generatedstring2 = RandomStringUtils.randomNumeric(4);
	return(generatedstring2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
