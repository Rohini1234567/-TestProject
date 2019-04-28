package com.ap.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.qa.base.TestBase;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.LoginPage;

public class HomePageTest extends TestBase 
{
	public HomePageTest() throws IOException 
	{
		super();
		
	}

	LoginPage loginPage;
	HomePage homePage;
  
  
  @BeforeMethod
  public void Setup() throws IOException 
  {
	  
		Initialization();
	    homePage=new HomePage();
	    loginPage=new LoginPage();
	    
	  //loginPage=new LoginPage();
	  
  }
  
  
  @Test
  public void HomePageTitleTest() 
  {
	  String Title=homePage.validateHomePageTitle();
	  Assert.assertEquals(Title, "My Store");
	 
  }
  
  @Test
  public void SigninTest() throws IOException 
  {
	  loginPage=homePage.OpenLoginPage();
	  
	  
  }
  
  public void Return_home() throws IOException 
	{
		
		homePage=LoginPage.returnToHome();
		
	}
  
  @Test
  public void LoginTest() throws IOException 
  {
	  homePage=loginPage.Login(prop.getProperty("email"), prop.getProperty("password"));
	  
  }
  
  @AfterMethod
  public void tearDown() 
  {

	  //driver.quit();
  }

}
