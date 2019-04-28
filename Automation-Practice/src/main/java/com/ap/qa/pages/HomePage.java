package com.ap.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.qa.base.TestBase;

public class HomePage extends TestBase
{
	public HomePage() throws IOException 
	{
		//super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(className="login")
	WebElement Signin;
	
	
	
	//Actions
	
		public String validateHomePageTitle() 
		{
			return driver.getTitle();
			
		}
		
		public LoginPage OpenLoginPage() throws IOException
		{
			Signin.click();
			return new LoginPage();
		}

}
