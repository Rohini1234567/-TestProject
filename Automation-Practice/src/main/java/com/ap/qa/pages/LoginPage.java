package com.ap.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.qa.base.TestBase;

public class LoginPage extends TestBase
{
	public LoginPage() throws IOException 
	{
		super();
		PageFactory.initElements(driver, this);
		
		
	}
	
	//Page Factory- OR
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="passwd")
	WebElement passwd;
	
	@FindBy(name="SubmitLogin")
	WebElement Signin;
	
	@FindBy(className="icon-home")
	static
	WebElement returnHome;
	
	@FindBy(xpath="//span[contains(text(),'Tom Keller')]")
	static
	WebElement account_name;
	
	//Actions
	public static String validateLoginPageTitle() 
	{
		return driver.getTitle();
		
	}
	
	public HomePage Login(String em, String pwd) throws IOException 
	{
		email.sendKeys(em);
		passwd.sendKeys(pwd);
		Signin.click();
		return new HomePage();
		
	}
	
	public static HomePage returnToHome() throws IOException 
	{
		
		returnHome.click();
		return new HomePage();
	}
	
	public static boolean validateUser()
	{
		return account_name.isDisplayed();
		
		
	}
	
	
	
	
	
	
	

	


}
