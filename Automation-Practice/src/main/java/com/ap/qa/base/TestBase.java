package com.ap.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase
{
	public static WebDriver driver;
	public static Properties prop;
	public TestBase() 
	{
        prop=new Properties();
		
		//InputStream ip = getClass().getResourceAsStream("C:\\Users\\Rohini Parle\\eclipse-workspace\\AutomationPractice\\src\\main\\config.properties");
		FileInputStream ip;
		try {
			ip = new FileInputStream("C:\\Users\\Rohini Parle\\eclipse-workspace\\Automation-Practice\\src\\main\\java\\com\\ap\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//System.out.println(prop);
		
		
		
		
	}
	
	public static void Initialization()  
	{
		
       
		String browserName= prop.getProperty("Browser");
		
		
		if(browserName.equals("chrome"))
		{
			String exePath = "D:\\Rohini\\Selenium\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver" , exePath);
			driver = new ChromeDriver();
			//driver.manage().window().maximize();
			
		}
		else if(browserName.equals("IE")) 
		{
			String exePath = "D:\\Rohini\\Selenium\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver" , exePath);
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS); //dynamic wait- wait and remaining ignored
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);// always applied globally-available for all web elements
		//System.out.println(prop.getProperty("url"));
		
		driver.get(prop.getProperty("url"));
	}

}
