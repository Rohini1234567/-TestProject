package com.ap.qa.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.qa.base.TestBase;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.LoginPage;

public class LoginPageTest extends TestBase 
{
	HomePage homePage;
	LoginPage loginPage;
	public LoginPageTest() throws IOException 
	{
		super();
		
	}
	
	@BeforeMethod
	public void Setup() throws IOException 
	  {
		  
			Initialization();
		    homePage=new HomePage();
		    loginPage=homePage.OpenLoginPage();
		  //loginPage=new LoginPage();
		  
	  }

  
	@Test(priority=1)
	  public void LoginPageTitleTest() 
	  {
		String title = LoginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login - My Store","LoginPagetitle not matched");
		 
	  }
  
	@Test(priority=2)
    public void Login_User() throws IOException 
     {
	  homePage = loginPage.Login(prop.getProperty("email"), prop.getProperty("password"));
//	  String Title=LoginPage.validateLoginPageTitle();
//	  Assert.assertEquals(Title, "My account - My Store");
	  
     }
	
//	@Test(priority=3)
//	public void Return_home() throws IOException 
//	{
//		homePage = loginPage.Login(prop.getProperty("email"), prop.getProperty("password"));
//		homePage=LoginPage.returnToHome();
//		
//	}
//	
	@Test(priority=3)
	public void verify_User() throws IOException 
	{
		homePage = loginPage.Login(prop.getProperty("email"), prop.getProperty("password"));
		Assert.assertTrue(LoginPage.validateUser());
		
	}
	
  
  
  @AfterMethod
  public void tearDown() 
  {

	  //driver.quit();
  }
}
